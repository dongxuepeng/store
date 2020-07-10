package com.dxp.store.dao;

import com.dxp.store.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("GoodsTypeDao")
public interface GoodsTypeDao {
    List<GoodsType> getAllGoodsType(@Param("id") Integer id, @Param("name") String name, @Param("stCount") Integer stCount, @Param("endCount") Integer endCount);
    Integer getGoodsTypeCount(@Param("id") Integer id, @Param("name") String name);
    Integer updateGoodsType(@Param("id") Integer id, @Param("name") String name,@Param("goodyf") Double goodyf,@Param("goodzf") Double goodzf);
    /*Integer addGoodsType(@Param("name") String name);*/
    Integer addGoodsType(GoodsType goodsType);
    Integer getGoodsTypeByName(@Param("id") Integer id,@Param("name") String name);
    Integer delGoodsType(@Param("ids") List<Integer> ids);
}
