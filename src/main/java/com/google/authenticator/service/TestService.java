package com.google.authenticator.service;

import com.google.authenticator.dao.TestMapper;
import com.google.authenticator.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Gaoyp
 * @Description:
 * @Date: Create in 下午2:26 2018/2/28
 * @Modified By:
 */
@Service
public class TestService {


    @Autowired
    private TestMapper testMapper;

    //用户名密码登录验证
    public User login(String username,String password) {

        return testMapper.findUserByUsername(username);


    }

}
