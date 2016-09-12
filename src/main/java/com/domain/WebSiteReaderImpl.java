package com.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.util.DocumentBuilder;

@Component("WebSiteReaderImplOne")
public class WebSiteReaderImpl implements WebSiteReader {

	@Autowired
	WebSiteInitReader webSiteInitReader;
	
	@Autowired
	DocumentBuilder documentBuilder;

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteReaderImpl.class);

	public String webSiteReader() {
	/*	Document documentIndiabix = null;		
		try {
			documentIndiabix = webSiteInitReader.getDoc();
		} catch (Exception e) {
			LOG.error("Exception is : ", e);
			return "Not found";
		}
		// list of element 
		Elements links = documentIndiabix.select("a[href]");		
		if(links == null) {
			return "no links found";
		}				
		String arithmeticAptitude= "";		
		for(Element link : links) {				
			if(link != null) {
			if(link.ownText().equals("Arithmetic Aptitude")) {
					LOG.info("link is " + link.attr("abs:href"));
					arithmeticAptitude = link.attr("abs:href");
					break;
				}
			}
		}		
		LOG.info("link of arithmatic : " + arithmeticAptitude);		
		Document documentArithmeticAptitude = null;		
		documentArithmeticAptitude = documentBuilder.getDocumnet(arithmeticAptitude);
		Elements linksArithmeticAptitude = documentArithmeticAptitude.select("a[href]");
		for(Element link : linksArithmeticAptitude) {			
			if(link != null) {
			if(link.ownText().equals("Problems on Trains")) {
					LOG.info("link is " + link.attr("abs:href"));
					arithmeticAptitude = link.attr("abs:href");
					break;
				}
			}
		}
		
		Document documentProblemOnTrain = null;		
		documentProblemOnTrain = documentBuilder.getDocumnet(arithmeticAptitude);				
		LOG.info("link of problems on trains  : " + arithmeticAptitude);	
		// got questions start
		Elements classFullBox = documentProblemOnTrain.getElementsByClass("bix-tbl-container");
								
		classFullBox.forEach(oneBox -> {		
			
			oneBox.getElementsByClass("bix-td-qtxt").forEach(question -> {	
				Elements pTagQestionBox = question.getElementsByTag("p");		
				pTagQestionBox.forEach(pTagQuestion -> {				
					LOG.info("text inside p text is : " + pTagQuestion.ownText());				
				});			
			oneBox.getElementsByClass("bix-td-miscell").forEach(optionsAndsolution -> {
				Elements options = optionsAndsolution.getElementsByClass("bix-td-option");		
				options.forEach(option -> {				
					LOG.info("text inside p text is : " + option.ownText());				
				});			
				
			});				
	});
					
});*/
	
	/*
		Elements classQuestionBox = documentProblemOnTrain.getElementsByClass("bix-td-qtxt");						
		LOG.info(classQuestionBox.toString());		
		classQuestionBox.forEach(question -> {			
			LOG.info("text in question box : " + question.ownText());			
			Elements pTagQestionBox = question.getElementsByTag("p");		
			pTagQestionBox.forEach(pTagQuestion -> {				
				LOG.info("text inside p text is : " + pTagQuestion.ownText());				
			});		
		});
	*/
	// got questions end
		
		
		
		
		
		
		return "read link successfully";
	}
}
