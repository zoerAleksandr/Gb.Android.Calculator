package com.example.gbandroidcalculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        TextView message = findViewById(R.id.message);

        if (getIntent() != null && getIntent().hasExtra("msg")) {
            message.setText(getIntent().getStringExtra("msg"));
        }

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == 0) {
                    Toast.makeText(MainActivity.this, "selected dark theme", Toast.LENGTH_SHORT).show();
                } else if (result.getResultCode() == 1) {
                    Toast.makeText(MainActivity.this, "selected light theme", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_config).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConfig = new Intent(MainActivity.this, ConfigActivity.class);
//                startActivity(Intent.createChooser(intentConfig, null));
                launcher.launch(intentConfig);
            }
        });

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

        findViewById(R.id.btn_delete).setOnClickListener(clickDelete);
        findViewById(R.id.btn_clear).setOnClickListener(clickDelete);


    }

    final View.OnClickListener clickDelete = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_delete) {
                sB.delete(sB.length() - 1, sB.length());
                tv_result.setText(sB.toString());
            } else if (v.getId() == R.id.btn_clear) {
                sB.delete(0, sB.length());
                tv_result.setText(sB.toString());
            }
        }
    };

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
            String result;
            calc.addDigit(sB.substring(sB.indexOf(Action.getSymbol()) + 1));

            StringBuilder res = new StringBuilder(calc.result());
            if (!Action.aDot) {
                result = res.substring(0, res.indexOf("."));
            } else {
                result = res.toString();
            }

            tv_result.setText(result);
            tv_first_digit.setText("");
            System.out.println("До " + sB.toString());
            sB.replace(0, sB.length(), result);
            System.out.println("После " + sB.toString());
//            calc.addDigit(sB.toString());
        }
    };

    final View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Action.action = false;
            String btnString = ((Button) v).getText().toString();
            sB.append(btnString);
            tv_result.setText(sB.toString());

            if (v.getId() == R.id.btn_dot) {
                Action.aDot = true;
            }
        }
    };
}
