package com.secon.LeetcodeBotDemo.NonPersistent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class LeetCodeProblemLinks {
    public static void main(String[] args) {
    	urls();
   
    }
    
    public static void urls() {
   	 // URL da API do LeetCode
        String apiUrl = "https://leetcode.com/api/problems/all/";
        try { 
            // Fazer requisição HTTP GET
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // Ler resposta
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                // Parse JSON e gerar links
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray problems = jsonResponse.getJSONArray("stat_status_pairs");

                BufferedWriter writer = new BufferedWriter(new FileWriter("leetcode_all_links.txt"));
                int count = 0;
                for (int i = 0; i < problems.length(); i++) {
                    JSONObject problem = problems.getJSONObject(i).getJSONObject("stat");
                    boolean isHidden = problems.getJSONObject(i).getBoolean("paid_only");
                    
                
                    if (!isHidden) {
                        String slug = problem.getString("question__title_slug");
                        String link = "https://leetcode.com/problems/" + slug + "/";
                        writer.write(link);
                        writer.newLine();
                        count++;
                    }
                }

                writer.close();
                System.out.println(count + " links salvos em 'leetcode_all_links.txt'");

            } else {
                System.out.println("Erro ao acessar a API do LeetCode. Código de resposta: " + responseCode);
            }
        } catch (JSONException|IOException e) {
            e.printStackTrace();
        } 
       
    }
    
}
