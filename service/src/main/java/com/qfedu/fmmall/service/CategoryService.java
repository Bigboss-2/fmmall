package com.qfedu.fmmall.service;

import com.qfedu.fmmall.entity.Category;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {


    public ResultVO listCategories();

    public ResultVO listFirstLevelCategories();
}
