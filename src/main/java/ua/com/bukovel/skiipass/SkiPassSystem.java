package ua.com.bukovel.skiipass;

import ua.com.bukovel.skiipass.type.*;

import java.util.UUID;

/**
 * Created by julia
 */
public class SkiPassSystem {
    private final int AMOUNT_DEFAULT = 1;

    private MyArrayList<String,SkiPass> skipassList = new MyArrayList<String,SkiPass>();
    private int[] acceptLifts = new int[SkiPassType.COUNT];
    private  int[] declineLifts = new int[SkiPassType.COUNT];

    public SkiPass createSkiiPass(int skiiPassType)
    {
        return createSkiiPass(skiiPassType, AMOUNT_DEFAULT);
    }

    public SkiPass createSkiiPass(int skiiPassType, int amount)
    {
        String uuid;
        SkiPass skiPass = SkiPassPrototype.createSkiiPass(skiiPassType);

        do{
            uuid = UUID.randomUUID().toString();
        }while(skipassList.get(uuid) != null); // while id not repeat

        skiPass.setStartsParametrs(uuid, skiiPassType);
        skiPass.setAmount(amount);

        skipassList.add(uuid, skiPass);
        return skiPass;
    }

    public void blockSkiiPass(String id)
    {
        skipassList.get(id).block();
    }

    public void unblockSkiiPass(String id)
    {
        skipassList.get(id).unblock();
    }

    public SkiPass getSkiPass(String id){

        return skipassList.get(id);
    }

    public boolean deleteSkiiPass(String id) // false if system cann't find ski-pass
    {
        return skipassList.remove(id) != null;
    }

     public void setPrototype()
     {
         SkiPassPrototype.addPrototype(SkiPassType.SEASON_SKI_PASS, new SeasonSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKDAY_DAYS_SKI_PASS, new WeekdayDaysSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS, new WeekdayDaysSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKDAY_LIFTS_SKI_PASS, new WeekdayLiftsSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKEND_DAYS_SKI_PASS, new WeekendDaysSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKEND_HALF_DAY_SKI_PASS, new WeekendDaysSkiPass());
         SkiPassPrototype.addPrototype(SkiPassType.WEEKEND_LIFTS_SKI_PASS, new WeekendLiftsSkiPass());
     }


    // reports

    private boolean isExitingType(int type){
        return type < SkiPassType.COUNT && type >= 0;
    }

    public void setAcceptLift(int type){
        if(!isExitingType(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        acceptLifts[type]++;
    }

    public void setDeclineLift(int type){
        if(!isExitingType(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        declineLifts[type]++;
    }

    public int getAcceptLiftByType(int type){
        if(!isExitingType(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        return acceptLifts[type];
    }

    public int getDeclineLiftByType(int type){
        if(!isExitingType(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        return declineLifts[type];
    }

    public int getAcceptSum(){
        int s = 0;
        for (int i = 0; i < SkiPassType.COUNT; ++i){
            s += acceptLifts[i];
        }
        return s;
    }

    public int getDeclineSum(){
        int s = 0;
        for (int i = 0; i < SkiPassType.COUNT; ++i){
            s += declineLifts[i];
        }
        return s;
    }
}
