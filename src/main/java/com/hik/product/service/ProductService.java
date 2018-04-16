package com.hik.product.service;

import com.hik.product.DTO.CartDTO;
import com.hik.product.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
