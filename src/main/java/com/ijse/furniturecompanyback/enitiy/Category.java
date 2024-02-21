package com.ijse.furniturecompanyback.enitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @Column(length = 80, name = "category_id")
    private String categoryId;

    @Column(length = 45, name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy="category")
    private Set<Product> Product;
}
