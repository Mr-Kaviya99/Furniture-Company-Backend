package com.ijse.furniturecompanyback.api;

import com.ijse.furniturecompanyback.dto.requestdto.RequestAdminDTO;
import com.ijse.furniturecompanyback.service.AdminService;
import com.ijse.furniturecompanyback.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = {"/business/create"})
    public ResponseEntity<StandardResponse> createAdmin(
            @RequestBody RequestAdminDTO dto) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Admin saved!",
                        adminService.createAdmin(dto)),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/get-by-email"},params = {"email","password"})
    public ResponseEntity<StandardResponse> getByEmail(
            @RequestParam String email,  @RequestParam String password) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Admin Details : ",
                        adminService.findByEmail(email,password)),
                HttpStatus.OK
        );
    }
}
