package com.iruen.www.http.resttemplate;

import com.iruen.www.helper.Config;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by donghoon on 15. 8. 5..
 */
public class KakaoSendPushMessage {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String ADMIN_KEY = Config.getInstance().getProperties("adminKey");
    private String uuid = Config.getInstance().getProperties("uuid");
    private static final String URI = "https://kapi.kakao.com/v1/push/send";

    public boolean sendPushMessage(String message) {
        printTitle("sendPushMessage");

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", ADMIN_KEY);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            JSONArray uuids = new JSONArray();
            JSONObject custumMessageObj = new JSONObject();
            custumMessageObj.put("message", message);
            JSONObject messageObj = new JSONObject();
            messageObj.put("custom_field", messageObj);
            messageObj.put("return_url", "skyfly33.dothome.co.kr/kakao/kakaologindemo.html");
            JSONObject gcmMessage = new JSONObject();
            gcmMessage.put("for_gcm", messageObj);

            MultiValueMap<String, JSONObject> paramMap = new LinkedMultiValueMap<>();
            paramMap.add("for_gcm", gcmMessage);

            HttpEntity<MultiValueMap<String, JSONObject>> requestEntity = new HttpEntity<>(paramMap, headers);

            ResponseEntity<String> sendMesssageResponse =
                    restTemplate.exchange(URI, HttpMethod.POST, requestEntity, String.class);

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
