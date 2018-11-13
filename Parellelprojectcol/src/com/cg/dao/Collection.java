package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.dto.Customer;

public class Collection {
	private static Map<String, Customer> customer;
	static Map<String, Customer> createCollection(){
		if(customer == null)
			customer = new HashMap<>();		
		return customer;		
	}

}
