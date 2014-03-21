package ua.com.bukovel.skipass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by julia
 */
public class SkiPassTypeTest {

    @Test
    public void testToString() throws Exception {
        SkiPassType type = SkiPassType.SEASON_SKI_PASS;
        String actResult = type.toString();
        String expResult = "Season ski-pass";
        assertEquals(expResult, actResult);
    }
}
