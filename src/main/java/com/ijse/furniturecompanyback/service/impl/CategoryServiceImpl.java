package com.ijse.furniturecompanyback.service.impl;

import com.ijse.furniturecompanyback.dto.CategoryDTO;
import com.ijse.furniturecompanyback.dto.requestdto.RequestCategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseCategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.paginated.PaginatedResponseCategoryDTO;
import com.ijse.furniturecompanyback.enitiy.Category;
import com.ijse.furniturecompanyback.exception.EntryNotFoundException;
import com.ijse.furniturecompanyback.repo.CategoryRepo;
import com.ijse.furniturecompanyback.service.CategoryService;
import com.ijse.furniturecompanyback.utill.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepo categoryRepo) {
        this.categoryMapper = categoryMapper;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public String createCategory(RequestCategoryDTO dto) {

        String lastId = categoryRepo.findLastId("FC-C-",
                6);

        String propertyId = "FC-C-1";

        if (null != lastId) {
            int i = (Integer.parseInt(lastId.split("FC-C-")[1])) + 1;
            propertyId = "FC-C-" + i;
        }
        CategoryDTO categoryDTO = new CategoryDTO(
                propertyId,
                dto.getCategoryName()
        );
        categoryRepo.save(categoryMapper.toCategory(categoryDTO));
        return propertyId;
    }

    @Override
    public String updateCategory(RequestCategoryDTO dto, String id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            category.get().setCategoryName(dto.getCategoryName());
            categoryRepo.save(category.get());
            return category.get().getCategoryId();
        } else {
            throw new EntryNotFoundException("Can't find any category");

        }

    }

    @Override
    public ResponseCategoryDTO findById(String id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            return categoryMapper.toResponseCategoryDTO(category.get());
        } else {
            throw new EntryNotFoundException("Can't find any category");

        }

    }

    @Override
    public boolean deleteCategory(String id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            categoryRepo.delete(category.get());
            return true;
        } else {
            throw new EntryNotFoundException("Can't find any category");

        }

    }

    @Override
    public List<ResponseCategoryDTO> findAll() {
        List<Category> all = categoryRepo.findAll();
        return categoryMapper.toResponseCategoryDTOList(all);
    }

    @Override
    public PaginatedResponseCategoryDTO getAll(int page, int size) {
        Page<Category> categoryRepoAll = categoryRepo.findAll(PageRequest.of(page, size));
        return new PaginatedResponseCategoryDTO(
                categoryRepo.count(),
                categoryMapper.toPaginatedResponseCategoryDTOList(categoryRepoAll)
        );
    }
}
