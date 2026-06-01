package com.example.javaspring.service.impl;

import com.example.javaspring.dto.request.UserCreateRequest;
import com.example.javaspring.dto.request.UserUpdateRequest;
import com.example.javaspring.dto.response.UserResponse;
import com.example.javaspring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    private final List<UserResponse> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<UserResponse> getAllUsers() {
        return users;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user với id: " + id));
    }

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        UserResponse user = new UserResponse(
                idGenerator.getAndIncrement(),
                request.name(),
                request.email()
        );

        users.add(user);

        return user;
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        UserResponse existingUser = getUserById(id);

        UserResponse updatedUser = new UserResponse(
                existingUser.id(),
                request.name(),
                request.email()
        );

        users.remove(existingUser);
        users.add(updatedUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        UserResponse existingUser = getUserById(id);
        users.remove(existingUser);
    }
}