package tobi.ye.redisPractice.springDataRedisDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tobi.ye.redisPractice.User;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by ye on 15-10-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring*.xml")
public  class RedisTemplateTest {

    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void test(){
        User user = new User();
        user.setName("123");
        user.setBirth(new Date());
        redisTemplate.opsForValue().set("testUser:1111",user);

        Object myUser2 = redisTemplate.opsForValue().get("testUser:1111");
        System.out.println(myUser2);
//        stringRedisTemplate.opsForValue().set();
    }
    @Test
    public void testMap(){
        User user = new User();
        Object o = JSON.toJSON(user);
        JSONObject o1 = (JSONObject) JSONObject.toJSON(user);
        Map map = new HashMap<>();
        map.putAll(o1);
//        stringRedisTemplate.opsForHash().putAll("nullObject", (Map)o1);
        redisTemplate.opsForHash().putAll("mapUser:11111", o1);
//        redisTemplate.opsForHash().putAll();
    }
}
