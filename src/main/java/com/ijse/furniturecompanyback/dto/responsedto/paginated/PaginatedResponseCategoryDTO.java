package com.ijse.furniturecompanyback.dto.responsedto.paginated;

import com.ijse.furniturecompanyback.dto.responsedto.ResponseCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseCategoryDTO {
    private Long count;
    private List<ResponseCategoryDTO> dataList;
}
