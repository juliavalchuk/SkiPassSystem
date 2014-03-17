package ua.com.bukovel.skipass;

/**
 * Created by julia
 */
public class SkiPassType {
    public final static int WEEKDAY_DAYS_SKI_PASS = 0;
    public final static int WEEKEND_DAYS_SKI_PASS = 1;
    public final static int SEASON_SKI_PASS = 2;
    public final static int WEEKDAY_LIFTS_SKI_PASS = 3;
    public final static int WEEKEND_LIFTS_SKI_PASS = 4;
    public final static int WEEKDAY_HALF_DAY_SKI_PASS = 5;
    public final static int WEEKEND_HALF_DAY_SKI_PASS = 6;

    public final static int COUNT = 7;

    public static String toString(int type)
    {
        String sType;
        switch (type)
        {
            case WEEKDAY_DAYS_SKI_PASS:
                sType = "Weekday days ski-pass";
                break;
            case WEEKEND_DAYS_SKI_PASS:
                sType = "Weekend days ski-pass";
                break;
            case SEASON_SKI_PASS:
                sType = "Season ski-pass";
                break;
            case WEEKDAY_LIFTS_SKI_PASS:
                sType = "Weekday lifts ski-pass";
                break;
            case WEEKEND_LIFTS_SKI_PASS:
                sType = "Weekend lifts ski-pass";
                break;
            case WEEKDAY_HALF_DAY_SKI_PASS:
                sType = "Weekday a half day ski-pass";
                break;
            case WEEKEND_HALF_DAY_SKI_PASS:
                sType = "Weekend a half day ski-pass";
                break;
            default:
                throw new IllegalArgumentException("Invalid type of ski-pass. Recommended to use constant from this class");
        }
        return sType;
    }

}
