package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer>{
	Hello findByName(String name);
}
