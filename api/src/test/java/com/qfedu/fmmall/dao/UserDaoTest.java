package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Resource
    private UsersMapper usersMapper;
    @Test
    public void queryUserByName() {

    }
}