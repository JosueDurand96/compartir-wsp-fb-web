package com.durand.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelefonoActivity extends AppCompatActivity {
    ConstraintLayout btncall;
    EditText txtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);

        btncall = findViewById(R.id.btncall);
        txtNumber = findViewById(R.id.txtNumber);


        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberPhone = txtNumber.getText().toString();
                call(numberPhone);


            }
        });
    }

    private void call(String number) {
        Intent intent =new  Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }
}
