package com.hik.product.service.ServiceImpl;

import com.hik.product.dataobject.ProductCategory;
import com.hik.product.reposotiry.ProductCategoryRepository;
import com.hik.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategeryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return productCategoryRepository.findByCategoryTypeIn(categoryType);
    }
}
