package it.jellyfish.calcolatrice.communication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import it.jellyfish.calcolatrice.R;

public class FirstActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText = findViewById(R.id.text);
    }



    public void openSecond(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("TEXT", editText.getText().toString());
        startActivityForResult(intent, 123);
    }



    public void call(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:123"));
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123) {
            if (resultCode == RESULT_OK) {
                String r = data.getStringExtra("RESULT");
                editText.setText(r);
            }
        }
    }
}
