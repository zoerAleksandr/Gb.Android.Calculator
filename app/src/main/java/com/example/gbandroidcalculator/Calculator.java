package com.example.gbandroidcalculator;

import java.util.ArrayList;

/**
 * Project Gb.Android.Calculator
 *
 * @Author Zoer Aleksandr
 * Created 31.05.2021 1:11
 */
// Что необходимо доделать
// 1. Добавить еще один класс и вынести в него условия расчета
public class Calculator {


    ArrayList<String> digitList = new ArrayList<>();

    protected void addDigit(String s) {
        digitList.add(s);
        System.out.println(digitList.size());
    }

    private void clearList() {
        digitList.clear();
    }

    protected String result() {

        Double a = null;
        Double b = null;

        if (digitList.size() == 2) {
            a = Double.parseDouble(digitList.get(0));
            b = Double.parseDouble(digitList.get(1));
            clearList();

            if (Action.operation == Operation.summation) {
                return plus(a, b).toString();
            } else if (Action.operation == Operation.subtraction) {
                return minus(a, b).toString();
            } else if (Action.operation == Operation.multiplication) {
                return multiple(a, b).toString();
            } else if (Action.operation == Operation.division) {
                return div(a, b).toString();
            } else return "Error.";
        } else {
            clearList();
            return "Error.";
        }
    }


    protected Double plus(Double a, Double b) {
        return a + b;
    }

    protected Double minus(Double a, Double b) {
        return a - b;
    }

    protected Double multiple(Double a, Double b) {
        return a * b;
    }

    protected Double div(Double a, Double b) {
        if (b == 0.0) return null;
        return a / b;
    }

}
