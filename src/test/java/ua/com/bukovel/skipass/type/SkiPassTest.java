package ua.com.bukovel.skipass.type;

import org.junit.Test;
import ua.com.bukovel.skipass.SkiPassType;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by julia
 */
public class SkiPassTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSetSkiPassParametrsTwise(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setStartsParameters(UUID.randomUUID(), SkiPassType.WEEKDAY_LIFTS_SKI_PASS);
        skiPass.setStartsParameters(UUID.randomUUID(), SkiPassType.WEEKDAY_LIFTS_SKI_PASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSkiPassParametrsWithIncorectType(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setStartsParameters(UUID.randomUUID(), null);
    }

    @Test
    public void testGetId(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setStartsParameters(UUID.fromString("1-1-1-1-1"), SkiPassType.WEEKDAY_LIFTS_SKI_PASS);
        UUID expResult = skiPass.getId();
        UUID actResult = UUID.fromString("1-1-1-1-1");
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetIdWithoutSetId(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        UUID expResult = skiPass.getId();
        UUID actResult = null;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIllegalAmount(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIllegalAmountForHalfDay(){
        SkiPass skiPass = new WeekdayDaysSkiPass();
        skiPass.setStartsParameters(UUID.randomUUID(), SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS);
        skiPass.setAmount(5);
    }

    @Test
    public void testGetAmount(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        int expResult = 5;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetType(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setStartsParameters(UUID.fromString("1-1-1-1-1"), SkiPassType.WEEKDAY_LIFTS_SKI_PASS);
        SkiPassType expResult = skiPass.getType();
        SkiPassType actResult = SkiPassType.WEEKDAY_LIFTS_SKI_PASS;
        assertEquals(expResult, actResult);
    }

}
