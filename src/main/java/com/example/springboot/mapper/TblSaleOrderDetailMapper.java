package com.example.springboot.mapper;

import com.example.springboot.model.TblSaleOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TblSaleOrderDetailMapper {
    //通过订单记录的id查询detail表
    @Select("select * from tbl_sale_order_detail where order_id=#{id}")
    public TblSaleOrderDetail getById(Long id);
}


