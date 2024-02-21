package com.ijse.furniturecompanyback.utill.mapper;

import com.ijse.furniturecompanyback.dto.AdminDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseAdminDTO;
import com.ijse.furniturecompanyback.enitiy.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toAdminDto(Admin admin);
    Admin toAdmin(AdminDTO adminDTO);

    ResponseAdminDTO toResponseAdminDTO(Admin admin);
}
