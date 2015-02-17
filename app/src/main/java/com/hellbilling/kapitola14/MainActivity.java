package com.hellbilling.kapitola14;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ListActivity {
    private TextView selection;
    private String[] items={
                "pako item date - time"
    };


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        // tu su mena aktivit dynamicky nacitane, ale aj tak je to blbe, treba to dorobit, aj selection ktory furt este berie nazvy z items
        //http://stackoverflow.com/questions/14000844/get-list-of-the-strings-present-in-strings-xml-file-in-android
        ArrayList<String>  pako = new ArrayList<String>();
        pako.add(getString(R.string.title_activity_activity1) + "magor");
        Toast.makeText(getBaseContext(), getString(R.string.title_activity_activity1), Toast.LENGTH_LONG).show();

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                pako));
        selection=(TextView)findViewById(R.id.selection);

    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
        Intent intent;
        switch(position) {
            case 0:
                intent = new Intent(this, Activity1.class);
                startActivity(intent);
                break;
        }
    }
}