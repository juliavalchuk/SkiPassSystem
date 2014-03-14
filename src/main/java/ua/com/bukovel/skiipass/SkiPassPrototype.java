package ua.com.bukovel.skiipass;

import ua.com.bukovel.skiipass.type.SkiPass;

import java.util.HashMap;

/**
 * Created by julia
 */
public class SkiPassPrototype {
    private static HashMap<Integer, SkiPass> skiiPassHashMap = new HashMap<Integer, SkiPass>();

    public static SkiPass createSkiiPass(int skiiPassType)
    {
        SkiPass skiPass = skiiPassHashMap.get(skiiPassType);
        return (SkiPass) skiPass.clone();
    }

    public static void addPrototype(int type, SkiPass skiPass)
    {
        skiiPassHashMap.put(type, skiPass);
    }

    public static void removePrototype(int type)
    {
        skiiPassHashMap.remove(type);
    }
}
