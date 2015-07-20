package com.iruen.www.http.apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iruen.www.helper.Config;
import com.iruen.www.kakao.domain.KakaoProfile;

public class HttpClientKakaoProfile {

	// HttpClient 积己
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static String access_token = "Bearer " + Config.getInstance().getProperties("access_token");

	public static void main(String[] args) {
		try {
			// HttpGet积己
			HttpGet httpget = new HttpGet("https://kapi.kakao.com/v1/api/talk/profile");

			System.out.println("executing request : " + httpget.getURI());

			httpget.addHeader("Authorization", access_token);
			httpget.addHeader("Content-Type", "text/html; charset=utf-8");
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();

			System.out.println("---------------------------------------- start ----------------------------------------");
			// 览翠 搬苞
			System.out.println(response.getStatusLine());
			if (entity != null) {
				System.out.println("Response content length: " + entity.getContentLength());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
				
				String profile = rd.readLine();
				JsonObject kakaoProfile = new JsonParser().parse(profile).getAsJsonObject();
				System.out.println("kakaoProfile As JsonObject : " +  kakaoProfile + "\n");
				
				System.out.println("**********************  JsonObject => kakaoProfile  **********************");
				KakaoProfile kakaoProfileFromJson = new Gson().fromJson(kakaoProfile, KakaoProfile.class);
				System.out.println("Nickname : " + kakaoProfileFromJson.getNickName());
				System.out.println("profileImageURL : " + kakaoProfileFromJson.getProfileImageURL());
				System.out.println("thumbnailURL : " + kakaoProfileFromJson.getThumbnailURL());
				System.out.println("countryISO : " + kakaoProfileFromJson.getCountryISO());
	
			}
			httpget.abort();
			System.out.println("---------------------------------------- end ----------------------------------------");
			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException ee) {
			ee.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
}
