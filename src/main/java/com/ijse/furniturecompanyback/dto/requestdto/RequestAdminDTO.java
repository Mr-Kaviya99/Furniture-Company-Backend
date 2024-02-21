package com.ijse.furniturecompanyback.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestAdminDTO {
    private String email;

    private String password;
}
