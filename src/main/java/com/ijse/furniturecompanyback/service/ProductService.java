package com.ijse.furniturecompanyback.service;

import com.ijse.furniturecompanyback.dto.requestdto.RequestProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTOById;
import com.ijse.furniturecompanyback.dto.responsedto.paginated.PaginatedResponseProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    String createProduct(RequestProductDTO dto, String categoryId, MultipartFile file);

    String updateProduct(RequestProductDTO dto, String id);

    boolean deleteProduct(String id);

    ResponseProductDTOById findById(String id) throws SQLException;

    PaginatedResponseProductDTO getAll(int page, int size) throws SQLException;

    List<ResponseProductDTOById> findByCategoryId(String categoryId) throws SQLException;
}
