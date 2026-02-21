package com.boarhat.authorization_server.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "otps")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String code;

    Otp() {}

    public Otp(User user, String code) {
        this.user = user;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Otp otp)) return false;
        return Objects.equals(code, otp.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
