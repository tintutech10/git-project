package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;



@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
    @ResponseBody
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
    @ResponseBody
	@RequestMapping("home")
    public String getHome(@RequestParam String name, @RequestParam int age, @RequestParam String place) {
    	return "Welcome"+name+" age "+age+ " place "+place;
    }
    
	
	
	  @PostMapping("aliens")
	  
	  public List<Alien> AddAlien(@RequestBody List<Alien> alien) {
	  
	  repo.saveAll(alien);
	  
	  return alien;
	  }
	  

	  @PostMapping("add")
	  
	  public Alien Add(@RequestBody Alien alien) {
	  
	  repo.save(alien);
	  
	  return alien; 
	  }
	  
	  @PutMapping("add")
	  
	  public Alien SaveOrUpdate(@RequestBody Alien alien) {
	  
	  repo.save(alien);
	  
	  return alien; 
	  }
	  
	  @DeleteMapping("delete/{id}")
	  public String deleteAlien(@PathVariable int id) {
		  
		  repo.deleteById(id);
		  return "deleted";
		  
	  }
	 
	 
    
    @RequestMapping("add")
    @ResponseBody
    public String AddAlien(Alien alien) {
    	
    	repo.save(alien);
    	
    	return "Successfull";
    }
    
    @RequestMapping("get")
    @ResponseBody
    public Optional<Alien> getAlien(@RequestParam int id) {
    	
    	Optional<Alien> aid=repo.findById(id);
    	//System.out.println(aid);
    	
    	return aid;
    }
    
    @GetMapping("get")
    
    public Optional<Alien> getAlienById(@RequestParam int id) {
    	
    	System.out.println("get----");
    	Optional<Alien> aid=repo.findById(id);
    	//System.out.println(aid);
    	
    	return aid;
    }
    
    @DeleteMapping("get")
    
    public String deleteById(@RequestParam int id) {
    	
    	System.out.println("delete----");
    	repo.deleteById(id);
    	//System.out.println(aid);
    	
    	return "deleted";
    }
    
    
    @RequestMapping("home/{name}/{age}/{place}")
    @ResponseBody
    public String gethomeDetails(@PathVariable String name, @PathVariable Integer age, @PathVariable String place) {
    	return "Welcome" +name+" age "+age+" place "+place;
    	
    }
    
    @RequestMapping("getlan")
    @ResponseBody
    public List<Alien> getByLan(@RequestParam String lang) {
    	
    	List<Alien> alien=repo.findByLang(lang);
    	System.out.println(alien);
    	
    	return alien;
    }
    @GetMapping(path="aliens",produces= {"application/xml"})
  
    public Iterable<Alien> getAliens() {
    	
    	Iterable<Alien> alien=repo.findAll();
    	System.out.println(alien);
    	
    	return alien;
    }
    
   
}
