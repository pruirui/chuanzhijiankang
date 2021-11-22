package com.xiao.dao;

import com.github.pagehelper.Page;
import com.xiao.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);

    Page<Setmeal> selectByCondition(String queryString);

    Setmeal findById(Integer id);

    List<Integer> findCheckGroupIdsBySetmealId(Integer id);

    void deleteAssociation(Integer id);

    void edit(Setmeal setmeal);

    void deleteById(Integer id);

    List<Setmeal> findAll();
    //根据id链式查询，将所有的项目组以及项目项都查到返回
    Setmeal findByIdAll(int id);
}
