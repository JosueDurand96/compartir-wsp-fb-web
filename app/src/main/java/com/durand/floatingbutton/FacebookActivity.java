package com.durand.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class FacebookActivity extends AppCompatActivity {
    ConstraintLayout btnFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        btnFb = findViewById(R.id.btnFb);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/manyar.comer"));
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/manyar.comer")));
                }
            }
        });
    }


    public final void launchFacebook() {
        //   final String urlFb = "fb://page/"+"1111";
        final String urlFb = "fb://m.facebook.com/manyar.comer/" + "manyar.comer";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlFb));

        // If a Facebook app is installed, use it. Otherwise, launch
        // a browser
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() == 0) {
            // final String urlBrowser = "https://www.facebook.com/"+pageid;
            final String urlBrowser = "https://www.facebook.com/manyar.comer";
            intent.setData(Uri.parse(urlBrowser));
        }

        startActivity(intent);
    }
}
