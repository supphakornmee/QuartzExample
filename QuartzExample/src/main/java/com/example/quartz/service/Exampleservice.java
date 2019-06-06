package com.example.quartz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quartz.config.EmailProperties;

@Service
public class Exampleservice {
	
	@Autowired
	EmailProperties emailProperties;

	public void Runtest() {
		
		try {
		System.out.println(emailProperties.getReadmailHost());
		System.out.println(emailProperties.getReadmailPassword());
		}
		catch(Exception e){
			throw e;
			
		}
		
	}
	
}
