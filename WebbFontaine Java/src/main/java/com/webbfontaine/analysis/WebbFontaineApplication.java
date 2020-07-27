package com.webbfontaine.analysis;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WebbFontaineApplication{
	 
	public static void main(String[] args) throws JSONException, IOException {

	    SpringApplication.run(WebbFontaineApplication.class, args);
		
	}
}
