package com.hik.product.reposotiry;

import com.hik.product.dataobject.ProductInfo;
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
public class ProductInfoReposorityTest {
    @Autowired
    private ProductInfoReposority productInfoReposority;
    @Test

    public void findByProductStatus() {
        List<ProductInfo> list=productInfoReposority.findByProductStatus(0);
        Assert.assertNotEquals(null,list);
    }
}