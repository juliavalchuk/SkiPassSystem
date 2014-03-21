package ua.com.bukovel.skipass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import ua.com.bukovel.skipass.type.DaysSkiPass;
import ua.com.bukovel.skipass.type.LiftsSkiPass;
import ua.com.bukovel.skipass.type.SkiPass;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yuliia_Valchuk
 */
public class SkiPassSystemTest {
    static SkiPassSystem skiPassSystem;


    @Before
    public void beforeClass() {
        skiPassSystem = new SkiPassSystem();
    }

    @Test
    public void testCreateSkiiPassWithOneParametrsAndValidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
        int actResult = skiPass.getAmount();
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testCreateSkiiPassWithTwoParametrsAndValidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS, 3);
        int actResult = skiPass.getAmount();
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSkiiPassWithTwoParametrsAndInvalidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(null, 3);
    }

    @Test
    public void testGetSkiPassByValidId(){
        UUID uuid = skiPassSystem.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS, 3).getId();
        SkiPass skiPass = skiPassSystem.getSkiPass(uuid);
        int actResult = skiPass.getAmount();
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSkiPassByInvalidId(){
        SkiPass skiPass = skiPassSystem.getSkiPass(UUID.fromString("1-1-1-1-1"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLiftAcceptReportByTypeWrongType(){
        skiPassSystem.getLiftAcceptReportByType(100);
    }

    @Test
    public void testGetLiftAcceptReportByTypeWithoutAnyReport(){
        int actResult = skiPassSystem.getLiftAcceptReportByType(1);
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetLiftAcceptReportByTypeWithSomeReport(){
        skiPassSystem.reportLiftAccept(1);
        int actResult = skiPassSystem.getLiftAcceptReportByType(1);
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetLiftAcceptReportTotal(){
        skiPassSystem.reportLiftAccept(1);
        skiPassSystem.reportLiftAccept(3);
        int actResult = skiPassSystem.getLiftAcceptReportTotal();
        int expResult = 2;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLiftDeclineReportByTypeWrongType(){
        skiPassSystem.getLiftDeclineReportByType(100);
    }

    @Test
    public void testGetLiftDeclineReportByTypeWithoutAnyReport(){
        int actResult = skiPassSystem.getLiftDeclineReportByType(1);
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetLiftDeclineReportByTypeWithSomeReport(){
        skiPassSystem.reportLiftDecline(1);
        int actResult = skiPassSystem.getLiftDeclineReportByType(1);
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testGetLiftDeclineReportTotal(){
        skiPassSystem.reportLiftDecline(1);
        skiPassSystem.reportLiftDecline(3);
        skiPassSystem.reportLiftDecline(3);
        int actResult = skiPassSystem.getLiftDeclineReportTotal();
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

}
