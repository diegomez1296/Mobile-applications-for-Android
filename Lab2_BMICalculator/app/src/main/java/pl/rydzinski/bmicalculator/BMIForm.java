package pl.rydzinski.bmicalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class BMIForm extends AppCompatActivity {

    private BMICalc bmiCalc = new BMICalc(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiform);
    }

    public void onClickButtonBack(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickButtonNext(View view) {

        TextInputEditText textInput_mass = findViewById(R.id.textInput_mass);
        TextInputEditText textInput_height = findViewById(R.id.textInput_height);

        Intent intent = new Intent(this, BMIResult.class);

        try {
            intent.putExtra("BMIresult", bmiCalc.getBMI(Float.parseFloat(textInput_mass.getText().toString()), Float.parseFloat(textInput_height.getText().toString())));
        }
        catch (Exception e) {
            intent.putExtra("BMIresult", bmiCalc.getBMI(0.0f, 1.0f));
        }
        startActivity(intent);
    }

    public void onClickSwitch (View view) {

        Switch aSwitch = findViewById(R.id.switch_MF);

        TextView textView_Male = findViewById(R.id.textView_Male);
        TextView textView_Female = findViewById(R.id.textView_Female);

        if(aSwitch.isChecked()) {

            textView_Male.setTypeface(null, Typeface.NORMAL);

            textView_Female.setTypeface(null, Typeface.BOLD);
            textView_Female.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        else {
            textView_Male.setTypeface(null, Typeface.BOLD);

            textView_Female.setTypeface(null, Typeface.NORMAL);
            textView_Female.setTextColor(getResources().getColor(R.color.colorDefaultText));
        }
    }
}
