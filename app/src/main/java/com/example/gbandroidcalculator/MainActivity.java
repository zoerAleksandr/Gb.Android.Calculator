package com.example.gbandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.gbandroidcalculator.Operation.division;
import static com.example.gbandroidcalculator.Operation.multiplication;
import static com.example.gbandroidcalculator.Operation.subtraction;
import static com.example.gbandroidcalculator.Operation.summation;

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

        findViewById(R.id.btn_result).setOnClickListener(clickResult);
        
        findViewById(R.id.btn_plus).setOnClickListener(clickActions);
        findViewById(R.id.btn_minus).setOnClickListener(clickActions);
        findViewById(R.id.btn_multiple).setOnClickListener(clickActions);
        findViewById(R.id.btn_div).setOnClickListener(clickActions);

    }

    final View.OnClickListener clickActions = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_plus) {
                Action.operation = summation;
                if (Action.action) {
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "+"));
                } else {
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('+'));
                }
            } else if (v.getId() == R.id.btn_minus) {
                Action.operation = subtraction;
                if (Action.action) {
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "-"));
                } else {
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('-'));
                }
            } else if (v.getId() == R.id.btn_multiple) {
                Action.operation = multiplication;
                if (sB.charAt(sB.length() - 1) == '+') {
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "*"));
                } else {
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('*'));
                }
            } else if (v.getId() == R.id.btn_div) {
                Action.operation = division;
                if (sB.charAt(sB.length() - 1) == '+') {
                    tv_first_digit.setText(sB.replace(sB.length() - 1, sB.length(), "/"));
                } else {
                    calc.addDigit(sB.toString());
                    tv_first_digit.setText(sB.append('/'));
                }
            }
            Action.action = true;
        }
    };

    final View.OnClickListener clickResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Action.action = false;
            calc.addDigit(sB.substring(sB.indexOf(Action.getSymbol()) + 1));
            String res = calc.result();
            tv_result.setText(res);
            tv_first_digit.setText("");
            sB.replace(0, sB.length(), res);
            calc.addDigit(sB.toString());
        }
    };

    final View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Action.action = false;
            String btnString = ((Button) v).getText().toString();
            sB.append(btnString);
            tv_result.setText(sB.toString());
        }
    };
}
