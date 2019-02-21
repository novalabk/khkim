package com.example;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DemoApplication {

	public static void main(String[] args) {
		DemoApplication m = new DemoApplication();
		HashMap<Integer, String> map = m.newHashMap();
		map.put(1, "kkk");
		System.out.println("K11KK");
	}
	
	public <T, S> void get(T t, S s) {
		
		//return t;
	}
	
	public <K, V> HashMap<K,V> newHashMap(){
		return new HashMap<K, V>();
	}
}
