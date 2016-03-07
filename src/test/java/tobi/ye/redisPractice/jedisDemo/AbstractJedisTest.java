package tobi.ye.redisPractice.jedisDemo;

import org.junit.After;
import org.junit.Before;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tobi.ye.redisPractice.redisJavaDemo.JedisPoolSingleton;

/**
 * Created by ye on 15-10-8.
 */
public class AbstractJedisTest {
    static JedisPool jedisPool = JedisPoolSingleton.getInstance();
    Jedis jedis;
    @Before
    public void get(){
        jedis = jedisPool.getResource();
    }
    @After
    public void destroy(){
        jedisPool.returnResourceObject(jedis);
    }
}
