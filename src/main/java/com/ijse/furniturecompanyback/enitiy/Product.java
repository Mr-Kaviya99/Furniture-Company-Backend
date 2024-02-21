package com.ijse.furniturecompanyback.enitiy;

import com.ijse.furniturecompanyback.enitiy.core.FileResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @Column(length = 80, name = "product_id")
    private String productId;

    @Column(length = 45, name = "product_name")
    private String productName;

    @Column(length = 45, name = "price")
    private String price;

    @Column(length = 45, name = "dimensions")
    private String dimensions;

    @Column(length = 45, name = "warranty")
    private String warranty;

    @Column(length = 750, name = "description")
    private String description;

    @Embedded
    private FileResource fileResource;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "category_id",nullable=false)
    private Category category;
}
