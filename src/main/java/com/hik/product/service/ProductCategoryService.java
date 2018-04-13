package com.hik.product.service;

import com.hik.product.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
