package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Items;
import com.example.demo.requestDto.ItemsRequest;
import com.example.demo.responceDto.ItemsResponce;
import com.example.demo.service.IItemsService;
import com.example.demo.utility.ResponceStructure;

import lombok.Getter;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ItemsController {
	
	@Autowired
	private IItemsService service;

	@PostMapping("/insert")
	public ResponseEntity<ResponceStructure<ItemsResponce>> insert(@RequestBody ItemsRequest items){
		return service.post(items);
	}
	@GetMapping("/get")
	public ResponseEntity<ResponceStructure<List<ItemsResponce>>> getall(){
		return service.getall();
	}
	@GetMapping("/get-by-category/{category}")
	public ResponseEntity<ResponceStructure<List<ItemsResponce>>> getByCategory(@PathVariable String category){
		
		    return service.getByCategory(category);
			
	}
	
}
