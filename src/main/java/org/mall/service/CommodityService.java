package org.mall.service;

import org.mall.domain.Commodity;

import java.util.List;

/*
* 商品Service接口
* */
public interface CommodityService {
    //获取全部学生信息
    List<Commodity> findAll();

    //新增学生信息
    void insertCommodity(Commodity commodity);

    //修改学生信息
    void updateCommodity(Commodity commodity);

    //根据id查询获取学生信息
    Commodity findById(Integer id);

    //根据id删除学生信息
    void deleteById(Integer id);
}
