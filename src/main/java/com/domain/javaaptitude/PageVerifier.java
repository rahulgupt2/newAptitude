package com.domain.javaaptitude;

import org.springframework.stereotype.Component;

@Component
public class PageVerifier {
	
	protected String compareAnswerAndReplace(String answer) throws Exception {
		
		String replacedValue = null;
		switch(answer) {
		case "Answer: A.":
			replacedValue = "1";
			break;
		case "Answer: B.":
			replacedValue = "2";
			break;
		case "Answer: C.":
			replacedValue = "3";
			break;
		case "Answer: D.":
			replacedValue = "4";
			break;
		default : 
			throw new Exception("Cannot Match Answers");
		}		
		return replacedValue;
	}
	
}
