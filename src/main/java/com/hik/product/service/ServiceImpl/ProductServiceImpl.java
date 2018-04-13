package com.hik.product.service.ServiceImpl;

import com.hik.product.dataobject.ProductInfo;
import com.hik.product.enums.ProductStatusEnums;
import com.hik.product.reposotiry.ProductCategoryRepository;
import com.hik.product.reposotiry.ProductInfoReposority;
import com.hik.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductInfoReposority productInfoReposority;
    @Override
    public List<ProductInfo> findUpAll() {
        return  productInfoReposority.findByProductStatus(ProductStatusEnums.UP.getCode());
    }
}
