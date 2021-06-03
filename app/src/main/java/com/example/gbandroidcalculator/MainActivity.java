package com.example.gbandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StringBuilder sB = new StringBuilder();
    TextView tv_result, tv_first_digit;
    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_result = findViewById(R.id.text_result);
        tv_first_digit = findViewById(R.id.text_first_digit);

        findViewById(R.id.btn_0).setOnClickListener(clickListener);
        findViewById(R.id.btn_1).setOnClickListener(clickListener);
        findViewById(R.id.btn_2).setOnClickListener(clickListener);
        findViewById(R.id.btn_3).setOnClickListener(clickListener);
        findViewById(R.id.btn_4).setOnClickListener(clickListener);
        findViewById(R.id.btn_5).setOnClickListener(clickListener);
        findViewById(R.id.btn_6).setOnClickListener(clickListener);
        findViewById(R.id.btn_7).setOnClickListener(clickListener);
        findViewById(R.id.btn_8).setOnClickListener(clickListener);
        findViewById(R.id.btn_9).setOnClickListener(clickListener);
        findViewById(R.id.btn_dot).setOnClickListener(clickListener);

        findViewById(R.id.btn_result).setOnClickListener(clickActions);
        findViewById(R.id.btn_plus).setOnClickListener(clickActions);
        findViewById(R.id.btn_minus).setOnClickListener(clickActions);
        findViewById(R.id.btn_multiple).setOnClickListener(clickActions);
        findViewById(R.id.btn_div).setOnClickListener(clickActions);

    }

    final View.OnClickListener clickActions = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_plus) {
                if (Action.summation) {
                    return;
                } else if (Action.subtraction || Action.multiplication || Action.division) {
                    Action.summation = true;
                    Action.subtraction = false;
                    Action.multiplication = false;
                    Action.division = false;
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "+"));
                } else {
                    Action.summation = true;
                    Action.subtraction = false;
                    Action.multiplication = false;
                    Action.division = false;
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('+'));
                }
            } else if (v.getId() == R.id.btn_minus) {
                if (Action.subtraction) {
                    return;
                } else if (Action.summation || Action.multiplication || Action.division) {
                    Action.summation = false;
                    Action.subtraction = true;
                    Action.multiplication = false;
                    Action.division = false;
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "-"));
                } else {
                    Action.summation = false;
                    Action.subtraction = true;
                    Action.multiplication = false;
                    Action.division = false;
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('-'));
                }
            } else if (v.getId() == R.id.btn_multiple) {
                if (Action.multiplication) {
                    return;
                } else if (Action.summation || Action.subtraction || Action.division) {
                    Action.summation = false;
                    Action.subtraction = false;
                    Action.multiplication = true;
                    Action.division = false;
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "*"));
                } else {
                    Action.summation = false;
                    Action.subtraction = false;
                    Action.multiplication = true;
                    Action.division = false;
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('*'));
                }
            } else if (v.getId() == R.id.btn_div) {
                if (Action.division) {
                    return;
                } else if (Action.summation || Action.subtraction || Action.multiplication) {
                    Action.summation = false;
                    Action.subtraction = false;
                    Action.multiplication = false;
                    Action.division = true;
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "/"));
                } else {
                    Action.summation = false;
                    Action.subtraction = false;
                    Action.multiplication = false;
                    Action.division = true;
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('/'));
                }
            } else if (v.getId() == R.id.btn_result) {
                calc.addDigit(sB.substring(sB.indexOf(Action.getSymbol()) + 1));
                String res = calc.result();
                tv_result.setText(res);
                tv_first_digit.setText("");
                sB.replace(0, sB.length(), res);
                calc.addDigit(sB.toString());
            }
        }
    };

    final View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.btn_0) {
                sB.append("0");
            } else if (v.getId() == R.id.btn_1) {
                sB.append("1");
            } else if (v.getId() == R.id.btn_2) {
                sB.append("2");
            } else if (v.getId() == R.id.btn_3) {
                sB.append("3");
            } else if (v.getId() == R.id.btn_4) {
                sB.append("4");
            } else if (v.getId() == R.id.btn_5) {
                sB.append("5");
            } else if (v.getId() == R.id.btn_6) {
                sB.append("6");
            } else if (v.getId() == R.id.btn_7) {
                sB.append("7");
            } else if (v.getId() == R.id.btn_8) {
                sB.append("8");
            } else if (v.getId() == R.id.btn_9) {
                sB.append("9");
            }
            tv_result.setText(sB.toString());
        }
    };
}
