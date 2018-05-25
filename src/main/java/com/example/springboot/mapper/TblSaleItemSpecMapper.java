package com.example.springboot.mapper;

import com.example.springboot.model.TblSaleItemSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TblSaleItemSpecMapper {
    @Select("select * from tbl_sale_item_spec where id=#{id}")
    public TblSaleItemSpec getById(Long id);
}
