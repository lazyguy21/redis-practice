package tobi.ye.redisPractice.redisJavaDemo;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisPool;

/**
 * Created by ye on 15-7-30.
 */
public class JedisPoolSingleton {
    private static JedisPool jedisPool;
    static {
        jedisPool=new JedisPool("127.0.0.1",6379);

//        jedisPool=new JedisPool("192.168.0.127");
    }
    private JedisPoolSingleton(){
    }
    public static JedisPool getInstance() {
        return jedisPool;
    }

}
