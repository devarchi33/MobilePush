package com.iruen.www.http.jdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iruen.www.helper.Config;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donghoon on 15. 9. 3..
 */
@Component
public class OneSignalCreateNotification {

    Logger logger = LoggerFactory.getLogger(OneSignalCreateNotification.class);


    private String one_signal_rest_api_key = Config.getInstance().getProperties("one_signal_rest_api_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/notifications";

    public void createnotificationByJDK() {
        String contents = "{ " +
                "\"app_id\"            : \"" + one_signal_app_id + "\", " +
                "\"contents\"            : {\"en\" : \"test message by JDK\"}, " +
                "\"included_segments\" : [ \"All\" ] " +
                "}";

        String method = "POST";
        String contentType = "application/json";

        try {
            URL u = new URL(URI);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", contentType);
            conn.setRequestProperty("Content-Length", "" + contents.length());
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestProperty("Authorization", "Basic " + "MDYxZTBiNmMtNGViYi0xMWU1LTllOTUtMWI4YTZiNGQzMmMw");


            OutputStream os = conn.getOutputStream();
            DataOutputStream wr = new DataOutputStream(os);
            wr.writeBytes(contents);
            wr.flush();
            wr.close();


            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
