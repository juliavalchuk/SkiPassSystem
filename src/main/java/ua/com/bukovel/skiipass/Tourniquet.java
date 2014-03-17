package ua.com.bukovel.skiipass;

import ua.com.bukovel.skiipass.type.SkiPass;

import java.util.UUID;

/**
 * Created by Yuliia_Valchuk
 */
public class Tourniquet {
    private SkiPassSystem skiPassSystem;

    public Tourniquet(SkiPassSystem system){
        skiPassSystem = system;
    }

    public boolean check(UUID id)
    {
        SkiPass skiPass = skiPassSystem.getSkiPass(id);
        if(!skiPass.tryEnterLift()){
            skiPassSystem.reportLiftDecline(skiPass.getType());
            return false;
        }

        skiPassSystem.reportLiftAccept(skiPass.getType());
        return true;
    }
}
