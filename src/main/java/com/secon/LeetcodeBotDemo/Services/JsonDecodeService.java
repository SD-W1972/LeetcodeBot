package com.secon.LeetcodeBotDemo.Services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonDecodeService {
	
	public static String getUrl() throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File("./UrlJSON.json"));
		
		String a = jsonNode.get("url").asText();
		System.out.println(a);
		
		return a;
	}
}
