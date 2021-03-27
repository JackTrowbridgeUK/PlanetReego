package org.jayjaytee.planetreego.utils;

public class NumberUtils {

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String s){
        try{
            Float.parseFloat(s);
        }catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

}
