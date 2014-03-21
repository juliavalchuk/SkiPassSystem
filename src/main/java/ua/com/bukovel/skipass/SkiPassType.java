package ua.com.bukovel.skipass;

/**
 * Created by julia
 */
public enum SkiPassType {
    WEEKDAY_DAYS_SKI_PASS("Weekday days ski-pass"),
    WEEKEND_DAYS_SKI_PASS("Weekend days ski-pass"),
    SEASON_SKI_PASS("Season ski-pass"),
    WEEKDAY_LIFTS_SKI_PASS("Weekday lifts ski-pass"),
    WEEKEND_LIFTS_SKI_PASS("Weekend lifts ski-pass"),
    WEEKDAY_HALF_DAY_SKI_PASS("Weekday a half day ski-pass"),
    WEEKEND_HALF_DAY_SKI_PASS("Weekend a half day ski-pass");

    private final String stringType;
    public static int COUNT = 7;

    private SkiPassType(String string){
        stringType = string;
    }

    @Override
    public String toString(){
        return stringType;
    }
}
