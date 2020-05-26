package com.durand.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuPrincipal extends AppCompatActivity {


    ConstraintLayout buton1, buton2;
    FloatingActionButton btnCall, btnWhatsapp, btnFace, btnPageWeb;
    Animation fabOpen, fabClose, fabRClockwise, fabRAntiClockwise;
    private long animationDuration = 1000;
    Animation fromCall;
    private ObjectAnimator animatorAlpha;

    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        animatorSet = new AnimatorSet();

        buton1 = findViewById(R.id.buton1);
        buton2 = findViewById(R.id.buton2);
        //floating
        btnCall = findViewById(R.id.btnCall);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnFace = findViewById(R.id.btnFace);
        btnPageWeb = findViewById(R.id.btnPageWeb);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "978342756"));
                startActivity(intent);
                Toast.makeText(MenuPrincipal.this, "LLamando a Josue Durand", Toast.LENGTH_SHORT).show();
            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
                if (isWhatsappInstalled) {
                    Toast.makeText(getApplicationContext(), "Installed", Toast.LENGTH_SHORT).show();
                    String message = "Holaa que tal";
                    String toNumber = "+51" + "978342756"; // contains spaces.
                    toNumber = toNumber.replace("+", "").replace(" ", "");
                    Intent sendIntent = new Intent("android.intent.action.MAIN");
                    sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setPackage("com.whatsapp");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                    Toast.makeText(MenuPrincipal.this, " Si tiene wsp yupii  ", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse("market://details?id=com.whatsapp");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    Toast.makeText(getApplicationContext(), "Instala wsp amiguito", Toast.LENGTH_SHORT).show();
                    startActivity(goToMarket);
                }
            }
        });

        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/manyar.comer"));
                    startActivity(intent);
                    Toast.makeText(MenuPrincipal.this, "Bienvenidos a Rocky's", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/manyar.comer")));
                    Toast.makeText(MenuPrincipal.this, "Bienvenidos a Rocky's", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnPageWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://rokys.com/pedido_rokys/index2.html"));
                startActivity(intent);
            }
        });



        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuPrincipal.this, "Primera", Toast.LENGTH_SHORT).show();
                buton1.setVisibility(View.INVISIBLE);
                buton2.setVisibility(View.VISIBLE);
                //animation instancia
                fromCall = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_open);
                btnCall.setVisibility(View.VISIBLE);
                btnWhatsapp.setVisibility(View.VISIBLE);
                btnFace.setVisibility(View.VISIBLE);
                btnPageWeb.setVisibility(View.VISIBLE);

                //Animation
                btnCall.setAnimation(fromCall);
                btnWhatsapp.setAnimation(fromCall);
                btnFace.setAnimation(fromCall);
                btnPageWeb.setAnimation(fromCall);




            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuPrincipal.this, "Segundo", Toast.LENGTH_SHORT).show();
                buton1.setVisibility(View.VISIBLE);
                buton2.setVisibility(View.INVISIBLE);
                //animation instancia

                //call
                animatorAlpha = ObjectAnimator.ofFloat(btnCall, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                animatorSetAlpha.playTogether(animatorAlpha);
                animatorSetAlpha.start();
                //Whatsapp
                animatorAlpha = ObjectAnimator.ofFloat(btnWhatsapp, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                AnimatorSet animatorSetAlpha2 = new AnimatorSet();
                animatorSetAlpha2.playTogether(animatorAlpha);
                animatorSetAlpha2.start();
                //Face
                animatorAlpha = ObjectAnimator.ofFloat(btnFace, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                AnimatorSet animatorSetAlpha3 = new AnimatorSet();
                animatorSetAlpha3.playTogether(animatorAlpha);
                animatorSetAlpha3.start();
                //Web
                animatorAlpha = ObjectAnimator.ofFloat(btnPageWeb, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                AnimatorSet animatorSetAlpha4 = new AnimatorSet();
                animatorSetAlpha4.playTogether(animatorAlpha);
                animatorSetAlpha4.start();

//                btnCall.setVisibility(View.GONE);
//                btnWhatsapp.setVisibility(View.GONE);
//                btnFace.setVisibility(View.GONE);
//                btnPageWeb.setVisibility(View.GONE);

            }
        });
    }


    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}
