package com.example.springboot.service.impl;

import com.example.springboot.Util.MD5Util;
import com.example.springboot.mapper.TbUserMapper;
import com.example.springboot.model.TbUser;
import com.example.springboot.service.findByIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class findByIdServiceImpl implements findByIdService {
    private Logger logger= LoggerFactory.getLogger(findByIdServiceImpl.class);
    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser findByid(Long id) {

        return tbUserMapper.findById(id);
    }

    @Override
    public List<TbUser> findAll() {
        List<TbUser> list=tbUserMapper.findAll();
        return list;
    }

    @Override
    public Map<String,Object> selectByAccount(String account,String password) {
        Map<String,Object> map=new HashMap<>();
        TbUser user=tbUserMapper.selectByAccount(account);
        if(user==null){
            map.put("code",-1);
            map.put("msg","用户名不正确，请输入正确的用户名");
        }else{
            String str= MD5Util.getMD5(password);
            logger.info("加密后的密码为{}",str);
            if(!str.equals(user.getPassword())){
                map.put("code",-1);
                map.put("msg","密码不正确，请重新输入密码");
            }else{
                map.put("code",0);

            }
        }
        return map;

    }
}
