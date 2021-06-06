package com.example.gbandroidcalculator;


import android.content.Context;

/**
 * Project Gb.Android.Calculator
 *
 * @Author Zoer Aleksandr
 * Created 03.06.2021 7:37
 */
public class Action {

    static boolean summation, subtraction, multiplication, division, aDot;


    protected static String getSymbol(){
        if(summation) return "+";
        else if (subtraction) return "-";
        else if (multiplication) return "*";
        else if (division) return "/";
        else return "";
    }
}
