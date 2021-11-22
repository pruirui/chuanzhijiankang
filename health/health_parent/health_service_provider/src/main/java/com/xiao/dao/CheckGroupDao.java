package com.xiao.dao;

import com.github.pagehelper.Page;
import com.xiao.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);
    void setCheckGroupAndCheckItem(Map<String, Integer> map);

    Page<CheckGroup> selectByCondition(String queryString);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void deleteAssociation(Integer id);

    void edit(CheckGroup checkGroup);

    long findCountByCheckGroupId(Integer id);

    void deleteById(Integer id);

    List<CheckGroup> findAll();

    List<CheckGroup> findCheckGroupBySetmealId(int id);
}
