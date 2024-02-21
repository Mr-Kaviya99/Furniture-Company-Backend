package com.ijse.furniturecompanyback.dto.responsedto;

import com.ijse.furniturecompanyback.dto.responsedto.core.CommonFileSavedSimpleDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseProductDTOById {
    private String productId;
    private String productName;

    private String price;

    private String dimensions;

    private String warranty;

    private String description;

    private String fileResource;
}
