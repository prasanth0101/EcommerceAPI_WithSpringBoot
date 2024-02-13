package com.example.demo.requestDto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor@AllArgsConstructor
public class ItemsRequest {
	private String name;
	private String category;
	private String img;
	private Double price;
}
