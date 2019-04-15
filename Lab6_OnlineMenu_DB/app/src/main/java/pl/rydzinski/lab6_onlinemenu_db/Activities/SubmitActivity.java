package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pl.rydzinski.lab6_onlinemenu_db.R;


public class SubmitActivity extends ToolbarCreator {

    private TextView textViewName;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setIdMenu(R.menu.main_menu);
        setThisActivity(SubmitActivity.this);

        textViewName = findViewById(R.id.textView_Submit);
        editText = findViewById(R.id.editText);

        textViewName.setText(getFoodName());
    }

    public void sendResult(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getFoodName() + " x" + editText.getText().toString());
        startActivity(intent);
    }
}
