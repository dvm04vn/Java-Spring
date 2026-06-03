package com.example.javaspring.service;

public interface JwtService {
    String generateToken(Long userId, String email, String fullName);

    String extractEmail(String token);
}
