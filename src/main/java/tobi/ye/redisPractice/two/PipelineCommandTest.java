package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import tobi.ye.redisPractice.redisJavaDemo.JedisPoolSingleton;

import java.util.List;

public class PipelineCommandTest {
    Jedis jedis = JedisPoolSingleton.getInstance().getResource();
    long starttime_withoutpipeline = 0;
    long starttime_withpipeline = 0;
    long endtime_withoutpipeline = 0;
    long endtime_withpipeline = 0;

    public static void main(String[] args) throws InterruptedException {
        PipelineCommandTest test = new PipelineCommandTest();
        test.checkWithoutPipeline();
        Thread.currentThread().sleep(1000);
        test.checkWithPipeline();
        Thread.currentThread().sleep(1000);
        test.getStats();
    }

    private void getStats() {
        System.out.println(" time taken for test without pipeline " +
                (endtime_withoutpipeline - starttime_withoutpipeline));
        System.out.println(" time taken for test with pipeline" +
                (endtime_withpipeline - starttime_withpipeline));
    }

    private void checkWithoutPipeline() {
        starttime_withoutpipeline = System.currentTimeMillis();
        for (int keys = 0; keys < 10; keys++) {
            for (int nv = 0; nv < 100; nv++) {
                jedis.hset("keys-" + keys, "name" + nv, "value" + nv);
            }
            for (int nv = 0; nv < 100; nv++) {
                jedis.hget("keys-" + keys, "name" + nv);
            }
        }
        endtime_withoutpipeline = System.currentTimeMillis();
// this will delete all the data.
        jedis.flushDB();
    }

    private void checkWithPipeline() {
        starttime_withpipeline = System.currentTimeMillis();
        for (int keys = 0; keys < 10; keys++) {
            Pipeline commandpipe = jedis.pipelined();
//            commandpipe.
            for (int nv = 0; nv < 100; nv++) {
                commandpipe.hset("keys-" + keys, "name" + nv, "value" + nv);
            }
            List<Object> results = commandpipe.syncAndReturnAll();
            for (int nv = 0; nv < results.size(); nv++) {
                results.get(nv);
            }
        }
        endtime_withpipeline = System.currentTimeMillis();
        jedis.flushDB();
    }
}