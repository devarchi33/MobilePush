package com.iruen.www.http.resttemplate;

import com.iruen.www.http.apache.HttpClientKakaoSendPushMessage;

/**
 * Created by donghoon on 15. 8. 5..
 */
public class KakaoExcuteMain {

    public static void main(String[] args) {
        KakaoPushTokenRegister kr = new KakaoPushTokenRegister();
        KakaoSearchPushToken ks = new KakaoSearchPushToken();
//        KakaoSendPushMessage km = new KakaoSendPushMessage();
        HttpClientKakaoSendPushMessage km = new HttpClientKakaoSendPushMessage();
//        km.sendPushMessage("sample message");
        kr.tokenRegister();
        ks.searchPushToken();
        km.sendMessage("sample message");
    }
}
