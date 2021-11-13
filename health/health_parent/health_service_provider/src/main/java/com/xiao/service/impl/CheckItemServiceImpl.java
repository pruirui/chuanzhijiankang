package com.xiao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiao.dao.CheckItemDao;
import com.xiao.entity.PageResult;
import com.xiao.entity.QueryPageBean;
import com.xiao.pojo.CheckItem;
import com.xiao.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;
    //新增CheckItem
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    public PageResult pageQuery(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckItem> pages = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    public void delete(Integer id) {
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count>0){
            throw new RuntimeException("有外键引用不可删除");
        }else{
            checkItemDao.deleteById(id);
        }
    }

    //编辑
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
