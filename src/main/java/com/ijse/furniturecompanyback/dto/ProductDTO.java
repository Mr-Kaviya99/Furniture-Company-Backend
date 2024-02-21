package com.ijse.furniturecompanyback.dto;


import com.ijse.furniturecompanyback.dto.responsedto.core.CommonFileSavedBinaryDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productId;
    private String productName;

    private String price;

    private String dimensions;

    private String warranty;

    private String description;

    private CommonFileSavedBinaryDataDTO fileResource;

    private CategoryDTO category;
}
