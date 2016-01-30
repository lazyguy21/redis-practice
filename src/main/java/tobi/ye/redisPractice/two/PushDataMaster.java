package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PushDataMaster {
    public static void main(String[] args) {
        PushDataMaster test = new PushDataMaster();
        test.pushData();
    }

    private void pushData() {
        Jedis jedis = new Jedis("localhost", 6379);
        Pipeline pipeline = jedis.pipelined();
        for (int nv = 0; nv < 900000; nv++) {
            pipeline.sadd("MSG2", ",data-" + nv);
        }
        pipeline.sync();
    }
}