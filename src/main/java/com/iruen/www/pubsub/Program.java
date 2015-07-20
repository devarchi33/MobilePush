package com.iruen.www.pubsub;

import redis.clients.jedis.Jedis;

import com.iruen.www.helper.JedisHelper;

public class Program {

	public static final String CHANNEL_NAME = "commonChannel";

	public static void main(String[] args) throws Exception {

		JedisHelper helper = JedisHelper.getInstance();
		final Jedis subscriberJedis = helper.getConnection();
		final Subscriber subscriber = new Subscriber();

		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("Subscribing to \"commonChannel\". This thread will be blocked.");
					subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
					System.out.println("Subscription ended.");
				} catch (Exception e) {
					System.out.println("Subscribing failed." + e);
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
