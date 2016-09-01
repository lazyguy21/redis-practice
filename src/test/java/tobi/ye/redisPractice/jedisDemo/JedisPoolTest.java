package tobi.ye.redisPractice.jedisDemo;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import redis.clients.jedis.JedisPool;

/**
 * Created by tobi on 16-9-1.
 */
public class JedisPoolTest {
    @Test
    public void test() {
        String host = "127.0.0.1";
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(1);
        /**
         * 如果不设置默认一直等待，这样线上如果连接不够造成阻塞很难排查出来，设置个最大等待时间，可以很好的知道性能瓶颈
         * 超时丢异常～
         * JedisConnectionException: Could not get a resource from the pool
         */
//        genericObjectPoolConfig.setMaxWaitMillis(3*1000L);
//        genericObjectPoolConfig.setBlockWhenExhausted(false);
        JedisPool jedisPool = new JedisPool(genericObjectPoolConfig, host);

        Runnable jedisTask = () -> {
            jedisPool.getResource();
            System.out.println("得到jedis之后，不放");
            try {
                TimeUnit.DAYS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(jedisTask);
        thread.start();
        Thread thread2 = new Thread(jedisTask);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("拿到2个连接");

        }
    }
}