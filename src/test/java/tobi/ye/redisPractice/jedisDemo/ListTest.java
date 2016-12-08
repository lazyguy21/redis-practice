package tobi.ye.redisPractice.jedisDemo;

import com.google.common.primitives.Chars;
import org.junit.Test;
import redis.clients.jedis.BinaryClient;

import java.util.List;

/**
 * Created by tobi on 16-9-2.
 */
public class ListTest extends AbstractJedisTest{
    @Test
    public void lpush(){
        Long counts = jedis.lpush("listKey", "1", "23", "4", "a", "bd");//一次性推多个value，可以保证原子性
        System.out.println(counts);
        List<String> listKey = jedis.lrange("listKey", 0, -1);
        System.out.println(listKey);
    }
    @Test
    public void range() {
        List<String> listKey = jedis.lrange("listKey", 0, 9);//超出范围无所谓
        System.out.println(listKey);
        List<String> result = jedis.lrange("listKey", 0, -1);
        System.out.println(result);
    }

    @Test
    public void lindex() throws Exception {
        String value = jedis.lindex("listKey", 9);//不存在的index,返回null
        System.out.println(value);//null

    }

    @Test
    public void linsert() throws Exception {
        String key = "linsertTest";
        jedis.rpush(key, "hello", "xiao", "ming");
        System.out.println(jedis.lrange(key, 0, -1));
        jedis.linsert(key, BinaryClient.LIST_POSITION.AFTER, "ming", "sb");
        System.out.println(jedis.lrange(key,0,-1));
        jedis.del(key);

    }

    @Test
    public void length() throws Exception {
        String key = "linsertTest";
        jedis.rpush(key, "hello", "xiao", "ming");
        Long llen = jedis.llen(key);
        System.out.println(llen);

    }

    @Test
    public void lrem() throws Exception {
        String key = "lremTK";
        String[] valueList = new String[]{"h", "e", "l", "l", "o"};
        jedis.rpush(key, valueList);
        System.out.println(jedis.lrange(key, 0, -1));
        jedis.lrem(key, -1, "l");
        System.out.println(jedis.lrange(key, 0, -1));
        jedis.del(key);
    }

    @Test
    public void lset() throws Exception {
        String key = "lremTK";
        String[] valueList = new String[]{"h", "e", "l", "l", "o"};
        jedis.rpush(key, valueList);
        jedis.lset(key, 0, "m");
        System.out.println(jedis.lrange(key,0,-1));

    }

    @Test
    public void ltrim() throws Exception {
        String key = "ltrim";
        String[] valueList = new String[]{"h", "e", "l", "l", "o"};
        jedis.rpush(key, valueList);
        jedis.ltrim(key, 0, 3);
        System.out.println(jedis.lrange(key,0,-1));

    }
}
