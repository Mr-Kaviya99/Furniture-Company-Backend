package com.ijse.furniturecompanyback.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseAdminDTO {
    private String adminId;

    private String email;
}
