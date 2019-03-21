package com.example.worktimecalculator;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {


    private WorkTime workTime = new WorkTime(this);

    private TextInputEditText textInputEditText_StartTime;
    private TextInputEditText textInputEditText_EndTime;

    private TextView textView_Result;
    private TextView textView_Result2;

    private String[] startTimes = {"8:15", "8:30", "9:15", "9:30", "13:30", "14:00", "15:30"};
    private String[] endTimes =   {"14:00", "15:30", "20:00", "20:30", "21:15", "21:45", "22:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditText_StartTime = findViewById(R.id.TextInputEditText_StartTime);
        textInputEditText_EndTime = findViewById(R.id.TextInputEditText_EndTime);

        textView_Result = findViewById(R.id.textView_Result);
        textView_Result2 = findViewById(R.id.textView_Result2);

        createSpinner(R.id.spinner_StartTime, startTimes, textInputEditText_StartTime);
        createSpinner(R.id.spinner_EndTime, endTimes, textInputEditText_EndTime);

        if (savedInstanceState != null) {
            textInputEditText_StartTime.setText(savedInstanceState.getString("textInputEditText_StartTime"));
            textInputEditText_EndTime.setText(savedInstanceState.getString("textInputEditText_EndTime"));
            if(!(savedInstanceState.get("textView_Result").equals(getString(R.string.app_result)))) {
                textView_Result.setText(savedInstanceState.getString("textView_Result"));
                textView_Result2.setText(savedInstanceState.getString("textView_Result2"));
                textView_Result.setVisibility(View.VISIBLE);
                textView_Result2.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("textInputEditText_StartTime", textInputEditText_StartTime.getText().toString());
        outState.putString("textInputEditText_EndTime", textInputEditText_EndTime.getText().toString());

        outState.putString("textView_Result", textView_Result.getText().toString());
        outState.putString("textView_Result2", textView_Result2.getText().toString());
    }

    public void onClickButtonOk(View view) throws ParseException {

        textView_Result.setVisibility(View.VISIBLE);
        textView_Result2.setVisibility(View.VISIBLE);

        textView_Result.setText(workTime.getWorkTime(textInputEditText_StartTime.getText(), textInputEditText_EndTime.getText()));
        textView_Result2.setText(workTime.getFraction());
    }

    private void createSpinner(int id_spinner, final String[] list, final TextInputEditText textInputEditText) {
        Spinner spinner = findViewById(id_spinner);
        ArrayAdapter<String> Adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);

        spinner.setAdapter(Adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= position; i++) {
                    if (i == position) {
                        textInputEditText.setText(list[i]);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
