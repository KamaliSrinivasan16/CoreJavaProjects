package com.ss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.entity.CloudEntity;
import com.ss.repository.CloudRepo;

@RestController
@RequestMapping("/cloud")
public class CloudController {
	
	@Autowired
	CloudRepo cloudRepo;
	
	@GetMapping("/index")
	public String index() {
		return "indexhtml";
	}
	
	@GetMapping("/viewall")
	public List<CloudEntity> getAllData(){
		return cloudRepo.findAll();
		
	}
	
	@GetMapping("/view/{id}")
	public Optional<CloudEntity> getSinglerow(@PathVariable long id) {
		return cloudRepo.findById(id);
	}
	
	@PostMapping("/add")
	public void addData(CloudEntity data) {
		cloudRepo.save(data);
	}

}
