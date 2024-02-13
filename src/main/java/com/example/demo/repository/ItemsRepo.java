package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Items;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer>{

	List<Items> getByCategory(String category);

}
