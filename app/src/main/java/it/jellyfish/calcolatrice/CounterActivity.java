package it.jellyfish.calcolatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    TextView text;
    Button btn;

    int counter = 0;


    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter++;
            updateUI();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.testo);
        btn = findViewById(R.id.bottone);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateUI();
            }
        });



        btn.setOnClickListener(listener1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }



    public void add(View v) {
        counter++;
        updateUI();
    }


    void updateUI() {
        text.setText("Contatore: "+this.counter);
    }

}
