package tobi.ye.redisPractice.jedisDemo.distributed.cluster;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tobi on 2016/12/1.
 */
public class ClusterTest {

    private JedisCluster jedisCluster;

    @Before
    public void setUp() throws Exception {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
//Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6382));
        jedisCluster = new JedisCluster(jedisClusterNodes);
    }

    @Test
    public void test() throws Exception {
//        jedisCluster.set("foo", "bar");
        String value = jedisCluster.get("foo");
        System.out.println(value);
    }

    @Test
    public void testClusterNodes() throws Exception {



    }
}
