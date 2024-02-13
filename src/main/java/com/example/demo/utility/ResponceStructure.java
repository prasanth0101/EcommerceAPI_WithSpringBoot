package com.example.demo.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Items;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
@Getter
@Setter
public class ResponceStructure<T> {

	private Integer status;
	private String message;
	private T data;
}
