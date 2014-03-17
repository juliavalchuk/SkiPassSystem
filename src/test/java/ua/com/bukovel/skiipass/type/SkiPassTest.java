package ua.com.bukovel.skiipass.type;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by julia
 */
public class SkiPassTest {

    @Test
    public void testGetId(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        int expResult = 123;
        int actResult = 0;
        assertEquals(expResult, actResult);
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
    public void testGetAmountOfLiftsWhenSkiiPassWasUsing(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 3;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetAmountOfDaysWhenSkiiPassWasUsing(){
        SkiPass skiPass = new WeekdayDaysSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 5;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetShiftOfDay(){
    }

    @Test
    public void testOneLiftLiftsSkiiPass(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        int expResult = 4;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testAllLiftLiftsSkiiPass(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 0;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testAllAndOneLiftLiftsSkiiPass(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        boolean actResult = skiPass.tryEnterLift();
        assertFalse(actResult);
    }

    @Test
    public void testIsWorkLiftsSkiiPassWhenItIsBloked(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.block();
        boolean actResult = skiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsWorkLiftsSkiiPassWhenAmountZero(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(0);
        boolean actResult = skiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsWorkLiftsSkiiPassWhenItIsUnblokedAndAmountMoreThenZero(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(3);
        boolean actResult = skiPass.isValid();
        assertTrue(actResult);
    }
}
