package com.hik.product.service.ServiceImpl;

import com.hik.product.DTO.CartDTO;
import com.hik.product.dataobject.ProductInfo;
import com.hik.product.enums.ProductStatusEnums;
import com.hik.product.enums.ResultEnum;
import com.hik.product.exception.ProductException;
import com.hik.product.reposotiry.ProductCategoryRepository;
import com.hik.product.reposotiry.ProductInfoReposority;
import com.hik.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductInfoReposority productInfoReposority;

    @Autowired
    public ProductServiceImpl(ProductCategoryRepository productCategoryRepository,ProductInfoReposority productInfoReposority) {
        this.productCategoryRepository = productCategoryRepository;
        this.productInfoReposority = productInfoReposority;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return  productInfoReposority.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoReposority.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
           Optional<ProductInfo> productInfoOptional= productInfoReposority.findById(cartDTO.getProductId());
            /**
             * 首先判断商品存不存在
              */
           if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo=productInfoOptional.get();
           Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            /**
             * 判断商品是否存在
             */
           if(result<0){
               throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
           }

           productInfo.setProductStock(result);
           productInfoReposority.save(productInfo);
        }
    }
}
