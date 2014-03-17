package ua.com.bukovel.skipass.type;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yuliia_Valchuk
 */
public class LiftsSkiPassTest {

    @Test
    public void testGetAmountOfLiftsWhenSkiPassWasUsing(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 3;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetAmountOfLiftsWhenSkiPassWasUsedMoreThanItCould(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
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
    public void testTryEnterLiftOnce(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        int expResult = 4;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testTryEnterLiftAmountTimes(){
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
    public void testTryEnterLiftMoreThanAmountTimes(){
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
    public void testIsValidSkiPassWhenItIsBloked(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.block();
        boolean actResult = skiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenAmountIsZero(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(1);
        skiPass.tryEnterLift();
        boolean actResult = skiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenItIsUnblokedAndAmountMoreThenZero(){
        SkiPass skiPass = new WeekdayLiftsSkiPass();
        skiPass.setAmount(3);
        boolean actResult = skiPass.isValid();
        assertTrue(actResult);
    }
}
