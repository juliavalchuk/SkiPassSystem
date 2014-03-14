package ua.com.bukovel.skiipass.type;

/**
 * Created by julia
 */
public class LiftsSkiPass extends SkiPass {

    @Override
    public boolean tryEnterLift() {
        if(isValid())
        {
            amount--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isValid() {
        if(!isblocked && amount > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public void activate() {

    }
}
