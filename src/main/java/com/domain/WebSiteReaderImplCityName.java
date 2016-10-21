package com.domain;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.NaiDuniaNews;
import com.model.NaiDuniaOneNews;
import com.model.Response;
import com.util.DocumentBuilder;

@Component("webSiteReaderImplCityName")
public class WebSiteReaderImplCityName implements WebSiteReaderNews{

	@Autowired
	WebSiteInitReader webSiteInitReader;

	@Autowired
	DocumentBuilder documentBuilder;

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteReaderImplCityName.class);
	
	
	
	@Override
	public Response webSiteReader(String cityName) {
		// TODO Auto-generated method stub
		
		
		Response response = new Response();
		NaiDuniaNews naiDuniaNews = new NaiDuniaNews(); 
		List<NaiDuniaOneNews> naiDuniaNewsList = new ArrayList<NaiDuniaOneNews>();
		
		Document documentNews = null;
		try {
			documentNews = webSiteInitReader.getDoc();
		} catch (Exception e) {
			LOG.error("Exception is : ", e);
			response.setSucceeded("false");
			response.setResponse("Not Found init");			
			return response;
		}		
		
		Elements newsUrls = documentNews.select("a[href]");
		
		newsUrls.forEach(newsUrl -> {
			
			LOG.info("news urls : " + newsUrl.text());
			LOG.info("news urls : " + newsUrl.attr("href"));
			
			NaiDuniaOneNews oneNews = new NaiDuniaOneNews();
			oneNews.setNewsUrl(newsUrl.attr("href"));
			oneNews.setParaNews( newsUrl.text());
			naiDuniaNewsList.add(oneNews);
		});
		
		naiDuniaNews.setNaiDuniaAllNews(naiDuniaNewsList);
		response.setNaiDuniaNews(naiDuniaNews);
			
		return response;
	}
	
}
