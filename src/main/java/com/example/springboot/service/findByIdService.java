package com.example.springboot.service;

import com.example.springboot.model.TbUser;

import java.util.List;
import java.util.Map;

public interface findByIdService {

    public TbUser findByid(Long id);
    public List<TbUser> findAll();
    public Map<String,Object> selectByAccount(String account, String password);


}
