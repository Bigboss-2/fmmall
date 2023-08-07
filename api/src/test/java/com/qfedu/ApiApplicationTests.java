package com.qfedu;

import com.qfedu.fmmall.ApiApplication;
import com.qfedu.fmmall.dao.CategoryMapper;
import com.qfedu.fmmall.dao.ProductMapper;
import com.qfedu.fmmall.entity.CategoryVO;
import com.qfedu.fmmall.entity.CategoryVO2;
import com.qfedu.fmmall.entity.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTests {


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;
    

    @Test
    public void contextLoads() {
//        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
//        for(CategoryVO c1 : categoryVOS){
//            System.out.println(c1);
//            for(CategoryVO c2 : c1.getCategories()){
//                System.out.println("\t" + c2);
//                for(CategoryVO c3 : c2.getCategories()){
//                    System.out.println("\t\t" + c3);
//                }
//            }
//
//        }
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for(ProductVO c1 :productVOS){
            System.out.println(c1);
        }

    }
    
    @Test
    public void selectFirstLevel(){
        List<CategoryVO2> categoryVOS = categoryMapper.selectFirstLevelCategories();
        for(CategoryVO2 c:categoryVOS){
            System.out.println(c);
        }

    }




}
