package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.javaaptitude.JavaAptitudeBuilder;
import com.model.javaaptitude.JavaParent;
import com.service.JavaApptitudeService;


@Service("javaApptitudeServiceImpl")
public class JavaApptitudeServiceImpl implements JavaApptitudeService{

	
	@Autowired
	JavaAptitudeBuilder javaAptitudeWriterImpl;
		
	
	
	@Override
	public JavaParent getPage(String url) {
		// TODO Auto-generated method stub
		return javaAptitudeWriterImpl.getPageContent(url);
	}

	
	
	
	
}
