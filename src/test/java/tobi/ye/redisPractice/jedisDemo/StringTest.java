package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;

/**
 * Created by lazyguy on 2016-1-30.
 */
public class StringTest extends AbstractJedisTest {
    @Test
    public void testSet(){
//         对不存在的键进行设置
//        String returnResult = jedis.set("mykey", "the value_of mykey");
//        System.out.println(returnResult);//居然返回的是“OK"

//        对已存在的键进行设置
//        那么其实redis要更新一个键的时候就是直接再set就好了
//        String returnResult2 = jedis.set("mykey", "the value_of mykey");
//        System.out.println(returnResult2);

//      用EX 设置 过期时间 秒
//        redis.clients.jedis.exceptions.JedisDataException: value sent to redis cannot be null
//        传参还不能为null，切
//        String returnResult3 = jedis.set("mykey", "the value_of mykey","nxxx","ex",10);


    }
    @Test
    public void testAppend(){
        int numActive = jedisPool.getNumActive();
        System.out.println(numActive);
        int numIdle = jedisPool.getNumIdle();
        System.out.println(numIdle);
        int numWaiters = jedisPool.getNumWaiters();
        System.out.println(numWaiters);
//        jedis.append("mykey", "appendValue");
    }

}
