package it.jellyfish.calcolatrice.communication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import it.jellyfish.calcolatrice.R;

public class SecondActivity extends AppCompatActivity {

    String currentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if (intent != null) {
            currentText = intent.getStringExtra("TEXT");
        }


        TextView t = findViewById(R.id.testo);
        t.setText(currentText);

    }



    public void completed(View v) {
        Intent intent = new Intent();
        if (currentText == null) {
            currentText = "nullo";
        }
        intent.putExtra("RESULT", currentText.toUpperCase());
        setResult(RESULT_OK, intent);
        finish();
    }
}
