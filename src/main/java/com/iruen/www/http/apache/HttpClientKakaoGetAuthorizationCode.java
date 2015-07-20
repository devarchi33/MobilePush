package com.iruen.www.http.apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.iruen.www.helper.Config;

public class HttpClientKakaoGetAuthorizationCode {

	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static String restkey = Config.getInstance().getProperties("restkey");
	private static String redirect_uri = Config.getInstance().getProperties("redirect_uri");

	public static void main(String[] args) {
		getAuthorizationCode();
	}

	//step1
	public static String getAuthorizationCode() {
		String code = "";

		try {
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https");
			builder.setHost("kauth.kakao.com");
			builder.setPath("/oauth/authorize");
			builder.setParameter("restkey", restkey);
			builder.setParameter("redirect_uri", redirect_uri);
			builder.setParameter("response_type", "code");

			HttpGet httpGet = new HttpGet(builder.build());
			System.out.println("excutiing request : " + httpGet.getURI());

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();

			System.out.println("---------------------------------------- start ----------------------------------------");
			// ���� ���
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
			System.out.println("---------------------------------------- end ----------------------------------------");

		} catch (URISyntaxException e) {

		} catch (IOException e) {

		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return code;
	}

}
