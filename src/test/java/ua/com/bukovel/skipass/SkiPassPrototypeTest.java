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
        prototype.addPrototype(1, new SeasonSkiPass());
        prototype.addPrototype(2, new WeekdayDaysSkiPass());
        prototype.addPrototype(6, new WeekdayLiftsSkiPass());
    }

    @Test
    public void testCreateSkiPassWithValidType(){
        SkiPass skiPass = prototype.createSkiPass(1);
        assertNotNull(skiPass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSkiPassWithWrongType(){
        SkiPass skiPass = prototype.createSkiPass(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAndCreateSkiPass(){
        prototype.removePrototype(2);
        SkiPass skiPass = prototype.createSkiPass(2);
    }

    @Test(expected = IllegalArgumentException.class) //??
    public void testAddExistedKey(){
        prototype.addPrototype(1, new WeekendDaysSkiPass());
    }

}
