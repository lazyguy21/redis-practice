package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisWrapper {
    static JedisPool pool = new JedisPool(new JedisPoolConfig(),
            "localhost");
    public void set(String key, String value) {
        Jedis jedis = pool.getResource();
        jedis.set(key, value);
        pool.returnResource(jedis);
    }

    public String get(String key) {
        Jedis jedis = pool.getResource();
        String result = jedis.get("MSG");
        pool.returnResource(jedis);
        return result;
    }
}