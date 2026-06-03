package com.example.javaspring.service.impl;

import com.example.javaspring.dto.request.LoginRequest;
import com.example.javaspring.dto.request.RegisterRequest;
import com.example.javaspring.dto.response.AuthResponse;
import com.example.javaspring.dto.response.LogoutResponse;
import com.example.javaspring.entity.User;
import com.example.javaspring.service.AuthService;
import com.example.javaspring.service.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        boolean emailExists = users.stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(request.getEmail()));

        if (emailExists) {
            throw new RuntimeException("Email đã tồn tại");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(
                currentId,
                request.getFullName(),
                request.getEmail(),
                encodedPassword
        );

        users.add(user);
        currentId++;

        return new AuthResponse(
                true,
                user.getId(),
                user.getName(),
                user.getEmail(),
                "Đăng ký thành công",
                null
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = users.stream()
                .filter(item -> item.getEmail().equalsIgnoreCase(request.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Email hoặc mật khẩu không đúng"));

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Email hoặc mật khẩu không đúng");
        }

        String accessToken = jwtService.generateToken(
                user.getId(),
                user.getEmail(),
                user.getName()
        );

        return new AuthResponse(
                true,
                user.getId(),
                user.getName(),
                user.getEmail(),
                "Đăng nhập thành công",
                accessToken
        );
    }

    @Override
    public LogoutResponse logout() {
        return new LogoutResponse(true, "Đăng xuất thành công");
    }
}