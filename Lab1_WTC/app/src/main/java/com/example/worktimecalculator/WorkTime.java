package com.example.worktimecalculator;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkTime extends AppCompatActivity {

    public final static int MINUTE_MILLIS = 60 * 1000;
    public final static int HOUR_MILLIS = MINUTE_MILLIS * 60;
    public final static int DAY_MILLIS = HOUR_MILLIS * 24;

    private static int h;
    private static int m;

    public String getWorkTime(Editable startTime, Editable endTime) throws ParseException {

        try {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date date1 = dateFormat.parse(startTime.toString());
            Date date2 = dateFormat.parse(endTime.toString());
            long difference = date2.getTime() - date1.getTime();
            // if negative, means we have want to flip to another day
            if (difference < 0) {
                difference += DAY_MILLIS;
            }
            h = (int) difference / HOUR_MILLIS;
            m = (int) (difference - (h * HOUR_MILLIS)) / MINUTE_MILLIS;
            //Log.d("startTime",h + ":" + m);


            //Resources resources = getResources();
            //Log.d("SS", resources.getString(R.string.app_numberOfH));
            return "Hours:  " + h + "  ||  " + "Minutes:  " + m;
        } catch (Exception e) {
            h = 0;
            m = 0;
            return "Invalid time format. Try \"HH:mm\"";
        }

    }

    public String getFraction() {
        float fraction = 0.0f;
        fraction +=h;
        fraction += ((float)m/60);
        NumberFormat numberFormat = new DecimalFormat("#0.000");
        return "In fractional:  " + String.valueOf(numberFormat.format(fraction));
    }
}
