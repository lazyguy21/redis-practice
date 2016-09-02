package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;

/**
 * Created by tobi on 16-9-2.
 */
public class ListTest extends AbstractJedisTest{
    @Test
    public void lpush(){
        Long counts = jedis.lpush("listKey", "1", "23", "4", "a", "bd");
        System.out.println(counts);
    }
}
