package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;

import java.util.Date;
import java.util.Set;

/**
 * Created by tobi on 16-9-12.
 */
public class KeyTest extends AbstractJedisTest {
    @Test
    public void keys() {
        Set<String> keys = jedis.keys("user*");
        System.out.println(keys);
    }

    @Test
    public void del() {
        Long nonExists = jedis.del("nonExists");
        System.out.println(nonExists);//返回的是删除的数量，没有即为1
        Long del = jedis.del("user:yyf");
        System.out.println(del);
    }

    @Test
    public void exists() {
        Boolean haha = jedis.exists("haha");
        String set = jedis.set("user:exists", "asdf");
        Boolean exists = jedis.exists("user:exists");
        System.out.println(haha);
        System.out.println(set);
        System.out.println(exists);
    }
    @Test
    public void expireAt(){
        String expireAtKey = "expireAtKey";
        String set = jedis.set(expireAtKey, "hahah");
        Long aLong = jedis.expireAt(expireAtKey, new Date().getTime() +100);//本身是秒的单位
        System.out.println(aLong);
    }
    @Test
    public void renamenx(){
        Long counts = jedis.renamenx("newKey", "newKey");
        System.out.println(counts);
    }
}
