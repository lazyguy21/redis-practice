package tobi.ye.redisPractice.springDataRedisDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tobi.ye.redisPractice.User;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ye on 15-10-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring*.xml")
public  class StringRedisTemplateTest {
    @Resource
    private RedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("myname","fromxxcaonima");
//        stringRedisTemplate.opsForValue().set();
    }
    @Test
    public void testNullValue(){
        Map hashMap = new HashMap();
        hashMap.put("id", "123");
        hashMap.put("name", "");
        hashMap.put("emtyList", Collections.emptyList());
        hashMap.put("date", new Date());
        hashMap.put("isOk", "true");
        User user = new User();
        user.setName("hahah");
        user.setBirth(new Date());
        hashMap.put("user", user);
        stringRedisTemplate.opsForHash().putAll("mapWithNullValue",hashMap);

    }
    @Test
    public void testSaveMapForBean(){
        User user = new User();
        user.setName("hahah");
        user.setBirth(new Date());
        stringRedisTemplate.opsForValue().set("userTest",user);
    }
    @Test
    public void testListMapForBean(){
        Object userTest = stringRedisTemplate.opsForValue().get("userTest");
        System.out.println(userTest);
        JSONObject jsonObject = new JSONObject((Map)userTest);
        User user = JSONObject.toJavaObject(jsonObject, User.class);
        System.out.println(user);
    }
    @Test
    public void testSaveNull(){
        stringRedisTemplate.opsForValue().set("nullKey",null);
        stringRedisTemplate.opsForValue().set("emptyKey","");
        stringRedisTemplate.opsForValue().set("nullObject",new User());
        Object nullKey = stringRedisTemplate.opsForValue().get("nullKey");
        Object emptyKey = stringRedisTemplate.opsForValue().get("emptyKey");
        Object nullObject = stringRedisTemplate.opsForValue().get("nullObject");
        User user = (User)stringRedisTemplate.opsForValue().get("nullObject");


    }
    @Test
    public void testSaveHashBean(){
        User user = new User();
        Object o = JSON.toJSON(user);
        JSONObject o1 = (JSONObject) JSONObject.toJSON(user);
        Map map = new HashMap<>();
        map.putAll(o1);
//        stringRedisTemplate.opsForHash().putAll("nullObject", (Map)o1);
        stringRedisTemplate.opsForHash().putAll("nullMap", map);

        Object nullObject = stringRedisTemplate.opsForHash().entries("nullMap");

        System.out.println(nullObject);
        JSONObject jsonObject = new JSONObject((Map)nullObject);
        User userR = JSONObject.toJavaObject(jsonObject, User.class);
        System.out.println(userR);


    }
    @Test
    public void testEmptyValue(){
        List<Object> mapWithNullValue = stringRedisTemplate.opsForHash().values("mapWithNullValue");
        System.out.println(mapWithNullValue);
        Map<Object, Object> mapWithNullValue1 = stringRedisTemplate.opsForHash().entries("mapWithNullValue");
        System.out.println(mapWithNullValue1);
//        stringRedisTemplate.opsForHash().
    }
    @Test
    public void testSexEx(){
        //登录失败，记录+1
        stringRedisTemplate.opsForValue().increment("PCLoginFailTimes:" + 111, 1L);
        //每次
        stringRedisTemplate.expire("PCLoginFailTimes:" + 111, 1L, TimeUnit.DAYS);
//        redisTemplate.opsForValue().set();
    }
    @Test
    public void testNotExistKey(){
        Object o = stringRedisTemplate.opsForValue().get("PCLoginFailTimes:" + 111);
        System.out.println(o);
        Object o2 = stringRedisTemplate.opsForValue().get("PCLoginFailTimes:" + 222);
        System.out.println(o2);//null

    }
}
