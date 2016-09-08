package com.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.WebSiteInitReader;
import com.model.Response;
import com.service.AptitudeService;



@RestController
public class AptitideController {


	
	
	@Autowired
	AptitudeService aptitudeServiceImplOne;
	
	@CrossOrigin
	@RequestMapping(value = "/aptitude",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Object> getUsers() {
		
		
		String name = aptitudeServiceImplOne.webFileReader();
		
		
		Response response = new Response();
		response.setResponse(name);
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
				
	}
	
	
	
}
