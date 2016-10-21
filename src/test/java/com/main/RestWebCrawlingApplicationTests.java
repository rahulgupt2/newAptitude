package com.main;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.domain.WebSiteReaderImplCityName;
import com.domain.WebsiteReaderImplNews;
import com.model.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestWebCrawlingApplicationTests {

	
	@Autowired
	WebsiteReaderImplNews websiteReaderImplNews; 
	
	private static final Logger LOG = LoggerFactory.getLogger(RestWebCrawlingApplicationTests.class);
	@Test
	public void contextLoads() {
	}
	@Before
	public void setUp() {
		
	}
	@After
	public void afterTest() {
		
	}
	@Test
	public void getResultsPositive() {
		Response response =	websiteReaderImplNews.webSiteReader("/madhya-pradesh/indore-page2");	
		//assertEquals(response, null);	  
		Assert.assertNotEquals(null, response);
	}
	
	@Test
	public void getResultsWhenCityIsNull() {
		Response response =	websiteReaderImplNews.webSiteReader(null);	
		//assertEquals(response, null);	  
		Assert.assertEquals("false", response.getSucceeded());
		Assert.assertEquals("cannot find cityName", response.getResponse());
	}

	@Test
	public void getResultsWhenCityIsIncorrect() {
		Response response =	websiteReaderImplNews.webSiteReader("/madhya-pradesh/inde-page2");	
		//assertEquals(response, null);	  
		Assert.assertEquals("false", response.getSucceeded());
		Assert.assertEquals("please provide valid city name", response.getResponse());
	}

	
	
	
	
	
	
}
