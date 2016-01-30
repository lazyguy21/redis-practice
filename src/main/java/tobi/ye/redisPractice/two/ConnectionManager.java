package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ConnectionManager {
    private static JedisPool jedisPool = new JedisPool("localhost");

    public static Jedis get() {
        return jedisPool.getResource();
    }

    public static void set(Jedis jedis) {
        jedisPool.returnResource(jedis);
    }

    public static void close() {
        jedisPool.destroy();
    }
}