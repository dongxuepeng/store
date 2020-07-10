package com.dxp.store.dao;

import com.dxp.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("UserDao")
public interface UserDao {
    User getUserById(Integer id);
    List<User> getAllUsers(@Param("stCount") Integer stCount, @Param("endCount") Integer endCount);
}
