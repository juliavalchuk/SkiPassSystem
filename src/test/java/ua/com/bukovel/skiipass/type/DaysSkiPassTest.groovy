package ua.com.bukovel.skiipass.type

import org.junit.*


/**
 * Created by julia 
 */
class DaysSkiPassTest {

    @Test
    public void isWorkBlokedSkiiPass()
    {
        SkiPass skiiPass = WeekdayDaysSkiPass();
        skiiPass.block();
        boolean expResult = false;


    }

    @Test
    public void isWorkUnblokedSkiiPassEndDatanull()
    {
        SkiPass skiiPass = WeekdayDaysSkiPass();
        boolean expResult = true;

    }
}
