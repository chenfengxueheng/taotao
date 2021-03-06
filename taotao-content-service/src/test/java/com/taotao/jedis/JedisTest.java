package com.taotao.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class JedisTest {

	@Test
	 public void testJedis(){  
		 Jedis jedis=new Jedis("192.168.202.99", 7001);
		//直接操作数据库  
        jedis.set("jedis-key", "hello jedis!");  
        //获取数据  
        String result = jedis.get("jedis-key");  
        System.out.println(result);  
        //关闭jedis  
        jedis.close();  
	 }
	@Test
	 public void testJedisCluster(){  
	        //创建构造参数Set类型，集合中每个元素是HostAndPort类型  
	        Set<HostAndPort> nodes = new HashSet<>();  
	        //向集合中添加节点  
	        nodes.add(new HostAndPort("192.168.202.99", 7001));  
	        nodes.add(new HostAndPort("192.168.202.99", 7002));  
	        nodes.add(new HostAndPort("192.168.202.99", 7003));  
	        nodes.add(new HostAndPort("192.168.202.99", 7004));  
	        nodes.add(new HostAndPort("192.168.202.99", 7005));  
	        nodes.add(new HostAndPort("192.168.202.99", 7006));  
	        //创建JedisCluster对象  
	        JedisCluster jedisCluster = new JedisCluster(nodes);  
	        //直接使用jedisCluster，自带连接池，jedisCluster可以是单例的  
	        jedisCluster.set("jedis-cluster", "hello jedis cluster");  
	        String result = jedisCluster.get("jedis-cluster");  
	        System.out.println(result);  
	        //系统关闭前关闭jedisCluster  
	        jedisCluster.close();  
	    }  
}
