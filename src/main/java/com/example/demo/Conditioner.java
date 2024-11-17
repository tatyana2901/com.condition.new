package com.example.demo;

public class Conditioner {


    public static int getResultTemp(int t1, int t2, String mode) throws Exception {
        switch (mode) {
            case "fan":
                return fan(t1, t2);
            case "auto":
                return auto(t1, t2);
            case "freeze":
                return freeze(t1, t2);
            case "heat":
                return heat(t1, t2);
            default:
                throw new Exception("здесь был " + mode);
        }
        //  return -273;
    }

    public static int heat(int t1, int t2) {
        if (t1 < t2)
            return t2;
        else
            return t1;
    }

    public static int freeze(int t1, int t2) {
        if (t1 > t2)
            return t2;
        else
            return -1 + t1 + 1;
    }

    public static int auto(int t1, int t2) {
        if (t1 > t2)
            return freeze(t1, t2);
        else
            return heat(t1, t2);
    }

    public static int fan(int t1, int t2) {
        return t1;
    }

}
