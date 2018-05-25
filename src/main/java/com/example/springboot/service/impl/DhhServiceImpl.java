package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.Util.MD5Util;
import com.example.springboot.mapper.DhhRepository;
import com.example.springboot.mapper.TbUserMapper;
import com.example.springboot.model.Dhh;
import com.example.springboot.service.DhhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DhhServiceImpl implements DhhService {
    @Autowired
    private DhhRepository dhhRepository;
    @Resource
    private TbUserMapper tbUserMapper;
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 测试monogodb的findall的方法
     * @return
     */
    @Override
    public List<Dhh> findAll() {

        return mongoTemplate.findAll(Dhh.class);
    }

    @Override
    public List<Dhh> find(String param) {
        Query query=new Query(Criteria.where("tel").is(param));
        query.fields().include("person.name").include("like");
        return mongoTemplate.find(query, Dhh.class);
    }

    /**
     * 测试monogodb的根据条件删除
     * @param param
     */
    @Override
    public void delete(String param) {
        dhhRepository.deleteById(param);


    }

    /**
     * 测试MD5加密算法
     * @param object
     */
    @Override
    public int insert(JSONObject object) {
        object.put("created",new Date());
        object.put("updated",new Date());
        String password=object.getString("password");
        password= MD5Util.getMD5(password);
        object.put("password",password);
        int count=tbUserMapper.insert(object);
        return count;

    }
    private int count=0;
    @Scheduled(cron="*/6 * * * * ?")
    public void process(){
        System.out.println("this is scheduler task runing "+(count++));
    }

    /**
     * 测试findandmodify的update用法
     * @param param
     * @return
     */
    @Override
    public Dhh findAndModify(String param) {
        Query query=new Query(Criteria.where("tel").is("18551629839"));
        Dhh dhh=mongoTemplate.findAndModify(query,new Update().set("person.name",param),Dhh.class);
        return dhh;
    }
}
