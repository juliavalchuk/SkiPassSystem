package ua.com.bukovel.skipass.test;

import ua.com.bukovel.skipass.SkiPassSystem;
import ua.com.bukovel.skipass.SkiPassType;
import ua.com.bukovel.skipass.Tourniquet;
import ua.com.bukovel.skipass.type.SkiPass;

/**
 * Created by Yuliia_Valchuk
 */
public class Main {

    public static void main(String [] args){
        // system
        SkiPassSystem system = new SkiPassSystem();

        // tourniquets
        Tourniquet tourniquet1 = new Tourniquet(system);
        Tourniquet tourniquet2 = new Tourniquet(system);

        //Skipasses
        SkiPass skiPassS = system.createSkiPass(SkiPassType.SEASON_SKI_PASS);
        SkiPass skiPassWDD = system.createSkiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS, 2);
        SkiPass skiPassWKL = system.createSkiPass(SkiPassType.WEEKEND_LIFTS_SKI_PASS, 1);
        SkiPass skiPassWDHD = system.createSkiPass(SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS);

        tourniquet1.check(skiPassS.getId());
        tourniquet1.check(skiPassS.getId());
        tourniquet1.check(skiPassWKL.getId());

        system.blockSkiPass(skiPassS.getId());

        tourniquet2.check(skiPassWDHD.getId());
        tourniquet2.check(skiPassWKL.getId());
        tourniquet2.check(skiPassWDD.getId());
        tourniquet2.check(skiPassS.getId());

        System.out.println(system.getLiftAcceptReportTotal());
        System.out.println(system.getLiftDeclineReportTotal());

        System.out.println(skiPassS.getType().toString());
    }
}
