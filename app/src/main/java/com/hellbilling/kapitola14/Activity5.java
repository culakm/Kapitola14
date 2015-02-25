package com.hellbilling.kapitola14;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;


public class Activity5 extends Activity {
    static String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit",
            "morbi", "vel", "ligula", "vitae",
            "arcu", "aliquet", "mollis", "etiam",
            "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque",
            "augue", "purus"};
    ViewFlipper flipper;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_activity5);

        flipper=(ViewFlipper)findViewById(R.id.details);

        for (String item : items) {
            Button btn=new Button(this);

            btn.setText(item);

            flipper.addView(btn,
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
        }

        flipper.setFlipInterval(2000);
        flipper.startFlipping();
    }
}
