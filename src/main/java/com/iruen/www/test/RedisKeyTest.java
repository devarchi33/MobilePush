package com.iruen.www.test;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.iruen.www.helper.JedisHelper;

public class RedisKeyTest {
	static JedisHelper helper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		helper = JedisHelper.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		helper.destroyPool();
	}

	public Set<String> getAllKey(Jedis jedis) {
		Set<String> keys = jedis.keys("*");
		return keys;
	}

	@Test
	public void getAllKeyTest() {
		try {
			// Connecting to Redis server
			Jedis jedis = helper.getConnection();
			System.out.println("Connection to server sucessfully");

			// call redis keys stored
			Set<String> set = getAllKey(jedis);

			Iterator<String> i = set.iterator();
			while (i.hasNext()) {
				System.out.println("Set of stored keys:: " + i.next());
			}
		} catch (JedisConnectionException e) {
			e.printStackTrace();
		}
	}

}