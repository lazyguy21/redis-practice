package tobi.ye.redisPractice.redisJavaDemo;

import redis.clients.jedis.JedisPool;

/**
 * Created by ye on 15-7-30.
 */
public class JedisPoolSingleton {
    private static JedisPool jedisPool;
    static {
        jedisPool=new JedisPool("127.0.0.1");
    }
    private JedisPoolSingleton(){
    }
    public static JedisPool getInstance() {
        return jedisPool;
    }

}
