package ua.com.bukovel.skipass;

import ua.com.bukovel.skipass.type.SkiPass;

import java.util.HashMap;

/**
 * Created by julia
 */
public class SkiPassPrototype {
    private HashMap<SkiPassType, SkiPass> skiPassHashMap = new HashMap<SkiPassType, SkiPass>();

    public SkiPass createSkiPass(SkiPassType skiPassType)
    {
        try{
            SkiPass skiPass = skiPassHashMap.get(skiPassType);
            return (SkiPass) skiPass.clone();
        } catch (Exception ex){ // what exception?
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public void addPrototype(SkiPassType type, SkiPass skiPass)
    {
        skiPassHashMap.put(type, skiPass);
    }

    public void removePrototype(SkiPassType type)
    {
        skiPassHashMap.remove(type);
    }
}
