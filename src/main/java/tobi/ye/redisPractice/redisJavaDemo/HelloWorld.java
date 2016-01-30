package tobi.ye.redisPractice.redisJavaDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HelloWorld {
    private JedisPool pool = new JedisPool(new JedisPoolConfig(),
            "localhost");

    public static void main(String args[]) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.test();
    }

    private void test() {
        try {
            Jedis jedis = pool.getResource();
            jedis.set("MSG", "Hello World");
            String result = jedis.get("MSG");
            System.out.println(" MSG : " + result);
            pool.returnResource(jedis);
        } catch (Exception e) {
            System.err.println(e.toString());
        } finally {
            pool.destroy();
        }
    }
}