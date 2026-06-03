package com.example.javaspring.service;

import com.example.javaspring.dto.request.LoginRequest;
import com.example.javaspring.dto.request.RegisterRequest;
import com.example.javaspring.dto.response.AuthResponse;
import com.example.javaspring.dto.response.LogoutResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    LogoutResponse logout();
}