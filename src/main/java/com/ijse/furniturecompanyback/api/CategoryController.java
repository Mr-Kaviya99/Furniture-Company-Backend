package com.ijse.furniturecompanyback.api;

import com.ijse.furniturecompanyback.dto.requestdto.RequestCategoryDTO;
import com.ijse.furniturecompanyback.dto.requestdto.RequestProductDTO;
import com.ijse.furniturecompanyback.service.CategoryService;
import com.ijse.furniturecompanyback.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping(path = {"/business/create/"})
    public ResponseEntity<StandardResponse> createCategory(
            @RequestBody RequestCategoryDTO dto) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category saved!",
                        categoryService.createCategory(dto)),
                HttpStatus.OK
        );
    }
    @PutMapping(path = {"/business/update/{id}"})
    public ResponseEntity<StandardResponse> updateCategory(
            @RequestBody RequestCategoryDTO dto, @PathVariable String id) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category updated!",
                        categoryService.updateCategory(dto,id)),
                HttpStatus.OK
        );
    }
    @DeleteMapping(path = {"/business/delete/{id}"})
    public ResponseEntity<StandardResponse> deleteCategory(
             @PathVariable String id) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category deleted!",
                        categoryService.deleteCategory(id)),
                HttpStatus.OK
        );
    }
    @GetMapping(path = {"/business/find-by-id/{id}"})
    public ResponseEntity<StandardResponse> findById(
            @PathVariable String id) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category details!",
                        categoryService.findById(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/find-all"})
    public ResponseEntity<StandardResponse> findAll() {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category details!",
                        categoryService.findAll()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/get-all"},params = {"page","size"})
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam int page,
            @RequestParam int size
    ) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Category details list!",
                        categoryService.getAll(page,size)),
                HttpStatus.OK
        );
    }

}
