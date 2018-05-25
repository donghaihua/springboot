package com.example.springboot.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.model.TbUser;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface TbUserMapper {
    @Select("select * from tb_user where id=#{id}")
    TbUser findById(Long id);



    class CcolumnSqlProvider {
        public String insertSql(JSONObject map) {
            return new SQL() {
                {
                    INSERT_INTO("tb_user");
                    for (String key : map.keySet()) {
                        VALUES(key, "#{" + key + "}");
                    }
                }
            }.toString();
        }
    }

    @InsertProvider(type=CcolumnSqlProvider.class,method = "insertSql")
    int insert(JSONObject map);


    @Select("select * from tb_user")
    List<TbUser> findAll();

    @Select("select * from tb_user where username=#{account}")
    TbUser selectByAccount(String account);
}
