package com.xiao.dao;

import com.xiao.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {


    void add(OrderSetting orderSetting);
    //根据日期范围查询预约设置信息
    List<OrderSetting> getOrderSettingByMonth(String ss);

    //更新可预约人数
    public void editNumberByOrderDate(OrderSetting orderSetting);
    //更新已预约人数
    public void editReservationsByOrderDate(OrderSetting orderSetting);
    public long findCountByOrderDate(Date orderDate);
    //根据预约日期查询预约设置信息
    public OrderSetting findByOrderDate(Date orderDate);

}
