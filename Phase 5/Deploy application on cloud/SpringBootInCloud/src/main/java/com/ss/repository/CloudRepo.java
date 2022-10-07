package com.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.entity.CloudEntity;

@Repository
public interface CloudRepo extends JpaRepository<CloudEntity, Long> {

}
