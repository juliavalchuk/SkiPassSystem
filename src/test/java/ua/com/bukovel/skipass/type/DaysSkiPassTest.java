package ua.com.bukovel.skipass.type;

import org.junit.Test;
import ua.com.bukovel.skipass.SkiPassType;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by julia
 */
public class DaysSkiPassTest {

    @Test
    public void testGetAmountOfDaysWhenSkiPassWasUsing(){
        SkiPass skiPass = new WeekdayDaysSkiPass();
        skiPass.setStartsParameters(UUID.randomUUID(), SkiPassType.WEEKDAY_DAYS_SKI_PASS);
        skiPass.setAmount(5);
        skiPass.tryEnterLift();
        skiPass.tryEnterLift();
        int expResult = 5;
        int actResult = skiPass.getAmount();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testIsValidSkiPassWhenItIsBloked()
    {
        SkiPass skiiPass = new WeekdayDaysSkiPass();
        skiiPass.block();
        boolean actResult = skiiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenItIsUnblokedAndDateIsNull()
    {
        SkiPass skiiPass = new WeekdayDaysSkiPass();
        boolean actResult = skiiPass.isValid();
        assertTrue(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenDateIsCorrect() // correct - ?
    {
        SkiPass skiiPass = new WorksDaysSkiPassMock();
        skiiPass.activate();
        boolean actResult = skiiPass.isValid();
        assertTrue(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenDateIsPast()
    {
        SkiPass skiiPass = new PastDaysSkiPassMock();
        skiiPass.activate();
        boolean actResult = skiiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testIsValidSkiPassWhenDateIsFuture()
    {
        SkiPass skiiPass = new FutureDaysSkiPassMock();
        skiiPass.activate();
        boolean actResult = skiiPass.isValid();
        assertFalse(actResult);
    }

    @Test
    public void testTryEnterLiftWhenIsValidFalse()
    {
        SkiPass skiiPassMock = mock(WeekdayDaysSkiPass.class);
        when(skiiPassMock.isValid()).thenReturn(false);
        boolean actResult = skiiPassMock.tryEnterLift();
        assertFalse(actResult);
    }

    @Test
    public void testTryEnterLiftWithNullDate()
    {
        SkiPass skiiPassMock = new WorksDaysSkiPassMock();
        boolean actResult = skiiPassMock.tryEnterLift();
        assertTrue(actResult);
    }

    class WorksDaysSkiPassMock extends DaysSkiPass{
        @Override
        public void activate() {
            startTime = Calendar.getInstance();
            endTime = (Calendar)startTime.clone();

            startTime.set(Calendar.DAY_OF_YEAR,startTime.get(Calendar.DAY_OF_YEAR) - 1);
            endTime.set(Calendar.DAY_OF_YEAR, endTime.get(Calendar.DAY_OF_YEAR) + 1);

        }
    }

    class PastDaysSkiPassMock extends DaysSkiPass{
        @Override
        public void activate() {
            startTime = Calendar.getInstance();
            endTime = (Calendar)startTime.clone();

            startTime.set(Calendar.DAY_OF_YEAR,startTime.get(Calendar.DAY_OF_YEAR) - 3);
            endTime.set(Calendar.DAY_OF_YEAR, endTime.get(Calendar.DAY_OF_YEAR) - 1);

        }
    }

    class FutureDaysSkiPassMock extends DaysSkiPass{
        @Override
        public void activate() {
            startTime = Calendar.getInstance();
            endTime = (Calendar)startTime.clone();

            startTime.set(Calendar.DAY_OF_YEAR,startTime.get(Calendar.DAY_OF_YEAR) + 1);
            endTime.set(Calendar.DAY_OF_YEAR, endTime.get(Calendar.DAY_OF_YEAR) + 3);

        }
    }
}
