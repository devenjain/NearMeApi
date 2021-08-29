package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bean.BuisnessBean;
import com.bean.UserLocationBean;
import com.dao.MainDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MainController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MainDao dao;
		
	@PostMapping(value = "/nearMe", consumes = MediaType.APPLICATION_JSON_VALUE)
	public BuisnessBean[] findBuisness(@RequestBody UserLocationBean userLocationBean){
		
		double userLatitude = userLocationBean.getLatitude();
		double userLongitude = userLocationBean.getLongitude();
		
		System.out.println("user - latitude : " + userLatitude);
		System.out.println("user - longitude : " + userLongitude);
		
		String url = "https://boni.co.in/v1/businesses";
	
		ObjectMapper objMapper = new ObjectMapper();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		
		ResponseEntity<String> res = restTemplate.exchange (builder.buildAndExpand ().toUri(), HttpMethod.GET, null, String.class);
		
		System.out.println(res);
		
		MainDao dao = new MainDao();
		
		BuisnessBean buisnessBean[] = null;
		
		try {
			buisnessBean = objMapper.readValue(res.getBody(), BuisnessBean[].class);
			
			System.out.println();
			System.out.println();
			System.out.println("bus - lat : " + buisnessBean[2].getLatitude());
			System.out.println("bus - lon : " + buisnessBean[2].getLongitude());
			
			for (int i = 0; i < buisnessBean.length; i++) {
				
				BuisnessBean busBean = buisnessBean[i];
			
				Double buisnessLatitude = busBean.getLatitude();
				Double buisnesslongitude = busBean.getLongitude();
				
				Double distance = dao.distance(userLatitude, userLongitude, buisnessLatitude, buisnesslongitude, "K");
				
				busBean.setDistance(distance);
				
//				System.out.println("\nBuisnessLatitude : " + buisnessLatitude + "\nBuisnessLongitude : " + buisnesslongitude + "\nDistance : " + distance);
										
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buisnessBean;
		
	}
	
//	@PostMapping(value = "/nearMe", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public BuisnessBean[] findBuisness(@RequestParam Double userLatitude,@RequestParam Double userLongitude){
//		
////		double userLatitude = userLocation.getLatitude();
////		double userLongitude = userLocation.getLongitude();
//		
//		System.out.println("user - latitude : " + userLatitude);
//		System.out.println("user - longitude : " + userLongitude);
//		
//		String url = "https://boni.co.in/v1/businesses";
//	
//		ObjectMapper objMapper = new ObjectMapper();
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
//		
//		ResponseEntity<String> res = restTemplate.exchange (builder.buildAndExpand ().toUri(), HttpMethod.GET, null, String.class);
//		
//		System.out.println(res);
//		
//		MainDao dao = new MainDao();
//		
//		BuisnessBean buisnessBean[] = null;
//		
//		try {
//			buisnessBean = objMapper.readValue(res.getBody(), BuisnessBean[].class);
//			
//			System.out.println();
//			System.out.println();
//			System.out.println("bus - lat : " + buisnessBean[2].getLatitude());
//			System.out.println("bus - lon : " + buisnessBean[2].getLongitude());
//			
//			for (int i = 0; i < buisnessBean.length; i++) {
//				
//				BuisnessBean busBean = buisnessBean[i];	
//				
//				Double buisnessLatitude = busBean.getLatitude();
//				Double buisnesslongitude = busBean.getLongitude();
//				
//				Double distance = dao.distance(userLatitude, userLongitude, buisnessLatitude, buisnesslongitude, "K");
//				
//				busBean.setDistance(distance);
//				
////				System.out.println("\nBuisnessLatitude : " + buisnessLatitude + "\nBuisnessLongitude : " + buisnesslongitude + "\nDistance : " + distance);
//										
//			}
//			
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return buisnessBean;
//		
//	}

}