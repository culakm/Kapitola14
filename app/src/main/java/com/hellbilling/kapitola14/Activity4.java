package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;


public class Activity4 extends Activity {
    ViewFlipper flipper;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity4);

        flipper=(ViewFlipper)findViewById(R.id.details);
    }

    public void flip(View v) {
        flipper.showNext();
    }
}
