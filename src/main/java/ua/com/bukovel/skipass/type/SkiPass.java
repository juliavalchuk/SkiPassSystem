package ua.com.bukovel.skipass.type;

import ua.com.bukovel.skipass.SkiPassType;

import java.util.UUID;

/**
 * Created by julia
 */
public abstract class SkiPass implements Cloneable {
    protected UUID id; // uniq id
    protected int amount; // days or lifts
    protected SkiPassType type; // kind of skii-pass
    protected boolean isblocked;

    public void setStartsParameters(UUID uuid, SkiPassType type){
        if(id != null){
            throw new IllegalArgumentException("Ski-pass has already had id");
        }
        if(type == null){
            throw new IllegalArgumentException(String.format("Wrong type"));
        }
        id = uuid;
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
        if((type == SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS || type == SkiPassType.WEEKEND_HALF_DAY_SKI_PASS)
                && amount != 1){
            throw new IllegalArgumentException("Illegal amount for half day");
        }

        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }

    public SkiPassType getType()
    {
        return type;
    }

    public String getTypeString(){
        return type.toString();
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
