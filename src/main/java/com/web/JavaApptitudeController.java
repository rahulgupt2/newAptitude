package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Response;
import com.model.javaaptitude.JavaParent;
import com.service.JavaApptitudeService;
import com.util.DocumentBuilder;

@RestController
public class JavaApptitudeController {

	
	@Autowired
	JavaApptitudeService javaApptitudeServiceImpl;
	
	private static final Logger LOG = LoggerFactory.getLogger(JavaApptitudeController.class);
	
	@CrossOrigin
	@RequestMapping(value = "/javaapptitude", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JavaParent> getjavaapptitude(@RequestHeader(value="suburl") String subUrl) {
		
		
		//LOG.info("url is " + specificUrl);
		
		LOG.info("url is " + subUrl);
		
		JavaParent jParent = javaApptitudeServiceImpl.getPage(subUrl);
		
		return new ResponseEntity<JavaParent>(jParent, HttpStatus.OK);

	}

}
