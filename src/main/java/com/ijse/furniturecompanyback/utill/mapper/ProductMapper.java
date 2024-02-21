package com.ijse.furniturecompanyback.utill.mapper;

import com.ijse.furniturecompanyback.dto.ProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseCategoryDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTO;
import com.ijse.furniturecompanyback.enitiy.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);

    ResponseProductDTO toResponseProduct(Product product);

    List<ResponseProductDTO> toPaginatedResponseProductDTOList(Page<Product> productRepoAll);

    List<ResponseProductDTO> toResponseProductDTOList(List<Product> productList);
}
