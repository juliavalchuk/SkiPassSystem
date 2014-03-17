package ua.com.bukovel.skiipass.type;

import ua.com.bukovel.skiipass.SkiPassType;

import java.util.UUID;

/**
 * Created by julia
 */
public abstract class SkiPass implements Cloneable {
    protected UUID id; // uniq id
    protected int amount; // days or lifts
    protected int type; // kind of skii-pass
    protected boolean isblocked;

    public void setStartsParameters(UUID uuid, int type){
        if(id == null){
            throw new IllegalArgumentException("Ski-pass has already had id");
        }
        id = uuid;
        if(type >= SkiPassType.COUNT){
            throw new IllegalArgumentException(String.format("Type must be less than %i",
                    SkiPassType.COUNT));
        }
        this.type = type;


    }

    public UUID getId()
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
        return SkiPassType.toString(type);
    }

    public void block(){
        isblocked = true;
    }

    public void unblock(){
        isblocked = false;
    }

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
