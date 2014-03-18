package ua.com.bukovel.skipass;

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


    @BeforeClass
    public static void beforeClass() {
        skiPassSystem = new SkiPassSystem();
    }

    @Test
    public void testCreateSkiiPassWithOneParametrsAndValidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(1);
        int actResult = skiPass.getAmount();
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testCreateSkiiPassWithTwoParametrsAndValidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(1, 3);
        int actResult = skiPass.getAmount();
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSkiiPassWithTwoParametrsAndInvalidType(){
        SkiPass skiPass = skiPassSystem.createSkiPass(100, 3);
    }

    @Test
    public void testGetSkiPassByValidId(){
        UUID uuid = skiPassSystem.createSkiPass(1, 3).getId();
        SkiPass skiPass = skiPassSystem.getSkiPass(uuid);
        int actResult = skiPass.getAmount();
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class) //really?
    public void testGetSkiPassByInvalidId(){
        SkiPass skiPass = skiPassSystem.getSkiPass(UUID.fromString("1-1-1-1-1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLiftAcceptReportByTypeWrongType(){
        skiPassSystem.getLiftAcceptReportByType(100);
    }

    @Test
    public void testGetLiftAcceptReportByTypeWithoutAnyReport(){
        int actResult = skiPassSystem.getLiftAcceptReportByType(1);
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLiftDeclineReportByTypeWrongType(){
        skiPassSystem.getLiftDeclineReportByType(100);
    }

    @Test
    public void testGetLiftDeclineReportByTypeWithoutAnyReport(){
        int actResult = skiPassSystem.getLiftDeclineReportByType(1);
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

}
