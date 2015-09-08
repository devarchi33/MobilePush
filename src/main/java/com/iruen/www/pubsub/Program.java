package com.iruen.www.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import com.iruen.www.helper.JedisHelper;
import com.iruen.www.http.apache.HttpClientKakaoSendPushMessage;

public class Program {

    private static final Logger logger = LoggerFactory.getLogger(Program.class);

    public static final String CHANNEL_NAME = "testchannel";

    public static void main(String[] args) throws Exception {

        final JedisHelper helper = JedisHelper.getInstance();
        final Jedis subscriberJedis = helper.getConnection();
        final Subscriber subscriber = new Subscriber();

        new Thread(new Runnable() {
            public void run() {
                try {
                    logger.info("Subscribing to \"testchannel\". This thread will be blocked.");
                    subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
                    logger.info("Subscription ended.");
                } catch (Exception e) {
                    logger.info("Subscribing failed." + e);
                }
            }
        }).start();

        final Jedis publisherJedis = helper.getConnection();

        new Publisher(publisherJedis, CHANNEL_NAME).start();

        subscriber.unsubscribe();
        helper.returnResource(subscriberJedis);
        helper.returnResource(publisherJedis);
    }
}