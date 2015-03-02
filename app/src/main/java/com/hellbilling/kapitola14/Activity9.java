package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Co treba dorobit:
- formatovanie vyzoru-
- ako je to s ponechanim tlacitiek pri funkcnom browseri?
- otvaranie a zatvaranie klavesnice
- back

 */

public class Activity9 extends Activity
    implements EditText.OnEditorActionListener{

    WebView browser;
    EditText Url;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity9);
        browser=(WebView)findViewById(R.id.webkit);

        // Obsah z internetu
        // v AndroidManifest.xml musi byt zadane pre povolenie internetu
        //<uses-permission android:name="android.permission.INTERNET"/>

        // getSettings vracia instanciu triedy WebSettings ktora specifikuje nastavenia browseru
        // povolenie javascriptu
        browser.getSettings().setJavaScriptEnabled(true);

        // Obsah z internetu
        //browser.loadUrl("http://google.com");
        // Obsah zo stringu
        browser.loadData("<html><body><b>Tuto sa zobrazi</b></body></html>","text/html","UTF-8");

        // nastavenie listeneru na url aby sa dalo pouzit send
        Url = (EditText) findViewById(R.id.myUrl);
        Url.setOnEditorActionListener(this); // tu sa nastavil listener onEditorAction
    }

    // metoda volana buttonom go
    public void buttonHandler(View view){
        changeURL();
    }

    // handler sendu od edittestu myurl
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        // Toto presne neviem ako funguje, dolezita je asi konstanta IME_ACTION_SEND
        if (actionId == EditorInfo.IME_ACTION_SEND) {
            changeURL();
            handled = true;
        }
        return handled;
    }

    private void changeURL() {
        Toast.makeText(getApplicationContext(), "Menim URL", Toast.LENGTH_SHORT).show();
        String message = Url.getText().toString();
        browser.loadUrl("http://"+message);
        //browser.loadData("<html><body><b>Tuto sa zobrazi message "+message+"</b></body></html>","text/html","UTF-8");
    }
}