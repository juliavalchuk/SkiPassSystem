package ua.com.bukovel.skipass.type;

import ua.com.bukovel.skipass.SkiPassType;

import java.util.Calendar;

/**
 * Created by julia
 */
public class DaysSkiPass extends SkiPass {
    Calendar startTime = null;
    Calendar endTime = null;

    protected final int START_WORK_HOUR = 9;
    protected final int START_WORK_MINUTE = 0;
    protected final int START_WORK_SECOND = 0;

    protected final int HALF_TIME_HOUR = 13;
    protected final int HALF_TIME_MINUTE = 0;
    protected final int HALF_TIME_SECOND = 0;

    protected final int END_WORK_HOUR = 17;
    protected final int END_WORK_MINUTE = 0;
    protected final int END_WORK_SECOND = 0;

    @Override
    public boolean tryEnterLift() {
        if (!isValid()) {
            return false;
        }

        if (endTime == null) {
            activate();
        }
        return true;
    }

    @Override
    public boolean isValid() {
        if(isblocked){
            return false;
        }

        if(endTime == null){
            return true;
        }

        Calendar calendar = Calendar.getInstance();
        if(calendar.compareTo(startTime) >= 0)
        {
            return calendar.compareTo(endTime) <= 0;
        }

        return false;
    }

    @Override
    public void activate() {
        startTime = Calendar.getInstance();
        endTime = (Calendar)startTime.clone();

        endTime.add(Calendar.DAY_OF_YEAR, amount - 1);

        switch (type)
        {
            case SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS:
            case SkiPassType.WEEKEND_HALF_DAY_SKI_PASS:
                activateHalfDay();
            default:
                setStartTimeOfData(startTime);
                setHalfTimeOfData(endTime);
        }

    }

    protected void activateHalfDay()
    {
        Calendar calendar = Calendar.getInstance();
        Calendar halfTime = (Calendar)calendar.clone();

        setHalfTimeOfData(halfTime);

        if(calendar.compareTo(halfTime) >= 0){
            setHalfTimeOfData(startTime);
            setEndTimeOfData(endTime);
        } else{
            setStartTimeOfData(startTime);
            setEndTimeOfData(endTime);
        }
    }

    protected void setStartTimeOfData(Calendar calendar)
    {
        if(calendar == null)
        {
            calendar = Calendar.getInstance();
        }
        calendar.set(Calendar.HOUR_OF_DAY, START_WORK_HOUR);
        calendar.set(Calendar.MINUTE, START_WORK_MINUTE);
        calendar.set(Calendar.SECOND, START_WORK_SECOND);
    }

    protected void setHalfTimeOfData(Calendar calendar)
    {
        if(calendar == null)
        {
            calendar = Calendar.getInstance();
        }
        calendar.set(Calendar.HOUR_OF_DAY, HALF_TIME_HOUR);
        calendar.set(Calendar.MINUTE, HALF_TIME_MINUTE);
        calendar.set(Calendar.SECOND, HALF_TIME_SECOND);
    }

    protected void setEndTimeOfData(Calendar calendar)
    {
        if(calendar == null)
        {
            calendar = Calendar.getInstance();
        }
        calendar.set(Calendar.HOUR_OF_DAY, END_WORK_HOUR);
        calendar.set(Calendar.MINUTE, END_WORK_MINUTE);
        calendar.set(Calendar.SECOND, END_WORK_SECOND);
    }

}
