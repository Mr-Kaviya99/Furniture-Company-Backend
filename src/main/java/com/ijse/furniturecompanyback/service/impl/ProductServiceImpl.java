package com.ijse.furniturecompanyback.service.impl;

import com.ijse.furniturecompanyback.dto.ProductDTO;
import com.ijse.furniturecompanyback.dto.requestdto.RequestProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTO;
import com.ijse.furniturecompanyback.dto.responsedto.ResponseProductDTOById;
import com.ijse.furniturecompanyback.dto.responsedto.core.CommonFileSavedBinaryDataDTO;
import com.ijse.furniturecompanyback.dto.responsedto.paginated.PaginatedResponseProductDTO;
import com.ijse.furniturecompanyback.enitiy.Category;
import com.ijse.furniturecompanyback.enitiy.Product;
import com.ijse.furniturecompanyback.exception.EntryNotFoundException;
import com.ijse.furniturecompanyback.repo.CategoryRepo;
import com.ijse.furniturecompanyback.repo.ProductRepo;
import com.ijse.furniturecompanyback.service.ProductService;
import com.ijse.furniturecompanyback.service.process.FileService;
import com.ijse.furniturecompanyback.utill.FileDataExtractor;
import com.ijse.furniturecompanyback.utill.mapper.CategoryMapper;
import com.ijse.furniturecompanyback.utill.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;
    private final FileService fileService;
    private final FileDataExtractor fileDataExtractor;
    @Value("${bucketName}")
    private String bucketName;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepo productRepo, CategoryRepo categoryRepo, CategoryMapper categoryMapper, FileService fileService, FileDataExtractor fileDataExtractor) {
        this.productMapper = productMapper;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
        this.fileService = fileService;
        this.fileDataExtractor = fileDataExtractor;
    }

    @Override
    public String createProduct(RequestProductDTO dto, String categoryId, MultipartFile file) {
        Optional<Category> category = categoryRepo.findById(categoryId);
        CommonFileSavedBinaryDataDTO commonFileSavedBinaryDataDTO = null;
        try {
            commonFileSavedBinaryDataDTO = fileService.createResource(file, "furniture-company/business/file/", bucketName, "FC", 20);
            if (category.isPresent()) {
                String lastId = productRepo.findLastId("FC-P-",
                        6);

                String propertyId = "FC-P-1";

                if (null != lastId) {
                    int i = (Integer.parseInt(lastId.split("FC-P-")[1])) + 1;
                    propertyId = "FC-P-" + i;
                }
                ProductDTO productDTO = new ProductDTO(
                        propertyId,
                        dto.getProductName(),
                        dto.getPrice(),
                        dto.getDimensions(),
                        dto.getWarranty(),
                        dto.getDescription(),
                        new CommonFileSavedBinaryDataDTO(
                                commonFileSavedBinaryDataDTO.getHash(),
                                commonFileSavedBinaryDataDTO.getDirectory(),
                                commonFileSavedBinaryDataDTO.getFileName(),
                                commonFileSavedBinaryDataDTO.getResourceUrl()
                        ),
                        categoryMapper.toCategoryDTO(category.get())
                );
                productRepo.save(productMapper.toProduct(productDTO));
                return propertyId;
            } else {
                throw new EntryNotFoundException("Can't find any category");

            }
        } catch (Exception e) {
            System.out.println(e);
            try {
                assert commonFileSavedBinaryDataDTO != null;
                fileService.deleteResource(bucketName, commonFileSavedBinaryDataDTO.getDirectory(), fileDataExtractor.extractActualFileName(
                        new InputStreamReader(
                                commonFileSavedBinaryDataDTO.getFileName().getBinaryStream())));

            } catch (SQLException ex) {
                throw new IllegalStateException("Something went wrong please try again later !");
            }
            throw new IllegalStateException("Something went wrong please try again later!");
        }

    }

    @Override
    public String updateProduct(RequestProductDTO dto, String id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            product.get().setProductName(dto.getProductName());
            product.get().setDescription(dto.getDescription());
            product.get().setDimensions(dto.getDimensions());
            product.get().setWarranty(dto.getWarranty());
            product.get().setPrice(dto.getPrice());
            productRepo.save(product.get());
            return product.get().getProductId();
        } else {
            throw new EntryNotFoundException("Can't find any product");

        }
    }

    @Override
    public boolean deleteProduct(String id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            productRepo.delete(product.get());
            return true;
        } else {
            throw new EntryNotFoundException("Can't find any product");

        }
    }

    @Override
    public ResponseProductDTOById findById(String id) throws SQLException {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            return new ResponseProductDTOById(
                    product.get().getProductId(),
                    product.get().getProductName(),
                    product.get().getPrice(),
                    product.get().getDimensions(),
                    product.get().getWarranty(),
                    product.get().getDescription(),
                    new String(
                            product.get().getFileResource().getResourceUrl().getBytes(1, (int) product.get().getFileResource().getResourceUrl().length()))

            );

        } else {
            throw new EntryNotFoundException("Can't find any product");

        }
    }

    @Override
    public PaginatedResponseProductDTO getAll(int page, int size) throws SQLException {
        Page<Product> productRepoAll = productRepo.findAll(PageRequest.of(page, size));

        ArrayList<ResponseProductDTOById> list = new ArrayList<>();
        for (Product product : productRepoAll) {
            list.add(
                    new ResponseProductDTOById(
                            product.getProductId(),
                            product.getProductName(),
                            product.getPrice(),
                            product.getDimensions(),
                            product.getWarranty(),
                            product.getDescription(),
                            new String(
                                    product.getFileResource().getResourceUrl().getBytes(1, (int) product.getFileResource().getResourceUrl().length()))


                    ));

        }

        return new PaginatedResponseProductDTO(
                productRepo.count(),
                list);
    }

    @Override
    public List<ResponseProductDTOById> findByCategoryId(String categoryId) throws SQLException {
        List<Product> productList = productRepo.findByCategoryId(categoryId);

        ArrayList<ResponseProductDTOById> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(
                    new ResponseProductDTOById(
                            product.getProductId(),
                            product.getProductName(),
                            product.getPrice(),
                            product.getDimensions(),
                            product.getWarranty(),
                            product.getDescription(),
                            new String(
                                    product.getFileResource().getResourceUrl().getBytes(1, (int) product.getFileResource().getResourceUrl().length()))


                    ));

        }
        return list;
//        return productMapper.toResponseProductDTOList(productList);
    }
}
