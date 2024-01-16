package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer>{
	List<Alien> findByLang(String lang);

     
}
