package ua.com.bukovel.skipass;

import ua.com.bukovel.skipass.type.SkiPass;

import java.util.HashMap;

/**
 * Created by julia
 */
public class SkiPassPrototype {
    private HashMap<Integer, SkiPass> skiPassHashMap = new HashMap<Integer, SkiPass>();

    public SkiPass createSkiPass(int skiPassType)
    {
        try{
            SkiPass skiPass = skiPassHashMap.get(skiPassType);
            return (SkiPass) skiPass.clone();
        } catch (Exception ex){ // what exception?
            throw new IllegalArgumentException("Invalid type");
        }
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
