package com.hik.product.service;

import com.hik.product.dataobject.ProductInfo;
import com.hik.product.service.ServiceImpl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findUpAll() {
        List<ProductInfo> productServiceList=productService.findUpAll();
        for(ProductInfo productInfo:productServiceList){
            System.out.println(productInfo);
        }
        Assert.assertTrue(productServiceList.size()>0);
    }
}