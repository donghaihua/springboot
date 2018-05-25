package com.example.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.model.Dhh;

import java.util.List;

public interface DhhService {
    List<Dhh> findAll();

    int insert(JSONObject object);

    void delete(String param);

    Dhh findAndModify(String param);
    //根据条件查询
    List<Dhh> find(String param);

}
