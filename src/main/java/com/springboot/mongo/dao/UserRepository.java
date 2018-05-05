package com.springboot.mongo.dao;

import com.springboot.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
}
