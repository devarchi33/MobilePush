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

public class HttpClientGet {
	// HttpClient 积己
	static HttpClient httpClient = HttpClientBuilder.create().build();

	public static void main(String[] args) {
		try {
			// HttpGet积己
			HttpGet httpget = new HttpGet("http://forum.falinux.com");

			System.out.println("executing request : " + httpget.getURI());
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();

			System.out.println("start ----------------------------------------");
			// 览翠 搬苞
			System.out.println(response.getStatusLine());
			if (entity != null) {
				System.out.println("Response content length: "+ entity.getContentLength());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

				String line = "";
				while ((line = rd.readLine()) != null) {
					System.out.println(line);
				}
			}
			httpget.abort();
			System.out.println("---------------------------------------- end");
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