package com.xiao.service;

import com.xiao.entity.PageResult;
import com.xiao.pojo.Setmeal;

/**
 * 体检套餐服务接口
 */
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
}
