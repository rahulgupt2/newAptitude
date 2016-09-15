package com.domain;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebSiteInitReader {

	private Document doc;
	
	private static final Logger LOG = LoggerFactory.getLogger(WebSiteInitReader.class);
	
	@PostConstruct
	public void init() {
		
		try {					
			//doc = Jsoup.connect("http://www.indiabix.com/").get();			
			//doc = Jsoup.connect("http://naidunia.jagran.com/madhya-pradesh").get();
			//doc = Jsoup.connect("http://naidunia.jagran.com/madhya-pradesh/indore").get();			
			doc = Jsoup.connect("http://naidunia.jagran.com/madhya-pradesh").get();			
			LOG.info("Document is : ");			
			LOG.info(doc.toString());
		} catch (Exception e) {
			LOG.error("Falied to connect", e);
		}
	}
	
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
}
