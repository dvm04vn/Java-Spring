package com.example.javaspring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest (

        @NotBlank(message = "Tên không đuợc để trống")
        String name,

        @NotBlank(message = "Email không được để trống")
        @Email(message = "Email không đúng định dạng")
        String email
){
}
