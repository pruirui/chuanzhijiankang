package com.xiao.dao;

import com.github.pagehelper.Page;
import com.xiao.pojo.CheckItem;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 持久层Dao接口
 */
public interface CheckItemDao {
    void add(CheckItem checkItem);

    /**
     * 使用分页助手，自动封装到page对象中
     * @param queryString 查询条件
     * @return
     */
    Page<CheckItem> selectByCondition(String queryString);

    /**
     * 查询CheckItem项是否被其他项(如CheckGroup某个项)引用
     * @param id
     * @return 关联个数
     */
    long findCountByCheckItemId(Integer id);

    void deleteById(Integer id);

    void edit(CheckItem checkItem);

    CheckItem findById(Integer id);

    List<CheckItem> findAll();
}
