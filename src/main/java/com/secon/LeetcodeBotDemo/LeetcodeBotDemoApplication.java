package com.secon.LeetcodeBotDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication
public class LeetcodeBotDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeBotDemoApplication.class, args);
		
	}

	 
	   public void run(String... args) throws Exception {
	        String token = "MTI5NzY5MzM1MzU1NDc0MzMyNw.Gaz-mG.WXbSI2AnsSJZO2JxLctrWc3rYPRTG19QgpbvUE";
	        JDA jda = JDABuilder.createDefault(token)
	                .setActivity(net.dv8tion.jda.api.entities.Activity.playing("Spring no Discord!"))
	                .build();
	        jda.awaitReady();
	        System.out.println("Bot está pronto!");
	    }
}
