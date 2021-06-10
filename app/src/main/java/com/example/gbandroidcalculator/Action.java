package com.example.gbandroidcalculator;


import android.content.Context;

/**
 * Project Gb.Android.Calculator
 *
 * @Author Zoer Aleksandr
 * Created 03.06.2021 7:37
 */
public class Action {

    static boolean action, aDot;

    static Operation operation;

    protected static String getSymbol(){
        if(operation == Operation.summation) return "+";
        else if (operation == Operation.subtraction) return "-";
        else if (operation == Operation.multiplication) return "*";
        else if (operation == Operation.division) return "/";
        else return "";
    }
}
