package ua.com.bukovel.skipass.type

import org.junit.*

import static org.junit.Assert.assertEquals


/**
 * Created by julia 
 */
class DaysSkiPassTest {

    @Test
    public void testGetAmountOfDaysWhenSkiPassWasUsing(){
        SkiPass skiPass = new WeekdayDaysSkiPass();
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 5;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }


    @Test
    public void isWorkUnblokedSkiPassEndDatanull()
    {
        SkiPass skiiPass = WeekdayDaysSkiPass();
        boolean expResult = true;

    }
}
