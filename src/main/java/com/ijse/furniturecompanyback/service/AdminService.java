package com.ijse.furniturecompanyback.service;


import com.ijse.furniturecompanyback.dto.requestdto.RequestAdminDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseAdminDTO;

public interface AdminService {
    String createAdmin(RequestAdminDTO dto);

    ResponseAdminDTO findByEmail(String email, String password);
}
