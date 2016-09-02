package tobi.ye.redisPractice.jedisDemo;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

/**
 * Created by ye on 15-10-8.
 */
public class HashTest extends AbstractJedisTest {
    @Test
    public void hset() {
        System.out.println(jedis.hset("user:yyf","name","yeyinfei"));
        System.out.println(jedis.hget("user.yyf", "name"));
        System.out.println(jedis.hget("user.yyf", "noexistkey"));
        System.out.println(jedis.hget("user.yyfno", "noexistkey"));

        System.out.println(jedis.hmset("user:yyf2",
                (Map)ImmutableMap.builder().put("name","yeyinfei2").put("age","14").build()));
        Map<String, String> map = jedis.hgetAll("user:yyf2");
        System.out.println(map);
    }
    @Test
    public void hdel(){
        Long counts = jedis.hdel("user:yyf", "name", "yeyinfei");
        System.out.println(counts);
    }
    @Test
    public void hexists(){
        Boolean exists = jedis.hexists("user:yyf", "name");
        System.out.println(exists);
    }
    @Test
    public void hgetall(){
        Map<String, String> yyfUser = jedis.hgetAll("user:yyf");
        System.out.println(yyfUser);
    }
}
