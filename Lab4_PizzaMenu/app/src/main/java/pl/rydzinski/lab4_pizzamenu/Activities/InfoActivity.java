package pl.rydzinski.lab4_pizzamenu.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import pl.rydzinski.lab4_pizzamenu.R;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
