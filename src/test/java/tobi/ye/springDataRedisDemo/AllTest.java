package tobi.ye.springDataRedisDemo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tobi.ye.redisPractice.redisJavaDemo.JedisPoolSingleton;

/**
 * Created by ye on 15-7-30.
 */
public class AllTest {
    private static JedisPool jedisPool;
    private Jedis jedis;

    @BeforeClass
    public static void beforeClass() {
        jedisPool = JedisPoolSingleton.getInstance();
    }
    @Before
    public void getJedis() {
        jedis = jedisPool.getResource();
    }
    @After
    public void returnJedis(){
        jedisPool.returnResourceObject(jedis);
    }
    @Test
    public void test1(){
//        jedis.
    }
}
