package com.example.gbandroidcalculator;

import java.util.ArrayList;

/**
 * Project Gb.Android.Calculator
 *
 * @Author Zoer Aleksandr
 * Created 31.05.2021 1:11
 */
// Что необходимо доделать
// 1. Класс дженерик для сохранения результата ввода, тогда можно убрать 2/3 вычислительных методов
// 2. Добавить еще один класс и вынести в него условия расчета
public class Calculator {


    ArrayList<String> digitList = new ArrayList<>();

    protected void addDigit(String s) {
        digitList.add(s);
    }

    private void clearList() {
        digitList.clear();
    }

    protected String result() {
        Integer a = null;
        Integer b = null;

        Double aDouble = null;
        Double bDouble = null;

        if (!Action.aDot) {
            a = Integer.parseInt(digitList.get(0));
            b = Integer.parseInt(digitList.get(1));
        }else {
            aDouble = Double.parseDouble(digitList.get(0));
            bDouble = Double.parseDouble(digitList.get(1));
        }

        clearList();

        if (Action.operation == Operation.summation) {
            return plus(a, b).toString();
        } else if (Action.operation == Operation.subtraction) {
            return minus(a, b).toString();
        } else if (Action.operation == Operation.multiplication) {
            return multiple(a, b).toString();
        } else if (Action.operation == Operation.division) {
            return div(a, b).toString();
        } else
            return "0";
    }

    protected Integer plus(Integer a, Integer b) {
        if (a != null && b != null) {
            return a + b;
        }
        return null;
    }

    protected Double plus(Integer a, Double b) {
        return a + b;
    }

    protected Double plus(Double a, Double b) {
        return a + b;
    }

    protected Integer minus(Integer a, Integer b) {
        System.out.println("result = " + (a - b));
        return a - b;
    }

    protected Double minus(Double a, Integer b) {
        return a - b;
    }

    protected Double minus(Integer a, Double b) {
        return a - b;
    }

    protected Integer multiple(Integer a, Integer b) {
        return a * b;
    }

    protected Double multiple(Double a, Integer b) {
        return a * b;
    }

    protected Double multiple(Integer a, Double b) {
        return a * b;
    }

    protected Integer div(Integer a, Integer b) {
        if (b == 0) return null;
        return a / b;
    }

    protected Double div(Double a, Integer b) {
        if (b == 0) return null;
        return a / b;
    }

    protected Double div(Integer a, Double b) {
        if (b == 0) return null;
        return a / b;
    }
}
