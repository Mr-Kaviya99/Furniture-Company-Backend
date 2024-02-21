package com.ijse.furniturecompanyback.enitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @Column(length = 80, name = "admin_id")
    private String adminId;

    @Column(length = 45, name = "email",unique = true)
    private String email;

    @Column(length = 45, name = "password")
    private String password;
}
