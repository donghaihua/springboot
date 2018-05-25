package com.example.springboot.mapper;

import com.example.springboot.model.TblSaleItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TblSaleItemMapper {
    //根据id查询出商品的名称
    @Select("select * from tbl_sale_item where id=#{id}")
    public TblSaleItem getById(Long id);
}
