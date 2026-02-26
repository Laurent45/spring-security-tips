package com.boarhat.authorization_server.controller;

import com.boarhat.authorization_server.controller.dto.UserCreateDTO;
import com.boarhat.authorization_server.controller.dto.UserOtpDTO;
import com.boarhat.authorization_server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreateDTO user) {
        userService.addUser(user);
    }

    @PostMapping("/otp")
    public void createOtp(@RequestBody UserCreateDTO user) {
        userService.createOtp(user);
    }

    @PostMapping("/otp/check")
    public ResponseEntity<Void> checkOtp(@RequestBody UserOtpDTO user) {
        if (userService.checkOtp(user)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
