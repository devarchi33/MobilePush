package com.iruen.www.http.apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.iruen.www.helper.Config;

public class HttpClientKakaoSendPushMessage {
	// HttpClient 积己
			private static HttpClient httpClient = HttpClientBuilder.create().build();
			private static String adminKey = "KakaoAK " + Config.getInstance().getProperties("adminKey");

			public static void main(String[] args) {
				try {
					// HttpGet积己
					HttpPost httpPost = new HttpPost("https://kapi.kakao.com/v1/push/send");
					
					//Setup the request header
					httpPost.addHeader("Authorization", adminKey);

					System.out.println("executing request : " + httpPost.getURI());

					// Setup the request parameters
					ArrayList<NameValuePair> postParameters;
					
					postParameters = new ArrayList<NameValuePair>(4);
				    postParameters.add(new BasicNameValuePair("uuids", ""));
				    postParameters.add(new BasicNameValuePair("push_message", ""));
				    
				    httpPost.setEntity(new UrlEncodedFormEntity(postParameters));

					HttpResponse response = httpClient.execute(httpPost);
					HttpEntity entity = response.getEntity();

					System.out.println("---------------------------------------- start ----------------------------------------");
					// 览翠 搬苞
					System.out.println(response.getStatusLine());
					if (entity != null) {
						System.out.println("Response content length: " + entity.getContentLength());
						BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

						String line = "";
						while ((line = rd.readLine()) != null) {
							System.out.println(line);
						}
					}
					httpPost.abort();
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
