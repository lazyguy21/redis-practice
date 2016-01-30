//package org.learningredis.chapter.two;
//
////import org.apache.commons.pool.impl.GenericObjectPool.Config;
//import redis.clients.jedis.JedisShardInfo;
//import redis.clients.jedis.ShardedJedis;
//import redis.clients.jedis.ShardedJedisPool;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyShards {
//    List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//
//    public static void main(String[] args) {
//        MyShards test = new MyShards();
//        test.setup();
//        test.putdata();
//    }
//
//    private void setup() {
//        JedisShardInfo master0 = new JedisShardInfo("localhost", 6379);
//        JedisShardInfo master1 = new JedisShardInfo("localhost", 6369);
//        shards.add(master0);
//        shards.add(master1);
//    }
//
//    private void putdata() {
//        ShardedJedisPool pool = new ShardedJedisPool(new Config(),
//                shards);
//        for (int index = 0; index < 10; index++) {
//            ShardedJedis jedis = pool.getResource();
//            jedis.set("mykey" + index, "my value is " + index);
//            pool.returnResource(jedis);
//        }
//        for (int index = 0; index < 10; index++) {
//            ShardedJedis jedis = pool.getResource();
//            System.out.println("The value for the key is " + jedis.
//                    get("mykey" + index));
//            System.out.println("The following information is from master running on port:" + jedis.getShardInfo(" mykey "+index).getPort());
//            pool.returnResource(jedis);
//        }
//    }
//}