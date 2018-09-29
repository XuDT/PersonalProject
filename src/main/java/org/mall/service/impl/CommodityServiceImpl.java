package org.mall.service.impl;

import org.mall.dao.CommodityDao;
import org.mall.dao.CommodityDao;
import org.mall.domain.Commodity;
import org.mall.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 商品Service实现类
* */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    //获取全部商品
    public List<Commodity> findAll(){
        return commodityDao.findAll();
    }

    //新增商品
    public void insertCommodity(Commodity commodity){
        commodityDao.insertCommodity(commodity);
    }

    //修改商品
    public void updateCommodity(Commodity commodity){
        commodityDao.updateCommodity(commodity);
    }

    //根据id获取商品
    public Commodity findById(Integer id){
        return commodityDao.findById(id);
    }

    //根据id删除商品
    public void deleteById(Integer id){
        commodityDao.deleteById(id);
    }
}
