package com.example.javaspring.service;

import com.example.javaspring.dto.request.LoginRequest;
import com.example.javaspring.dto.request.RegisterRequest;
import com.example.javaspring.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}