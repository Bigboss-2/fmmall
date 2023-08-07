package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.IndexImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class IndexImgMapperTest {


    @Autowired
    private IndexImgMapper indexImgMapper;
    @Test
    public void testListIndexImgs(){
        List<IndexImg> lists = indexImgMapper.listIndexImgs();
        System.out.println(lists.size());

    }

}