package com.durand.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuPrincipal extends AppCompatActivity {
    ConstraintLayout buton1;
    FloatingActionButton btnCall, btnWhatsapp,btnFace,btnPageWeb;

    Animation fabOpen, fabClose, fabRClockwise, fabRAntiClockwise;


    TextView textView;
    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        buton1 = findViewById(R.id.buton1);
        //floating
        btnCall = findViewById(R.id.btnCall);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnFace = findViewById(R.id.btnFace);
        btnPageWeb = findViewById(R.id.btnPageWeb);



        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRAntiClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen){
                    btnCall.startAnimation(fabClose);
                    btnWhatsapp.startAnimation(fabClose);
                    btnFace.startAnimation(fabClose);
                    btnPageWeb.startAnimation(fabClose);


                    isOpen = false;
                }else{
                    btnCall.startAnimation(fabOpen);
                    btnWhatsapp.startAnimation(fabOpen);
                    btnFace.startAnimation(fabOpen);
                    btnPageWeb.startAnimation(fabOpen);

                    buton1.setPadding(30,30,30,30);

                    btnCall.setClickable(true);
                    btnWhatsapp.setClickable(true);
                    btnFace.setClickable(true);
                    btnPageWeb.setClickable(true);

                    isOpen = true;
                }

            }
        });
    }
}
