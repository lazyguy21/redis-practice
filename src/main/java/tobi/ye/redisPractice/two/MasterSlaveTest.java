package tobi.ye.redisPractice.two;

import redis.clients.jedis.Jedis;

public class MasterSlaveTest {
    public static void main(String[] args) throws
            InterruptedException {
        MasterSlaveTest test = new MasterSlaveTest();
        test.masterslave();
    }

    private void masterslave() throws InterruptedException {
        Jedis master = new Jedis("localhost", 6379);
        Jedis slave = new Jedis("localhost", 6380);
        master.append("msg", "Learning Redis");
        System.out.println("Getting message from master: " +
                master.get("msg"));
        System.out.println("Getting message from slave : " +
                slave.get("msg"));
        master.shutdown();
        slave.slaveofNoOne();
        slave.append("msg", " slave becomes the master");
        System.out.println("Getting message from slave turned master:" + slave.get(" msg "));
        Thread.currentThread().sleep(20000);
        master = new Jedis("localhost", 6379);
        master.slaveof("localhost", 6380);
        Thread.currentThread().sleep(20000);
        System.out.println("Getting message from master turned slave:" + master.get(" msg "));
        master.append("msg", "throw some exceptions !!");
    }
}