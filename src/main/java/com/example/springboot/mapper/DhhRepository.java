package com.example.springboot.mapper;

import com.example.springboot.model.Dhh;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DhhRepository extends MongoRepository<Dhh,Object> {
}
