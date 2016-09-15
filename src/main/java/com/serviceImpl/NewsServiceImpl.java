package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.WebSiteReader;
import com.domain.WebSiteReaderImpl;
import com.domain.WebSiteReaderNews;
import com.model.Response;
import com.service.NewsService;



@Service("newsServiceImplOne")
public class NewsServiceImpl implements NewsService{

	

	@Autowired
	WebSiteReaderNews websiteReaderImplNews; 
	
	@Autowired
	WebSiteReaderNews webSiteReaderImplCityName;
	
	
	@Override
	public Response webFileReader(String cityName) {
		
		// TODO Auto-generated method stub
		//return WebsiteReaderImplNews.webSiteReader(cityName);
		
		// for testing we have made this 
		return websiteReaderImplNews.webSiteReader(cityName);
	}

	
	
}
