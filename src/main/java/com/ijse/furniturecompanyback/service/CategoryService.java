package com.ijse.furniturecompanyback.service;

import com.ijse.furniturecompanyback.dto.requestdto.RequestCategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseCategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.paginated.PaginatedResponseCategoryDTO;

import java.util.List;

public interface CategoryService {
    String createCategory(RequestCategoryDTO dto);

    String updateCategory(RequestCategoryDTO dto, String id);

    ResponseCategoryDTO findById(String id);

    boolean deleteCategory(String id);

    List<ResponseCategoryDTO> findAll();

    PaginatedResponseCategoryDTO getAll(int page, int size);
}
