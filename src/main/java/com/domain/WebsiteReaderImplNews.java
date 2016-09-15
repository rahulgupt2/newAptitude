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



@Component("websiteReaderImplNews")
public class WebsiteReaderImplNews implements WebSiteReaderNews {

	@Autowired
	WebSiteInitReader webSiteInitReader;

	@Autowired
	DocumentBuilder documentBuilder;

	private static final Logger LOG = LoggerFactory.getLogger(WebsiteReaderImplNews.class);

	@Override
	public Response webSiteReader(String cityName) {
		
		Response response = new Response();
			
		Document documentNews = null;
		try {
			documentNews = webSiteInitReader.getDoc();
		} catch (Exception e) {
			LOG.error("Exception is : ", e);
			response.setSucceeded("false");
			response.setResponse("Not Found init");
			
			return response;
		}
		
		if(cityName == null) {
			response.setSucceeded("false");
			response.setResponse("cannot find cityName");			
			return response;
		}
		/*if(cityName.length() > 20 ) {
			response.setSucceeded("false");
			response.setResponse("canot find cityName");
			
			return response;
		}*/		
		String url = documentBuilder.urlBuilderNaiDuniaMadhyaPradesh(cityName);
		LOG.info("url is :", url );
		documentNews = documentBuilder.getDocumnet(url);
					
		Elements elemetsMp = documentNews.getElementsByClass("article-list");
		LOG.info("size is : " + elemetsMp.size());
		
		if(elemetsMp.size() == 0) {
			response.setSucceeded("false");
			response.setResponse("please provide valid city name");			
			return response;
		}	
		
		
		NaiDuniaNews naiduniaNewsAll = new NaiDuniaNews(); 
		List<NaiDuniaOneNews> naiDuniaOneNewsList = new ArrayList<NaiDuniaOneNews>();
		
		
		
		
		elemetsMp.forEach(link -> {
			if (link != null) {
				NaiDuniaOneNews naiDuniaNews = new NaiDuniaOneNews();
				
				Elements elemetsLeft = link.getElementsByClass("left-listing");
				elemetsLeft.forEach(linkLeft -> {
					if (linkLeft != null) {						
						Element elementImgUrl = linkLeft.select("img").get(0);
						LOG.info("linkImage get(0) tag is left-listing : " + elementImgUrl.attr("src"));
						LOG.info("linkImage get(0) tag is left-listing : " + elementImgUrl.outerHtml());
						
						if(elementImgUrl.attr("src").equals("")) {
							naiDuniaNews.setImageUrl(elementImgUrl.absUrl("data-src"));
						}
						else
						{
							naiDuniaNews.setImageUrl(elementImgUrl.absUrl("src"));
						}
						
						//naiDuniaNews.setImageUrl(elementImgUrl.absUrl("src"));
						
						
						//LOG.info("link news tag is left-listing : " + linkLeft.select("a[href]").attr("abs:href"));			
					}
				});				
				//--- right 
				Elements elemetsRight = link.getElementsByClass("right-listing");
				elemetsRight.forEach(linkRight -> {
					if (linkRight != null) {
					
					Element newsUrl = linkRight.select("a[href]").get(0);
					LOG.info("news url is : " + newsUrl.attr("abs:href"));	
					naiDuniaNews.setNewsUrl(newsUrl.attr("abs:href"));
					
					
					LOG.info("news heading  is : " + newsUrl.ownText());	
					naiDuniaNews.setHeadingNews(newsUrl.ownText());
										
					Element time = linkRight.select("p").first();
					LOG.info("time is : " + time.text());
					naiDuniaNews.setTime(time.text());
					Element paraNews = linkRight.select("p").get(1);
					LOG.info("para news is : " + paraNews.text());	
					naiDuniaNews.setParaNews( paraNews.text());
					
					}				
				});
				naiDuniaOneNewsList.add(naiDuniaNews);
			}
		});		
		
		naiduniaNewsAll.setNaiDuniaAllNews(naiDuniaOneNewsList);
		
		
		Element paginationElement =documentNews.getElementsByClass("pagination").get(0);
		Elements elementLinks = paginationElement.select("a[href]");		
		//LOG.info("links of pages : " + elementLinks.outerHtml());		
	
		List<String> paginationUrls = new ArrayList<String>();
		elementLinks.forEach(link -> {			
			String title = null; 
			title = link.attr("title");			
			LOG.info("title is : "+ title);			
			if(title ==null || title.equals("")) {
				LOG.info("pagination urls are : " + link.attr("href"));
				paginationUrls.add(link.attr("href"));
			}		
		});
		naiduniaNewsAll.setPageinationUrls(paginationUrls);
		response.setSucceeded("true");
		response.setNaiDuniaNews(naiduniaNewsAll);
		response.setResponse("successful attempt");

		return response;
		//return "news read sucssful";

	}

}
