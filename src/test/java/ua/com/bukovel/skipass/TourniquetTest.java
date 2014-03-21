package ua.com.bukovel.skipass;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import ua.com.bukovel.skipass.type.DaysSkiPass;
import ua.com.bukovel.skipass.type.SkiPass;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Yuliia_Valchuk
 */
public class TourniquetTest {     // Mock testing

    @Mock
    static SkiPass mockDaysSkiPass;
    @Mock
    static SkiPassSystem mockSystem;

    static Tourniquet tourniquet;

    @BeforeClass
    public static void beforeClass() {
        mockDaysSkiPass = mock(DaysSkiPass.class);
        mockSystem = mock(SkiPassSystem.class);

        tourniquet = new Tourniquet(mockSystem);

        when(mockSystem.getSkiPass(UUID.fromString("1-1-1-1-1"))).thenReturn(mockDaysSkiPass);
        when(mockSystem.getSkiPass(UUID.fromString("2-2-2-2-2"))).thenReturn(mockDaysSkiPass);
        when(mockDaysSkiPass.getType()).thenReturn(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
    }

    @Test
    public void testCheckCorrectIDAndValidSkiPass(){
        when(mockDaysSkiPass.tryEnterLift()).thenReturn(true);
        boolean actResult = tourniquet.check(UUID.fromString("1-1-1-1-1"));
        assertTrue(actResult);
    }

    @Test
    public void testCheckCorrectIDAndInvalidSkiPass(){
        when(mockDaysSkiPass.tryEnterLift()).thenReturn(false);
        boolean actResult = tourniquet.check(UUID.fromString("1-1-1-1-1"));
        assertFalse(actResult);
    }

    @Test
    public void testCheckUncorrectID(){
        when(mockSystem.getSkiPass(UUID.fromString("1-1-1-1-2"))).thenThrow(new IllegalArgumentException(""));
        boolean actResult = tourniquet.check(UUID.fromString("1-1-1-1-2"));
        assertFalse(actResult);
    }
}
