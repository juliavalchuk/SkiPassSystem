package ua.com.bukovel.skiipass;

import ua.com.bukovel.skiipass.type.SkiPass;

import java.util.HashMap;

/**
 * Created by julia
 */
public class SkiPassPrototype {
    private HashMap<Integer, SkiPass> skiPassHashMap = new HashMap<Integer, SkiPass>();

    public SkiPass createSkiPass(int skiPassType)
    {
        if(skiPassType < 0 || skiPassType > SkiPassType.COUNT){
            throw new IllegalArgumentException("Illegal type");
        }
        SkiPass skiPass = skiPassHashMap.get(skiPassType);
        return (SkiPass) skiPass.clone();
    }

    public void addPrototype(int type, SkiPass skiPass)
    {
        skiPassHashMap.put(type, skiPass);
    }

    public void removePrototype(int type)
    {
        skiPassHashMap.remove(type);
    }
}
