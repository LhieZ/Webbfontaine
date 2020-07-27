package com.webbfontaine.analysis.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

@Component
public class JsonFetcher {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonFetcher.class);
	 
	public List<JSONObject>  urlToJson(String urlString) {
		
		StringBuilder sb = null;
		List<JSONObject> listJsonObject = null;
		try {
        	URL url = new URL(urlString);
            URLConnection urlCon = url.openConnection();
            
            LOGGER.info("reading data from URL as InputStream");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
           
            String inputLine;
            sb = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            LOGGER.info("Exception while reading JSON from URL - {}", e);
        }
        
        if (sb != null) {
        	JSONArray jArray = new JSONArray(sb.toString());
        	listJsonObject = convertToJsonObjects(jArray);
        }
		return listJsonObject; 
	}
	
	private static List<JSONObject> convertToJsonObjects(JSONArray jsonArray) {
		List<JSONObject> jsonObjects = new ArrayList<>();
		jsonArray.forEach(jsonArrayObject -> {
			if (jsonArrayObject instanceof JSONObject) {
				jsonObjects.add(new JSONObject(jsonArrayObject.toString()));
			} else {
				throw new JsonParseException();
			}
		});
		return jsonObjects;
	}
}
