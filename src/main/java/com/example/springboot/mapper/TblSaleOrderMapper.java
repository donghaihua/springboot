package com.example.springboot.mapper;

import com.example.springboot.model.TblSaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TblSaleOrderMapper {
    //通过订单编号插叙tbl_sale_order
    @Select("select * from tbl_sale_order where orderNo=#{orderNo} and parent_id is null")
    public TblSaleOrder getByOrderNo(String orderNo);
}
