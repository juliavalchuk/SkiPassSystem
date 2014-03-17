package ua.com.bukovel.skipass.type;

import java.util.Calendar;

/**
 * Created by julia
 */
public class SeasonSkiPass extends DaysSkiPass {
    protected final int SEASON_START_MONTH = 10;
    protected final int SEASON_START_DAY = 15;
    protected final int SEASON_FINISH_MONTH = 3;
    protected final int SEASON_FINISH_DAY = 31;

    @Override
    public void activate()
    {   super.activate();
        if(endTime.get(Calendar.MONTH) > SEASON_FINISH_MONTH){
            startTime.set(endTime.get(Calendar.YEAR), SEASON_START_MONTH, SEASON_START_DAY);
            endTime.set(endTime.get(Calendar.YEAR) + 1, SEASON_FINISH_MONTH, SEASON_FINISH_DAY);
        } else
        {
            startTime.set(endTime.get(Calendar.YEAR) - 1, SEASON_START_MONTH, SEASON_START_DAY);
            endTime.set(endTime.get(Calendar.YEAR), SEASON_FINISH_MONTH, SEASON_FINISH_DAY);
        }
    }
}
