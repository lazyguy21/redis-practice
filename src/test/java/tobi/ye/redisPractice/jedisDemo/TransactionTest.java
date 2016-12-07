package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by tobi on 2016/12/7.
 */
public class TransactionTest {
    @Test
    public void testTransaction() throws Exception {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            Transaction transaction = jedis.multi();
            transaction.set("haha0", "yyf0");
            transaction.set("haha1", "yyf1");
            transaction.set("haha2", "yyf2");
            transaction.set("haha3", "yyf3");
            List<Object> results = transaction.exec();
            System.out.println(results);
        }
    }
}
