package com.chris.geotag.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.chris.geotag.logger.GeoTagLogger;


public class GeoTagHTTPService {
	HttpURLConnection con;
	
	BufferedReader in;

	public String sendGet(String url) {
		String inputLine;
		StringBuffer response = new StringBuffer();
	
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("GET");
			
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (MalformedURLException e) {
			GeoTagLogger.log(GeoTagLogger.INFO, "MalformedURLException.");
			e.printStackTrace();
		} catch (ProtocolException e) {
			GeoTagLogger.log(GeoTagLogger.INFO, "ProtocolException.");
			e.printStackTrace();
		} catch (IOException e) {
			GeoTagLogger.log(GeoTagLogger.INFO, "IOException.");
			e.printStackTrace();
		}
		
		return response.toString();
	}
}
