package com.iruen.www.http.jdk;

import com.iruen.www.helper.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by donghoon on 15. 9. 3..
 */
@Component
public class OneSignalCreateNotification {

    Logger logger = LoggerFactory.getLogger(OneSignalCreateNotification.class);


    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/notifications";

    public void createnotificationByJDK(String message) {
        String contents = "{ " +
                "\"app_id\"            : \"" + one_signal_app_id + "\", " +
                "\"contents\"            : {\"en\" : \"" + message + "\"}, " +
                "\"included_segments\" : [ \"Test\" ] " +
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

            conn.setRequestProperty("Authorization", "Basic MDYxZTBiNmMtNGViYi0xMWU1LTllOTUtMWI4YTZiNGQzMmMw");


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
