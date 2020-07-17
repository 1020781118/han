package com.haohan.ssm.dao;



import com.haohan.ssm.domain.Member;
import com.haohan.ssm.domain.Orders;
import com.haohan.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
            one = @One(select = "com.haohan.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.haohan.ssm.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,
                    one = @One(select = "com.haohan.ssm.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,
                    many = @Many(select = "com.haohan.ssm.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;
}
