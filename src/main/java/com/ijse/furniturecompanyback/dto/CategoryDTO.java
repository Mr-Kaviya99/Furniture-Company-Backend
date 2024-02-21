package com.ijse.furniturecompanyback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String categoryId;
    private String categoryName;
}
