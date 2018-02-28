package com.google.authenticator.dao;

import com.google.authenticator.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: Gaoyp
 * @Description:
 * @Date: Create in 下午2:17 2018/2/28
 * @Modified By:
 */
@Mapper
@Component
public interface TestMapper {

    @Select("select * from sys_user where username = #{username}")
    User findUserByUsername(@Param("username") String username);

}
