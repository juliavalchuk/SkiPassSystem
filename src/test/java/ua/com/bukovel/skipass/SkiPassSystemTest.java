package ua.com.bukovel.skipass;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import ua.com.bukovel.skipass.type.DaysSkiPass;
import ua.com.bukovel.skipass.type.LiftsSkiPass;
import ua.com.bukovel.skipass.type.SkiPass;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Yuliia_Valchuk
 */
public class SkiPassSystemTest {

    @Mock
    SkiPass mockDaysSkiPass;
    @Mock
    SkiPass mockLiftsSkiPass;
    @Mock
    SkiPassSystem mockSystem;

    SkiPassSystem skiPassSystem;

    @BeforeClass
    public void setUp() throws Exception {
        mockDaysSkiPass = mock(DaysSkiPass.class);
        mockLiftsSkiPass = mock(LiftsSkiPass.class);
        mockSystem = mock(SkiPassSystem.class);

        skiPassSystem = new SkiPassSystem();
    }

    // usual testing

    @Test
    public void createSkiiPassWithOneParametrsAndTrueType(){
          SkiPass skiPass = skiPassSystem.createSkiPass(1);
        int actResult = skiPass.getType();
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    // mock testing



}
