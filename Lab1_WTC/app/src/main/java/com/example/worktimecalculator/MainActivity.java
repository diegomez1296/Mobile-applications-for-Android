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

    private WorkTime workTime = new WorkTime();

    private TextInputEditText textInputEditText_StartTime;
    private TextInputEditText textInputEditText_EndTime;

    private String[] startTimes = {"8:15", "8:30", "9:15", "9:30", "9:45", "9:30", "15:30"};
    private String[] endTimes = {"14:00", "15:30", "21:00", "21:15", "21:30", "21:45", "22:15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditText_StartTime = findViewById(R.id.TextInputEditText_StartTime);
        textInputEditText_EndTime = findViewById(R.id.TextInputEditText_EndTime);

        createSpinner(R.id.spinner_StartTime, startTimes, textInputEditText_StartTime);
        createSpinner(R.id.spinner_EndTime, endTimes, textInputEditText_EndTime);

    }

    public void onClickButtonOk(View view) throws ParseException {

        //textInputEditText_StartTime = findViewById(R.id.TextInputEditText_StartTime);
        //textInputEditText_EndTime = findViewById(R.id.TextInputEditText_EndTime);

        TextView textView_Result = findViewById(R.id.textView_Result);
        TextView textView_Result2 = findViewById(R.id.textView_Result2);

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
