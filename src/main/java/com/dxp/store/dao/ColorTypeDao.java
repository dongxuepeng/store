package com.dxp.store.dao;

import com.dxp.store.entity.ColorType;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("ColorTypeDao")
public interface ColorTypeDao {

    List<Map> getAllColorType(@Param("id") Integer id, @Param("name") String name, @Param("goodsType") Integer goodsType,
                              @Param("stCount") Integer stCount, @Param("endCount") Integer endCount);

    Integer getColorTypeCount(@Param("id") Integer id, @Param("name") String name, @Param("goodsType") Integer goodsType);

    Integer getColorTypeByName(@Param("id") Integer id, @Param("name") String name, @Param("goodsType") Integer goodsType);

    Integer updateColorType(@Param("id") Integer id, @Param("name") String name, @Param("goodsType") Integer goodsType);

    Integer addColorType(@Param("name") String name, @Param("goodsType") Integer goodsType);

    Integer delColorType(@Param("ids") List<Integer> ids);
}
