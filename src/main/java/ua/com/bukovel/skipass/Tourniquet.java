package ua.com.bukovel.skipass;

import ua.com.bukovel.skipass.type.SkiPass;

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
        SkiPass skiPass = null;
        try {
            skiPass = skiPassSystem.getSkiPass(id);
        } catch (IllegalArgumentException e){
            return false;
        }
        if(!skiPass.tryEnterLift()){
            skiPassSystem.reportLiftDecline(skiPass.getType());
            return false;
        }

        skiPassSystem.reportLiftAccept(skiPass.getType());
        return true;
    }
}
