package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;


public class Activity9 extends Activity {
    WebView browser;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity9);
        browser=(WebView)findViewById(R.id.webkit);

        // Obsah z internetu
        // v AndroidManifest.xml musi byt zadane pre povolenie internetu
        //<uses-permission android:name="android.permission.INTERNET"/>
        // povolenie javascriptu
        browser.getSettings().setJavaScriptEnabled(true);
        // getSettings vracia instanciu triedy WebSettings ktora specifikuje nastavenia browseru
        //browser.loadUrl("http://google.com");

        // Obsah zo stringu
        browser.loadData("<html><body><b>Tuto sa zobrazi</b></body></html>","text/html","UTF-8");
    }

    public void changeURL(View view) {
        EditText Url = (EditText) findViewById(R.id.myUrl);
        String message = Url.getText().toString();
        // getSettings vracia instanciu triedy WebSettings ktora specifikuje nastavenia browseru
        browser.loadUrl("http://"+message);
    }
}