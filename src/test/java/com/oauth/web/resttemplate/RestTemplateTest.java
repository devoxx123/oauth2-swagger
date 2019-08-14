package com.oauth.web.resttemplate;


import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.oauth.web.entities.User;

public class RestTemplateTest {

	private static final String POST_SAVE_URL = "http://localhost:9000/user/adduser";
	private static final String FIND_ALL_URL = "http://localhost:9000/user/listofusers";

	public static void main(String[] args) {
		RestTemplateTest template = new RestTemplateTest();
		template.addUser();
		template.listOfUsers();

	}

	private static void addUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		User userDetails = new User();
		userDetails.setUsername("kishorem");
		userDetails.setPassword("09090");
		userDetails.setEmail("kishore@gmail.com");
		userDetails.setPhone("9876543221");
		userDetails.setCity("Bangalore");
		userDetails.setState("KA");
		userDetails.setPinCode("4500343");
		userDetails.setActivationKey(userDetails.getActivationKey());
		userDetails.setCreateDate(new Date());
		userDetails.setUpdateDate(new Date());
		HttpEntity<User> reqEntity = new HttpEntity<User>(userDetails, headers);
		ResponseEntity<String> resEntity = restTemplate.exchange(POST_SAVE_URL, HttpMethod.POST, reqEntity,
				String.class);
		HttpStatus statusCode = resEntity.getStatusCode();
		System.out.println("Response Satus Code: " + statusCode);
		System.out.println(resEntity.getBody());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void listOfUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> reqEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> resEntity = restTemplate.exchange(FIND_ALL_URL, HttpMethod.GET, reqEntity,
				String.class);
		HttpStatus statusCode = resEntity.getStatusCode();
		System.out.println("Response Satus Code: " + statusCode);
		System.out.println(resEntity.getBody());
		
	}
}
