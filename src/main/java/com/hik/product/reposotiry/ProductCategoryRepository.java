package com.hik.product.reposotiry;

import com.hik.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
