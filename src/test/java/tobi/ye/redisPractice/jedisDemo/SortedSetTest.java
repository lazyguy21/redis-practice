package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Created by ye on 15-10-8.
 */
public class SortedSetTest extends AbstractJedisTest {
    @Test
    public void zadd() {
        System.out.println(jedis.zadd("userRank", 0, "yyf0"));
        System.out.println(jedis.zadd("userRank", 1, "yyf1"));
        System.out.println(jedis.zadd("userRank", 2, "yyf2"));
        System.out.println(jedis.zadd("userRank", 3, "yyf3"));
        System.out.println(jedis.zadd("userRank", 4, "yyf4"));


    }
    @Test
    public void zrange(){
        System.out.println(jedis.zrange("userRank",0,-1));
        Set<Tuple> userRank = jedis.zrangeWithScores("userRank", 0, -1);
//        jedis.zrangeByScoreWithScores()
        userRank.forEach(tuple->{
            System.out.println(tuple.getScore());
            System.out.println(tuple.getElement());
        });
        System.out.println(userRank);
    }
}
