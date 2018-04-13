package com.hik.product.service.ServiceImpl;

import com.hik.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategeryServiceImplTest {

    @Autowired
    private ProductCategeryServiceImpl productCategeryService;
    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductCategory> productCategoryList=productCategeryService.findByCategoryTypeIn(list);
        Assert.assertTrue(productCategoryList.size()>0);
        System.out.println(productCategoryList.size());
    }
}