package pl.rydzinski.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_Description = findViewById(R.id.textView_Desc);
    }

    public void onClickButton(View view) {

        Intent intent = new Intent(this, BMIForm.class);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {

        switch(view.getId()) {
            case R.id.radioButton_General:
                if (((RadioButton) view).isChecked())
                    textView_Description.setText(getString(R.string.app_GenDescription));
                    break;
            case R.id.radioButton_Details:
                if (((RadioButton) view).isChecked())
                    textView_Description.setText(getString(R.string.app_DetDescription));
                    break;
            case R.id.radioButton_History:
                if (((RadioButton) view).isChecked())
                    textView_Description.setText(getString(R.string.app_HistoryDescription));
                    break;
        }

    }
}
