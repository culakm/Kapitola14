package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;


public class Activity10 extends Activity {
    WebView browser;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity10);
        browser=(WebView)findViewById(R.id.webkit);
        browser.setWebViewClient(new Callback());
        loadTime("initial karol");
    }

    void loadTime(String urlStr) {
        String page="<html><body><a href=\"clock.tu.moze.byt.hocico\">"
                +new Date().toString()
                +"</a><br>URL:"
                +urlStr
                +"</body></html>";

        browser.loadData(page, "text/html", "UTF-8");
    }

    private class Callback extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            loadTime(url);

            return(true);
        }
    }
}