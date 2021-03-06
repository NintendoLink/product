package com.hik.product.controller;

import com.hik.product.DTO.CartDTO;
import com.hik.product.VO.ProductInfoVO;
import com.hik.product.VO.ProductVO;
import com.hik.product.VO.ResultVO;
import com.hik.product.dataobject.ProductCategory;
import com.hik.product.dataobject.ProductInfo;
import com.hik.product.service.ProductService;
import com.hik.product.service.ServiceImpl.ProductCategeryServiceImpl;
import com.hik.product.service.ServiceImpl.ProductServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    private final ProductCategeryServiceImpl categoryService;

    @Autowired
    public ProductController(ProductServiceImpl productService, ProductCategeryServiceImpl categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    /**
     * 业务逻辑
     * 1.查询所有的在架商品
     * 2.获取类目type表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询类目(一次性商品)
        List<Integer> categoryTypeList=new ArrayList<>();
        //传统方法
        for(ProductInfo p:productInfoList){
            categoryTypeList.add(p.getCategoryType());
        }

        //精简做法(jdk8特性)
//        List<Integer> categoryTypeList=productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> result=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装

        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory:result){
            System.out.println("********");
            ProductVO productVO=new ProductVO();
            productVO.setCateGory(productCategory.getCategoryName());
            productVO.setType(productCategory.getCategoryType());

//            List<ProductInfo> productInfos=new ArrayList<>();
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);

            }
            productVOList.add(productVO);
        }

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");

//        ProductVO productVO=new ProductVO();
//        ProductInfoVO productInfoVO=new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

//        resultVO.setData(Arrays.asList(productVO));
//        resultVO.setData(productVO);
        resultVO.setT(productVOList);
//        ProductInfoVO productInfoVO=new ProductInfoVO();
//        resultVO.setData(productInfoVO);
        return resultVO;
    }

    /**
     * 获取商品列表，专门给订单服务使用
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping(value = "/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
