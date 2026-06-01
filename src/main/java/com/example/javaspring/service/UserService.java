package com.example.javaspring.service;

import com.example.javaspring.dto.request.UserCreateRequest;
import com.example.javaspring.dto.request.UserUpdateRequest;
import com.example.javaspring.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse createUser(UserCreateRequest request);

    UserResponse updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);
}
