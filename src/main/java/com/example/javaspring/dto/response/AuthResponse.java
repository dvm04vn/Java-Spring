package com.example.javaspring.dto.response;

public class AuthResponse {

    private boolean success;
    private Long userId;
    private String fullName;
    private String email;
    private String message;
    private String accessToken;

    public AuthResponse() {
    }

    public AuthResponse(
            boolean success,
            Long userId,
            String fullName,
            String email,
            String message,
            String accessToken
    ) {
        this.success = success;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.message = message;
        this.accessToken = accessToken;
    }

    public boolean isSuccess() {
        return success;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getAccessToken() {
        return accessToken;
    }
}