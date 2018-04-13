package com.hik.product.service;

import com.hik.product.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductInfo> findUpAll();

}
