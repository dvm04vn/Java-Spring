package com.example.javaspring.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateRequest (

        @NotBlank(message = "Tên không được để trống")
        String name,

        @NotBlank(message = "Email không được để trống")
        @NotBlank(message = "Email không đúng định dạng")
        String email
) {
}
