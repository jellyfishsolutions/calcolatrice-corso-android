package it.jellyfish.calcolatrice;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import it.jellyfish.calcolatrice.service.Calculator;
import it.jellyfish.calcolatrice.service.operations.Addition;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        calculator = new Calculator();
    }

    @Override
    protected void onStart() {
        super.onStart();



        SharedPreferences sharedPref = this.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        String oldValue = sharedPref.getString("display", "0");


        display.setText(oldValue);
        parseAndSetDisplay();
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPref = this.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("display", display.getText().toString());
        editor.commit();


    }

    void pressed(int number) {
        String current = display.getText()+"";
        if (current.compareTo("0") == 0) {
            current = "";
        }
        current += number;
        display.setText(current);
    }


    public void on0(View v) {
        pressed(0);
    }
    public void on1(View v) {
        pressed(1);
    }
    public void on2(View v) {
        pressed(2);
    }
    public void on3(View v) {
        pressed(3);
    }
    public void on4(View v) {
        pressed(4);
    }
    public void on5(View v) {
        pressed(5);
    }
    public void on6(View v) {
        pressed(6);
    }
    public void on7(View v) {
        pressed(7);
    }
    public void on8(View v) {
        pressed(8);
    }
    public void on9(View v) {
        pressed(9);
    }


    public void onComma(View v) {
        String current = display.getText().toString();
        if (!current.contains(",")) {
            current += ",";
            display.setText(current);
        }
    }

    public void ac(View v) {
        calculator.clean();
        display.setText("0");
    }

    public void sign(View v) {
        String current = display.getText().toString();
        if (current.compareTo("0") != 0) {
            if (current.startsWith("-")) {
                current = current.substring(1);
            } else {
                current = "-" + current;
            }
            display.setText(current);
        }
    }


    public void percent(View v) {}

    public void division(View v) {}

    public void multiply(View v) {}

    public void subtraction(View v) {}

    public void addition(View v) {
        parseAndSetDisplay();
        calculator.setOperation(new Addition());
        display.setText("");
    }

    public void result(View v) {
        parseAndSetDisplay();
        calculator.execute();

        double r = calculator.getDisplay();
        String formatted = NumberFormat.getInstance().format(r).replace(".", ",");
        display.setText(formatted);
    }

    private void parseAndSetDisplay() {
        String current = display.getText().toString().replace(",", ".");
        double d = Double.parseDouble(current);
        calculator.setDisplay(d);
    }


}
