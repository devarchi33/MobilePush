package com.iruen.www.http.resttemplate;

/**
 * Created by donghoon on 15. 8. 5..
 */
public class KakaoExcuteMain {

    public static void main(String[] args) {
        KakaoPushTokenRegister kr = new KakaoPushTokenRegister();
        KakaoSearchPushToken ks = new KakaoSearchPushToken();

        boolean check = ks.searchPushToken();

        if (check)
            System.out.println("Search Success");
        else
            System.out.println("Search Fail");
    }
}
