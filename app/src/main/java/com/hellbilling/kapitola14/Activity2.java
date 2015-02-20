package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class Activity2 extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity2);

        TabHost tabs=(TabHost)findViewById(R.id.tabhost);

        tabs.setup();

        // definicia prveho tabu
        TabHost.TabSpec spec=tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Clock");
        tabs.addTab(spec);

        // definicia druheho tabu
        spec=tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Button");
        tabs.addTab(spec);

        // nastavenie druheho tabu ako default
        tabs.setCurrentTab(1);

        //tab s aktivitou treba tam dorobit nejaky activity group?
//        spec=tabs.newTabSpec("tag3");
//        Intent intent = new Intent(this, Activity1.class);
//        spec.setContent(intent);
//        spec.setIndicator("Act1");
//        tabs.addTab(spec);
    }
}
