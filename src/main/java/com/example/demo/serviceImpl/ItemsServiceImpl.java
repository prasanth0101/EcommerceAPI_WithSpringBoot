package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Items;
import com.example.demo.repository.ItemsRepo;
import com.example.demo.requestDto.ItemsRequest;
import com.example.demo.responceDto.ItemsResponce;
import com.example.demo.service.IItemsService;
import com.example.demo.utility.ResponceStructure;

@Service
public class ItemsServiceImpl implements IItemsService {
	
	@Autowired
	private ItemsRepo repo;

	@Autowired
	private ResponceStructure<List<ItemsResponce>> structure;
	
	@Autowired
	private ResponceStructure<ItemsResponce> responseStructure;

	public Items toItems(ItemsRequest items) {
		return Items.builder().name(items.getName()).img(items.getImg()).price(items.getPrice())
				.category(items.getCategory()).build();
	}

	public ItemsResponce toItemsResponce(Items items) {

		return ItemsResponce.builder().id(items.getId()).name(items.getName()).img(items.getImg())
				.price(items.getPrice()).category(items.getCategory()).build();

	}

	@Override
	public ResponseEntity<ResponceStructure<ItemsResponce>> post(ItemsRequest items) {
		Items save = repo.save(toItems(items));
		ItemsResponce itemsResponce = toItemsResponce(save);

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("item Created Sucessfully!");
		responseStructure.setData(itemsResponce);

		return new ResponseEntity<ResponceStructure<ItemsResponce>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponceStructure<List<ItemsResponce>>> getall() {
		List<Items> findAll = repo.findAll();
		
		List<ItemsResponce> alldata = findAll.stream().map(e->toItemsResponce(e)).collect(Collectors.toList());
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(alldata);
		structure.setMessage("got all data");
		
		return new ResponseEntity<ResponceStructure<List<ItemsResponce>>>(structure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponceStructure<List<ItemsResponce>>> getByCategory(String category) {
		List<Items> items = repo.getByCategory(category);
		
		List<ItemsResponce> itemsresponse = items.stream().map(e -> toItemsResponce(e)).collect(Collectors.toList());
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(itemsresponse);
		structure.setMessage("got "+category +" data");
		
		return new ResponseEntity<ResponceStructure<List<ItemsResponce>>>(structure,HttpStatus.FOUND);
	}

}
