package com.demo.demodatabase.repository;

import com.demo.demodatabase.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer>{
}
