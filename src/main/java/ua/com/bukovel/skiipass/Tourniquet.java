package ua.com.bukovel.skiipass;

import ua.com.bukovel.skiipass.type.SkiPass;

/**
 * Created by Yuliia_Valchuk
 */
public class Tourniquet {
    private SkiPassSystem skiPassSystem;

    public Tourniquet(SkiPassSystem systems){
        skiPassSystem = systems;
    }

    public boolean check(String id)
    {
        SkiPass skiPass = skiPassSystem.getSkiPass(id);
        if(!skiPass.tryEnterLift()){
            skiPassSystem.setDeclineLift(skiPass.getType());
            return false;
        }

        skiPassSystem.setAcceptLift(skiPass.getType());
        return true;
    }
}
