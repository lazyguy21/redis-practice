package tobi.ye.redisPractice.jedisDemo;

import org.junit.Test;

import java.util.List;

import redis.clients.jedis.GeoCoordinate;

/**
 * Created by tobi on 16-9-2.
 */
public class GEOTest extends AbstractJedisTest {

    private String vendorPosition = "vendorPosition";
    ;

    @Test
    public void testGEOADD() {
        Long count = jedis.geoadd(vendorPosition, 13.361389, 38.115556, "1111L");

        System.out.println(count);
    }

    @Test
    public void testGEOPOS() {
        List<GeoCoordinate> geopos = jedis.geopos(vendorPosition, "1111L");
        System.out.println(geopos);
    }
    @Test
    public void testGEODIST(){
        Double distance = jedis.geodist(vendorPosition, "mianguan", "1111L");
        System.out.println(distance);
    }

}
