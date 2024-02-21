package com.ijse.furniturecompanyback.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestProductDTO {
    private String productName;

    private String price;

    private String dimensions;

    private String warranty;

    private String description;
}
