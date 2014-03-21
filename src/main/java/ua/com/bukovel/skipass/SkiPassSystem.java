package ua.com.bukovel.skipass;

import ua.com.bukovel.skipass.type.*;

import java.util.UUID;

/**
 * Created by julia
 */
public class SkiPassSystem {
    SkiPassPrototype passPrototype;
    private final int AMOUNT_DEFAULT = 1;

    private MyArrayList<UUID,SkiPass> skipassList = new MyArrayList<UUID,SkiPass>();
    private int[] acceptLifts = new int[SkiPassType.COUNT];
    private  int[] declineLifts = new int[SkiPassType.COUNT];

    public SkiPassSystem(){
        passPrototype = new SkiPassPrototype();
        setPrototypes(passPrototype);
    }

    public SkiPass createSkiPass(SkiPassType skiPassType)
    {
        return createSkiPass(skiPassType, AMOUNT_DEFAULT);
    }

    public SkiPass createSkiPass(SkiPassType skiPassType, int amount)
    {
        UUID uuid = UUID.randomUUID(); // check id
        SkiPass skiPass = passPrototype.createSkiPass(skiPassType);

        skiPass.setStartsParameters(uuid, skiPassType);
        skiPass.setAmount(amount);

        skipassList.add(uuid, skiPass);
        return skiPass;
    }

    public void blockSkiPass(UUID id)
    {
        skipassList.get(id).block();
    }

    public void unblockSkiPass(UUID id)
    {
        skipassList.get(id).unblock();
    }

    public SkiPass getSkiPass(UUID id){

        return skipassList.get(id);
    }

    public void deleteSkiPass(UUID id)
    {
        skipassList.remove(id);
    }

     public void setPrototypes(SkiPassPrototype skiPassPrototype)
     {
         skiPassPrototype.addPrototype(SkiPassType.SEASON_SKI_PASS, new SeasonSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKDAY_DAYS_SKI_PASS, new WeekdayDaysSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS, new WeekdayDaysSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKDAY_LIFTS_SKI_PASS, new WeekdayLiftsSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKEND_DAYS_SKI_PASS, new WeekendDaysSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKEND_HALF_DAY_SKI_PASS, new WeekendDaysSkiPass());
         skiPassPrototype.addPrototype(SkiPassType.WEEKEND_LIFTS_SKI_PASS, new WeekendLiftsSkiPass());
     }


    // reports

    private boolean typeExists(int type){
        return type < SkiPassType.COUNT && type >= 0;
    }

    public void reportLiftAccept(int type){
        if(!typeExists(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        acceptLifts[type]++;
    }

    public void reportLiftDecline(int type){
        if(!typeExists(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        declineLifts[type]++;
    }

    public int getLiftAcceptReportByType(int type){
        if(!typeExists(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        return acceptLifts[type];
    }

    public int getLiftDeclineReportByType(int type){
        if(!typeExists(type)){
            throw new IndexOutOfBoundsException("Wrong type");
        }
        return declineLifts[type];
    }

    public int getLiftAcceptReportTotal(){
        int s = 0;
        for (int i = 0; i < SkiPassType.COUNT; ++i){
            s += acceptLifts[i];
        }
        return s;
    }

    public int getLiftDeclineReportTotal(){
        int s = 0;
        for (int i = 0; i < SkiPassType.COUNT; ++i){
            s += declineLifts[i];
        }
        return s;
    }
}
