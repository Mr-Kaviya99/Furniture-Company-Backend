package com.ijse.furniturecompanyback.utill.mapper;

import com.ijse.furniturecompanyback.dto.CategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseCategoryDTO;
import com.ijse.furniturecompanyback.enitiy.Category;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTO(Category category);

    ResponseCategoryDTO toResponseCategoryDTO(Category category);

    List<ResponseCategoryDTO> toResponseCategoryDTOList(List<Category> all);

    List<ResponseCategoryDTO> toPaginatedResponseCategoryDTOList(Page<Category> categoryRepoAll);
}
