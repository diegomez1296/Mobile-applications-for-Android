package pl.rydzinski.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BMIResult extends AppCompatActivity {

    private BMICalc bmiCalc = new BMICalc(this);

    private TextView textView_BMIRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        Intent intent = getIntent();

        textView_BMIRes = findViewById(R.id.textView_BMIResult);
        TextView textView_BMIResDesc = findViewById(R.id.textView_BMI_ResultDescription);

        float bmiResult = intent.getFloatExtra("BMIresult", 0.0f);

        NumberFormat numberFormat = new DecimalFormat("#0.00");
        textView_BMIRes.setText(getString(R.string.app_BMIResult) + "  " + numberFormat.format(bmiResult));

        textView_BMIResDesc.setText(bmiCalc.getDescription(bmiResult));
        textView_BMIResDesc.setTextColor(bmiCalc.getBMIColor(bmiResult));

        showToast();
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, getString(R.string.app_toastDesc), Toast.LENGTH_LONG);
        toast.show();
    }

    public void onClickButtonBack(View view) {

        Intent intent = new Intent(this, BMIForm.class);
        startActivity(intent);
    }

    public void sendResult(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView_BMIRes.getText().toString());
        startActivity(intent);
    }
}
