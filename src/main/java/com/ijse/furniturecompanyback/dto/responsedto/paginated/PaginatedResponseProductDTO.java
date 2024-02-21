package com.ijse.furniturecompanyback.dto.responsedto.paginated;

import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTOById;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseProductDTO {
    private Long count;
    private List<ResponseProductDTOById> dataList;
}
