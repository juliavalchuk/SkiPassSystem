package ua.com.bukovel.skiipass.test;

import ua.com.bukovel.skiipass.SkiPassSystem;
import ua.com.bukovel.skiipass.SkiPassType;
import ua.com.bukovel.skiipass.Tourniquet;
import ua.com.bukovel.skiipass.type.SkiPass;

/**
 * Created by Yuliia_Valchuk
 */
public class MainClass {

    public static void main(String [] args){
        // system
        SkiPassSystem system = new SkiPassSystem();
        system.setPrototype();

        // tourniquets
        Tourniquet tourniquet1 = new Tourniquet(system);
        Tourniquet tourniquet2 = new Tourniquet(system);

        //Skipasses
        SkiPass skiPassS = system.createSkiiPass(SkiPassType.SEASON_SKI_PASS);
        SkiPass skiPassWDD = system.createSkiiPass(SkiPassType.WEEKDAY_DAYS_SKI_PASS, 2);
        SkiPass skiPassWKL = system.createSkiiPass(SkiPassType.WEEKEND_LIFTS_SKI_PASS, 1);
        SkiPass skiPassWDHD = system.createSkiiPass(SkiPassType.WEEKDAY_HALF_DAY_SKI_PASS);

        tourniquet1.check(skiPassS.getId());
        tourniquet1.check(skiPassS.getId());
        tourniquet1.check(skiPassWKL.getId());

        system.blockSkiiPass(skiPassS.getId());

        tourniquet2.check(skiPassWDHD.getId());
        tourniquet2.check(skiPassWKL.getId());
        tourniquet2.check(skiPassWDD.getId());
        tourniquet2.check(skiPassS.getId());

        System.out.println(system.getAcceptSum());
        System.out.println(system.getDeclineSum());
    }
}
