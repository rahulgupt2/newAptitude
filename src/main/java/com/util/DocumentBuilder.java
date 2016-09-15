package com.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.domain.WebSiteReaderImpl;

@Component
public class DocumentBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentBuilder.class);
	
	public Document getDocumnet(String url) {
	
		Document doc = null;	
		
		try {					
			doc = Jsoup.connect(url).get();
			LOG.info("Document is : ");			
			LOG.info(doc.toString());
			return doc;
		} catch (Exception e) {
			LOG.error("Falied to connect", e);
			return doc;
		}		
	}	
	
	public String urlBuilderNaiDuniaMadhyaPradesh(String cityName) {
		
		String url = "http://naidunia.jagran.com/" + cityName;		
		return url;		
	}
	
	
	
}
