package com.iruen.www.http.resttemplate;

import com.iruen.www.helper.Config;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by donghoon on 15. 8. 5..
 */
public class KakaoPushTokenRegister {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String ADMIN_KEY = Config.getInstance().getProperties("adminKey");
    private String uuid = Config.getInstance().getProperties("uuid");
    private String device_id = Config.getInstance().getProperties("device_id");
    private String push_type = Config.getInstance().getProperties("push_type");
    private String push_token = Config.getInstance().getProperties("push_token");

    public static void main(String[] args) {
        KakaoPushTokenRegister kr = new KakaoPushTokenRegister();
        boolean check = kr.tokenRegister();

        if (check)
            System.out.println("Register Success");
        else
            System.out.println("Register Fail");
    }

    public boolean tokenRegister() {
        printTitle("Token Register");
        String uri = "https://kapi.kakao.com/v1/push/register";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", ADMIN_KEY);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
            paramMap.add("uuid", uuid);
            paramMap.add("device_id", device_id);
            paramMap.add("push_type", push_type);
            paramMap.add("push_token", push_token);

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramMap, headers);

            ResponseEntity<String> registerResponse = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

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
