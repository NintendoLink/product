package com.hik.product.service.ServiceImpl;

import com.hik.product.DTO.CartDTO;
import com.hik.product.dataobject.ProductInfo;
import com.hik.product.reposotiry.ProductInfoReposority;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductInfoReposority productInfoReposority;

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> productInfoList=productInfoReposority.findByProductIdIn(Arrays.asList("2","1"));
        for(ProductInfo productInfo:productInfoList){
            System.out.println(productInfo);
        }
        Assert.assertTrue(productInfoList.size()>1);
    }

    @Test
    public void decreaseStock() throws Exception{
        CartDTO cartDTO=new CartDTO();
        cartDTO.setProductId("2");
        cartDTO.setProductQuantity(5);

        List<CartDTO> cartDTOList=new ArrayList<>();
        cartDTOList.add(cartDTO);

        productService.decreaseStock(cartDTOList);
    }
}