package com.xiao.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.xiao.constant.MessageConstant;
import com.xiao.entity.PageResult;
import com.xiao.entity.QueryPageBean;
import com.xiao.entity.Result;
import com.xiao.pojo.CheckItem;
import com.xiao.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//RestController 包含了 Controller并相当于在所以函数前加了@ResponseBody 即可以返回java对象
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;


    @RequestMapping("/add")
    public Result addItem(@RequestBody CheckItem item){
        try {
            checkItemService.add(item);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        try {
            PageResult pageResult = checkItemService.pageQuery(queryPageBean);
            return pageResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new PageResult(0L,new ArrayList());
    }

    @RequestMapping("/delete")
    public Result delete( Integer id){
        try {
            checkItemService.delete(id);
        }catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }catch (Exception e){
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    //编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkItemService.edit(checkItem);
        }catch (Exception e){
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            CheckItem checkItem = checkItemService.findById(id);
            return  new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }
    //查询所有
    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<CheckItem> checkItemList = checkItemService.findAll();
            if(checkItemList != null && checkItemList.size() >= 0){
                Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS);
                result.setData(checkItemList);
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
    }
}
