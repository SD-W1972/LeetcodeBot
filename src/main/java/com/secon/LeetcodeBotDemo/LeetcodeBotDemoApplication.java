package com.secon.LeetcodeBotDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secon.LeetcodeBotDemo.NonPersistent.LeetCodeProblemLinks;
import com.secon.LeetcodeBotDemo.Services.JsonDecodeService;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication
public class LeetcodeBotDemoApplication implements CommandLineRunner{

	@Autowired
	JsonDecodeService jsonDecodeService = new JsonDecodeService();
	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeBotDemoApplication.class, args);
        LeetCodeProblemLinks.urls()
;
        }

	 
	   public void run(String... args) throws Exception {
	        String nekot = "";
	        
	     
	        
	        JDA jda = JDABuilder.createDefault(nekot)
	                .setActivity(net.dv8tion.jda.api.entities.Activity.playing("Spring no Discord!"))
	                
	                .build();
	        jda.awaitReady();
	        
	        
	        System.out.println("Bot está pronto!");
			   
	       
	    	
		/*	Web scrapping Leetcode will not work as any scraping requisition returns 403 status 
		 * try {
			String url = " https://leetcode.com/problemset/all/";
			
			Document document = Jsoup.connect(url).get();
			
			Elements links = document.select("a[href]");
			
			for(Element link : links) {
				System.out.println(link.attr("abs.href"));
			}
		
			}catch(Exception e){
				e.printStackTrace();
			}*/
			
	        }
}
