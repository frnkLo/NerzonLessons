package com.nerzon.restcource1.repository;

import com.nerzon.restcource1.entity.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogRepo extends MongoRepository<Dog, UUID> {

    Dog findByName(String name);

}