package com.boarhat.authorization_server.service;

import com.boarhat.authorization_server.controller.dto.UserCreateDTO;
import com.boarhat.authorization_server.controller.dto.UserOtpDTO;
import com.boarhat.authorization_server.entity.Otp;
import com.boarhat.authorization_server.entity.User;
import com.boarhat.authorization_server.repository.OtpRepository;
import com.boarhat.authorization_server.repository.UserRepository;
import com.boarhat.authorization_server.util.GenerateCodeUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final OtpRepository otpRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, OtpRepository otpRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addUser(UserCreateDTO userCreateDTO) {
        User user = new User(
                userCreateDTO.username(),
                passwordEncoder.encode(userCreateDTO.password())
        );

        userRepository.save(user);
    }

    @Transactional
    public void createOtp(UserCreateDTO userCreateDTO) {
        User user = userRepository.findByUsername(userCreateDTO.username())
                .filter(u -> passwordEncoder.matches(userCreateDTO.password(), u.getPasswordHash()))
                .orElseThrow(() -> new RuntimeException("Username " + userCreateDTO.username()));

        // Generate OTP
        String token = GenerateCodeUtil.generateCode();
        logger.info("Generating OTP for user {}, token -> {}", userCreateDTO.username(), token);

        Otp otp = new Otp(user, token);

        otpRepository.save(otp);
    }

    @Transactional
    public boolean checkOtp(UserOtpDTO userOtpDTO) {
        Otp otp = otpRepository.findByUsername(userOtpDTO.username())
                .orElseThrow(() -> new RuntimeException("Username not found"));

        if (otp.getCode().equals(userOtpDTO.token())) {
            otpRepository.delete(otp);
            return true;
        }

        logger.error("Invalid OTP for user {}", userOtpDTO.username());
        return false;
    }
}
