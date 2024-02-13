package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Items;
import com.example.demo.requestDto.ItemsRequest;
import com.example.demo.responceDto.ItemsResponce;
import com.example.demo.utility.ResponceStructure;

@Service
public interface IItemsService {

	ResponseEntity<ResponceStructure<ItemsResponce>> post(ItemsRequest items);

	ResponseEntity<ResponceStructure<List<ItemsResponce>>> getall();

	ResponseEntity<ResponceStructure<List<ItemsResponce>>> getByCategory(String category);

}
