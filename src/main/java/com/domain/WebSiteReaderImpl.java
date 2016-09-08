package com.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("WebSiteReaderImplOne")
public class WebSiteReaderImpl implements WebSiteReader {
	
	@Autowired
	WebSiteInitReader webSiteInitReader;
	
	private static final Logger LOG = LoggerFactory.getLogger(WebSiteReaderImpl.class);

	public String webSiteReader() {

		/*
		Document doc = null;
		try {
			doc = Jsoup.connect("http://www.indiabix.com/").get();
			LOG.info("document is : " ,doc);
		} catch (Exception e) {
			LOG.error("falied to connect", e);
		}
		*/
		try{
		Document documentIndiabix = webSiteInitReader.getDoc();	
		
		LOG.info("Document after request : ");			
		LOG.info(documentIndiabix.toString());
		
		return documentIndiabix.toString();		
		}catch(Exception e) {
			LOG.error("Exception is : ", e);
			return "Not found";	
		}	
		
		
		
	}
}
