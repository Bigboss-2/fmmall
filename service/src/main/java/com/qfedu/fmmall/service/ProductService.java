package com.qfedu.fmmall.service;

import com.qfedu.fmmall.dao.ProductMapper;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;



public interface ProductService {


    public ResultVO listRecommendProducts();

    public ResultVO getProductBasicInfo(String productId);

    public ResultVO getProductParamsById(String productId);
}
