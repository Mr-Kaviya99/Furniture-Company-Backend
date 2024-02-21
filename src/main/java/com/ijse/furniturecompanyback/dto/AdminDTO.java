package com.ijse.furniturecompanyback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private String adminId;

    private String email;

    private String password;
}
