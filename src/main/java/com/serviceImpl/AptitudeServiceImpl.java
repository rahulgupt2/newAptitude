package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.WebSiteReader;
import com.service.AptitudeService;

@Service("aptitudeServiceImplOne")
public class AptitudeServiceImpl implements AptitudeService{

	
	@Autowired
	WebSiteReader WebSiteReaderImplOne; 
	
	
	
	@Override
	public String webFileReader() {
		// TODO Auto-generated method stub
		return WebSiteReaderImplOne.webSiteReader();
	}

}
