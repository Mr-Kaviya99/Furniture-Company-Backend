package com.ijse.furniturecompanyback.service.impl;

import com.ijse.furniturecompanyback.dto.AdminDTO;
import com.ijse.furniturecompanyback.dto.requestdto.RequestAdminDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseAdminDTO;
import com.ijse.furniturecompanyback.enitiy.Admin;
import com.ijse.furniturecompanyback.exception.EntryNotFoundException;
import com.ijse.furniturecompanyback.repo.AdminRepo;
import com.ijse.furniturecompanyback.service.AdminService;
import com.ijse.furniturecompanyback.utill.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepo adminRepo;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepo adminRepo, AdminMapper adminMapper) {
        this.adminRepo = adminRepo;
        this.adminMapper = adminMapper;
    }

    @Override
    public String createAdmin(RequestAdminDTO dto) {
        String lastId = adminRepo.findLastId("FC-A-",
                6);

        String propertyId = "FC-A-1";

        if (null != lastId) {
            int i = (Integer.parseInt(lastId.split("FC-A-")[1])) + 1;
            propertyId = "FC-A-" + i;
        }
        AdminDTO adminDTO = new AdminDTO(
                propertyId,
                dto.getEmail(),
               dto.getPassword());

        adminRepo.save(adminMapper.toAdmin(adminDTO));


        return propertyId;
    }

    @Override
    public ResponseAdminDTO findByEmail(String email, String password) {
        Admin admin = adminRepo.findByEmailAAndPassword(email,password);
        if (admin==null){
            throw new  EntryNotFoundException("Can't find any user, please provide valid credentials");
        }
        return adminMapper.toResponseAdminDTO(admin);
    }

}
