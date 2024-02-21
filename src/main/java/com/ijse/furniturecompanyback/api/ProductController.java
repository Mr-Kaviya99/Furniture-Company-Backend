package com.ijse.furniturecompanyback.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.furniturecompanyback.dto.requestdto.RequestProductDTO;
import com.ijse.furniturecompanyback.service.ProductService;
import com.ijse.furniturecompanyback.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = {"/business/create/{categoryId}"})
    public ResponseEntity<StandardResponse> createProduct(
            @RequestParam("file") MultipartFile file,
            @RequestParam("data") String data, @PathVariable String categoryId) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        RequestProductDTO requestProductDTO = objectMapper.readValue(data, RequestProductDTO.class);
        return new ResponseEntity<>(
                new StandardResponse(200, "Product saved!",
                        productService.createProduct(requestProductDTO, categoryId, file)),
                HttpStatus.OK
        );
    }

    @PutMapping(path = {"/business/update/{id}"})
    public ResponseEntity<StandardResponse> updateProduct(
            @RequestBody RequestProductDTO dto, @PathVariable String id) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Product updated!",
                        productService.updateProduct(dto, id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = {"/business/delete/{id}"})
    public ResponseEntity<StandardResponse> deleteProduct(
            @PathVariable String id) {


        return new ResponseEntity<>(
                new StandardResponse(200, "Product deleted!",
                        productService.deleteProduct(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/find-by-id/{id}"})
    public ResponseEntity<StandardResponse> findById(
            @PathVariable String id) throws SQLException {


        return new ResponseEntity<>(
                new StandardResponse(200, "Product details!",
                        productService.findById(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/get-all"}, params = {"page", "size"})
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam int page,
            @RequestParam int size
    ) throws SQLException {


        return new ResponseEntity<>(
                new StandardResponse(200, "Product details list!",
                        productService.getAll(page, size)),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/business/find-by-category-id/{categoryId}"})
    public ResponseEntity<StandardResponse> findByCategoryId(
            @PathVariable String categoryId) throws SQLException {


        return new ResponseEntity<>(
                new StandardResponse(200, "Product details using category id!",
                        productService.findByCategoryId(categoryId)),
                HttpStatus.OK
        );
    }

}
