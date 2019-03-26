package com.java.springbootstarter;

public class EmployeeIDGenerator {

    public static int idValue = 1001;

    public static String getId(){

        int value = idValue;
        idValue++;
        return value+"";

    }

}
