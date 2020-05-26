package com.durand.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WhatsAppActivity extends AppCompatActivity {
    ConstraintLayout btnWsp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app);

        final EditText editText_mobile = findViewById(R.id.editText_mobile);
        final EditText editText_msg = findViewById(R.id.editText_msg);

        btnWsp = findViewById(R.id.btnWsp);
        btnWsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
                if (isWhatsappInstalled) {
                    Toast.makeText(getApplicationContext(), "Installed", Toast.LENGTH_SHORT).show();
                    String mobileNumber = editText_mobile.getText().toString();
                    String message = editText_msg.getText().toString();
                    String toNumber = "+51" + mobileNumber; // contains spaces.
                    toNumber = toNumber.replace("+", "").replace(" ", "");
                    Intent sendIntent = new Intent("android.intent.action.MAIN");
                    sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setPackage("com.whatsapp");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                    Toast.makeText(WhatsAppActivity.this, " Si tiene wsp yupii  ", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse("market://details?id=com.whatsapp");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    Toast.makeText(getApplicationContext(), "Instala wsp amiguito", Toast.LENGTH_SHORT).show();
                    startActivity(goToMarket);
                }


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
