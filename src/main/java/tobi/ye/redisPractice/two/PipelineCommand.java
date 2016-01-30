package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Set;

public class PipelineCommand implements Runnable {
    Jedis jedis = ConnectionManager.get();

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        Pipeline commandpipe = jedis.pipelined();
        for (int nv = 0; nv < 300000; nv++) {
            commandpipe.sadd("keys-1", "name" + nv);
        }
        commandpipe.sync();
        Set<String> data = jedis.smembers("keys-1");
        System.out.println("The return value of nv1 after pipeline [ " +
                data.size() + " ]");
        System.out.println("The time taken for executing client(Thread-1) "
                + (System.currentTimeMillis() - start));
        ConnectionManager.set(jedis);
    }
}