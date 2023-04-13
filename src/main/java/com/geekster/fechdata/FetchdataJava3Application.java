package com.geekster.fechdata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class FetchdataJava3Application {

	public static void main(String[] args) throws Exception {
		URL getUrl=new URL("https://api.nationalize.io/?name=nathaniel");
		
		HttpURLConnection connection=(HttpURLConnection) getUrl.openConnection();
		
		connection.setRequestMethod("GET");
		int response=connection.getResponseCode();
		
		if(response==200) {
			BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder json=new StringBuilder();
			
			String readLine=null;
			
			while((readLine=in.readLine())!=null) {
				
				json.append(readLine);
				
			}
			in.close();
			
			JSONObject ob1=new JSONObject(json.toString());
			System.out.println(ob1.toString());
			
			
			
		}else {
			System.out.println(response);
		}
	}

}
