package com.domain.javaaptitude;

import java.util.ArrayList;
import java.util.List;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.model.javaaptitude.JavaParent;
import com.model.javaaptitude.Option;
import com.model.javaaptitude.Question;
import com.util.DocumentBuilder;

@Component("javaAptitudeWriterImpl")
public class JavaAptitudeWriterImpl implements JavaAptitudeBuilder{

	@Autowired
	DocumentBuilder documentBuilder;
	
	@Autowired
	PageVerifier pageVerifier;

	private static final Logger LOG = LoggerFactory.getLogger(JavaAptitudeWriterImpl.class);

	@Override
	public JavaParent getPageContent(String specificUrl) {
	
		
		String url = documentBuilder.urlBuilderhttpeduzip(specificUrl);
		
		Document eduDocument = documentBuilder.getDocumnet(url);
		
		
		if(eduDocument == null) {
			LOG.info("cannot read page");
			return null;
		}
		
		
		Elements elemetsMp = eduDocument.getElementsByClass("mcq");
		
		LOG.info(elemetsMp.size() + "");
		
		
		List<Question> questions = new ArrayList<Question>();
		
		
		
		if(elemetsMp != null && elemetsMp.size() > 0 ) {
			
			int count = 1;
			for(Element mcq : elemetsMp) {
				
			
			
			//elemetsMp.forEach(mcq -> {
				
				
				int index = mcq.elementSiblingIndex();
				Question question = new Question();	
				
				LOG.info("mcq detaills ");
				
				LOG.info("----------------");					
		   
			Elements questionElements = mcq.select("div.question-content.clearfix");
				
			if(questionElements != null && questionElements.size() > 0 ) {
				question.setQuestionID(String.valueOf(count));
				String questionString = questionElements.text();
				question.setQuestion(questionString.substring(3));
				LOG.info(questionString.substring(3));
			}
			
				
		    Elements options = mcq.getElementsByClass("option");
						
		   
			if(options != null && options.size() > 0) {				
				 List<Option> optionList = new ArrayList<Option>();
				options.forEach(option -> {
					
					Option dummyOption = new Option();
					
					int answerIndex = option.elementSiblingIndex();
					dummyOption.setAnswerID(String.valueOf(answerIndex + 1));									
					LOG.info("----------------");			
					LOG.info(option.text().substring(3));
					dummyOption.setAnswer(option.text().substring(3));
					
					
					if(dummyOption != null) {
					optionList.add(dummyOption);
					}
				});				
			
			question.setOptions(optionList);
			}						
			LOG.info("----------------");	
			//LOG.info(mcq.getElementsByClass("color-green").text());
			LOG.info(mcq.select("div.clearfix.margin-bottom-20").text());
			
			Elements correctAnswers = mcq.select("div.clearfix.margin-bottom-20");
			
			if(correctAnswers != null && correctAnswers.size() > 0 ) {
				
				String correctAnswer = correctAnswers.text();
				
				String replacedCorrectAnswer = null;
				
				try {
					replacedCorrectAnswer = pageVerifier.compareAnswerAndReplace(correctAnswer.substring(0, 10));
					
				} catch (Exception e) {
					
					LOG.info("Failed at Question number : " + question.getQuestionID());
					LOG.info("Exception : " + e);
					return null;
				}
				question.setAnswer(replacedCorrectAnswer);
				
				question.setDescription(correctAnswer.substring(10));
				question.setComment(url);
				LOG.info(correctAnswer);
			}	
			
			questions.add(question);
			count++;
				
			}
		}
		
		LOG.info("qestions are");
		LOG.info(questions.toString());
		
		JavaParent javaParent = new JavaParent();
		
		javaParent.setQuestions(questions);
		
		
		return javaParent;
	}
	
	
	
}
