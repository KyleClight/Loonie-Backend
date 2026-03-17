package com.belkius.loonie.Repository;

import com.belkius.loonie.Entity.userEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loonieRepository extends JpaRepository<userEntity, Integer>{
    Optional<userEntity> findByEmail(String email);
    
    Boolean existsByUserId(int userId);
}