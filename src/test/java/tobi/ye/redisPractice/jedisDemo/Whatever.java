package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;

/**
 * Created by ye on 15-10-8.
 */
public class Whatever extends AbstractJedisTest {

    @Test
    public void set() throws InterruptedException {
        System.out.println(jedis.set("name", "yyf", "nx"));
        System.out.println(jedis.get("name"));
        System.out.println(jedis.set("namea","yyftest","nx"));
        System.out.println(jedis.get("namea"));

        System.out.println(jedis.set("namea","yyftestxx","xx","ex",5));
        System.out.println(jedis.get("namea"));
        Thread.sleep(5000L);
        System.out.println(jedis.get("namea"));
    }

    @Test
    public void mset() {
        System.out.println(jedis.mset("gg1", "1", "gg2", "adf"));
        System.out.println(jedis.get(("gg1")));
        System.out.println(jedis.get(("gg2")));
        //原子性
        System.out.println(jedis.msetnx("gg1", "2", "gg3", "aaaa", "gg2", "123123"));
        System.out.println(jedis.mget("gg1", "gg2", "gg3"));
    }
}
