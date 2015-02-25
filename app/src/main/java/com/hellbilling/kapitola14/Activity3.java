package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class Activity3 extends Activity {
    private TabHost tabs=null;
    private int pocetStlaceni;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity3);

        tabs=(TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("buttontab");

        spec.setContent(R.id.buttontab);
        spec.setIndicator("Button");
        tabs.addTab(spec);

        pocetStlaceni = 0;
    }

    public void addTab(final View v) {
        TabHost.TabSpec spec=tabs.newTabSpec("tag1");

        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                pocetStlaceni++;
                //return(new AnalogClock(Activity3.this));
                LayoutInflater inflater=getLayoutInflater();
                View inf =  inflater.inflate(R.layout.dynamic_tab, (android.view.ViewGroup) v.getParent(), false);
                View pako = inf.findViewById(R.id.my_custom_layout);
                TextView texxt = (TextView) pako.findViewById(R.id.my_text_hodnota);
                texxt.setText(" uplne pako " + pocetStlaceni + "krat");
                // return layout
                return(inf.findViewById(R.id.my_custom_layout));
            }
        });

        spec.setIndicator("Clock");
        tabs.addTab(spec);
    }
}
