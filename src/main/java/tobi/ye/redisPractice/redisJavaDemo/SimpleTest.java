package tobi.ye.redisPractice.redisJavaDemo;

import redis.clients.jedis.Jedis;

/**
 * Created by ye on 15-7-29.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        String keys = "name";

        // 删数据
        jedis.del(keys);
        // 存数据
        jedis.set(keys, "snowolf");
        // 取数据
        String value = jedis.get(keys);

        System.out.println(value);
    }
}
