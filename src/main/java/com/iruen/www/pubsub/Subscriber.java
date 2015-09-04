package com.iruen.www.pubsub;

import com.iruen.www.http.apache.HttpClientKakaoSendPushMessage;

import com.iruen.www.http.jdk.OneSignalCreateNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub {

    Logger logger = LoggerFactory.getLogger(Subscriber.class);

    //	private static HttpClientKakaoSendPushMessage sendMessage  = new HttpClientKakaoSendPushMessage();
    private static OneSignalCreateNotification oneSignalCreateNotification = new OneSignalCreateNotification();

    @Override
    public void onMessage(String channel, String message) {
        logger.info("Message received. Channel: " + channel + ", Msg: "
                + message);
//		sendMessage.sendMessage(message);
        oneSignalCreateNotification.createnotificationByJDK(message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {

    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {

    }
}
