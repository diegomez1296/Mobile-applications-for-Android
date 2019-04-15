package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import pl.rydzinski.lab6_onlinemenu_db.R;


public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
