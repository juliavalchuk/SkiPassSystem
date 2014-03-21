package ua.com.bukovel.skipass;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.bukovel.skipass.type.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by julia
 */
public class SkiPassPrototypeTest {
    static SkiPassPrototype prototype;

    @BeforeClass
    public static void beforeClass() {
        prototype = new SkiPassPrototype();
        prototype.addPrototype(SkiPassType.SEASON_SKI_PASS, new SeasonSkiPass());
        prototype.addPrototype(SkiPassType.WEEKDAY_DAYS_SKI_PASS, new WeekdayDaysSkiPass());
        prototype.addPrototype(SkiPassType.WEEKDAY_LIFTS_SKI_PASS, new WeekdayLiftsSkiPass());
    }

    @Test
    public void testCreateSkiPassWithValidType(){
        SkiPass skiPass = prototype.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
        assertNotNull(skiPass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSkiPassWithWrongType(){
        SkiPass skiPass = prototype.createSkiPass(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAndCreateSkiPass(){
        prototype.removePrototype(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
        SkiPass skiPass = prototype.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
    }

    @Test
    public void testAddExistedKey(){
        prototype.addPrototype(SkiPassType.WEEKDAY_DAYS_SKI_PASS, new WeekendDaysSkiPass());
        SkiPass skiPass = prototype.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS);
        assertNotNull(skiPass);
    }

}
