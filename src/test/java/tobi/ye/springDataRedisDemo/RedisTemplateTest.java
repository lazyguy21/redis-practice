package tobi.ye.springDataRedisDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by ye on 15-10-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring*.xml")
public class RedisTemplateTest{
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("myname","fromxxcaonima");
    }
}
