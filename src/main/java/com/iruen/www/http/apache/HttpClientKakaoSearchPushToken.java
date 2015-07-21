package com.iruen.www.http.apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.iruen.www.helper.Config;

public class HttpClientKakaoSearchPushToken {

	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static URIBuilder builder= new URIBuilder();
	private static String uuid = Config.getInstance().getProperties("uuid");
	private static String adminKey = Config.getInstance().getProperties("adminKey");
	private static HttpClientKakaoPushTokenRegister tokenRegister = new HttpClientKakaoPushTokenRegister();
	
	public void searchToken() {
		
		builder.setScheme("https");
		builder.setHost("kapi.kakao.com");
		builder.setPath("/v1/push/tokens");
		builder.setParameter("uuid", uuid);
		
		try {
			tokenRegister.tokenRegister();
			
			HttpGet httpGet = new HttpGet(builder.build());
			httpGet.addHeader("Authorization", adminKey);
			
			System.out.println("executing request : " + httpGet.getURI());
			
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			
			System.out.println("---------------------------------------- token search start ----------------------------------------");
			System.out.println(response.getStatusLine());
			if (entity != null) {
				System.out.println("Response content length: " + entity.getContentLength());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

				String line = "";
				while ((line = rd.readLine()) != null) {
					System.out.println(line);
				}

			}
			httpGet.abort();
			System.out.println("---------------------------------------- token search end ----------------------------------------\n");
		} catch (URISyntaxException e) {
			// TODO: handle exception
		}catch (ClientProtocolException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
