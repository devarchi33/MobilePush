package com.iruen.www.http.resttemplate;

import com.iruen.www.helper.Config;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by donghoon on 15. 8. 5..
 */
public class KakaoSearchPushToken {

    private RestTemplate restTemplate = new RestTemplate();
    private static String ADMIN_KEY = Config.getInstance().getProperties("adminKey");
    private String uuid = Config.getInstance().getProperties("uuid");

    public boolean searchPushToken() {
        printTitle("searchPushToken");

        try {
            URI uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("kapi.kakao.com")
                    .path("/v1/push/tokens")
                    .queryParam("uuid", uuid)
                    .build()
                    .toUri();
            System.out.println("Request URI : " + uri);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", ADMIN_KEY);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

            ResponseEntity<String> pushTokenResponse = restTemplate.exchange(
                    uri, HttpMethod.GET, requestEntity, String.class);
            System.out.println(pushTokenResponse);

            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void printTitle(String title) {
        System.out.println("\n\n");
        System.out.println("[" + title + "]");
    }
}
