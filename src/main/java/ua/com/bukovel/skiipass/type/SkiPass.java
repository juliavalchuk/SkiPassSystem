package ua.com.bukovel.skiipass.type;

import ua.com.bukovel.skiipass.SkiPassType;

/**
 * Created by julia
 */
public abstract class SkiPass implements Cloneable {
    protected String id; // uniq id
    protected int amount; // days or lifts
    protected int type; // kind of skii-pass
    protected boolean isblocked;

    public void setStartsParametrs(String uuid, int type){
        if(id != null && id.isEmpty()){
            throw new IllegalArgumentException("Ski-pass has already had id");
        }
        id = uuid;
        if(type >= SkiPassType.COUNT){
            throw new IllegalArgumentException(String.format("Type must be less than %i",
                    SkiPassType.COUNT));
        }
        this.type = type;


    }

    public String getId()
    {
        return id;
    }

    public void setAmount(int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount cannot be less than 1");
        } else
        if(type == SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS || type == SkiPassType.WEEKEND_HALF_DAY_SKI_PASS)
        {
        }

        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getType()
    {
        return type;
    }

    public String getTypeString(){
        return SkiPassType.intTypeToString(type);
    }

    public void block(){
        isblocked = true;
    }

    public void unblock(){
        isblocked = false;
    }

//    public void setStartTime(int hour, int minutes)
//    {
//        START_WORK_HOUR = hour;
//        END_WORK_MINUTE = minutes;
//    }
//
//    public void setHalfTime(int hour, int minutes)
//    {
//        HALF_TIME_HOUR = hour;
//        HALF_TIME_MINUTE = minutes;
//    }
//
//    public void setEndTime(int hour, int minutes)
//    {
//        END_WORK_HOUR = hour;
//        END_WORK_MINUTE = minutes;
//    }

    abstract public boolean tryEnterLift(); // true - if pass can tryEnterLift
    abstract public boolean isValid();
    abstract public void activate();


    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
