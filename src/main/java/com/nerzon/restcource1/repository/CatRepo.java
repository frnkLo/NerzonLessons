package com.nerzon.restcource1.repository;

import com.nerzon.restcource1.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository <Cat, Integer> {
}
