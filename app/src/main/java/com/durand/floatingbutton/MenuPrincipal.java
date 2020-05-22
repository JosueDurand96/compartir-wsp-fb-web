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
    FloatingActionButton buton2, buton3;
    Animation fabOpen, fabClose, fabRClockwise, fabRAntiClockwise;


    TextView textView;
    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        buton1 = findViewById(R.id.buton1);
        buton2 = findViewById(R.id.buton2);
        buton3 = findViewById(R.id.buton3);
        textView = findViewById(R.id.textView);

        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRAntiClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen){
                    buton3.startAnimation(fabClose);
                    buton2.startAnimation(fabClose);
                    //  buton1.startAnimation(fabRClockwise);

                    isOpen = false;
                }else{
                    buton3.startAnimation(fabOpen);
                    buton2.startAnimation(fabOpen);
                    //  buton1.startAnimation(fabRAntiClockwise);

                    buton3.setClickable(true);
                    buton2.setClickable(true);

                    isOpen = true;
                }

            }
        });
    }
}
