package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.ProductImg;
import com.qfedu.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    //根据商品id查询当前商品的图片信息
    public List<ProductImg> selectProductImgByProductId(int productId);

}