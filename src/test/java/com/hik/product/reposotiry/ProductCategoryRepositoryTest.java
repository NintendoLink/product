package com.hik.product.reposotiry;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductCategory> productCategoryList=productCategoryRepository.findByCategoryTypeIn(list);

        Assert.assertTrue(productCategoryList.size()>0);
//        Assert.assertNotEquals(null,list);
    }
}