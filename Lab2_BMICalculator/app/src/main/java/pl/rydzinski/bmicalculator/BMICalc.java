package pl.rydzinski.bmicalculator;

import android.content.Context;
import android.util.Log;

public class BMICalc {

    private Context context;

    public BMICalc(Context context) {
        this.context = context;
    }

    public float getBMI (float mass, float height) {
        return mass / (height/100 * height/100);
    }

    public String getDescription(float bmi) {

        if(bmi < 16.0f) return context.getString(R.string.app_BMI_UnderWeight_III);
        if(bmi < 16.99f) return context.getString(R.string.app_BMI_UnderWeight_II);
        if(bmi < 18.49f) return context.getString(R.string.app_BMI_UnderWeight_I);
        if(bmi < 24.99f) return context.getString(R.string.app_BMI_NormalWeight);
        if(bmi < 29.99f) return context.getString(R.string.app_BMI_ObeseWeight_I);
        if(bmi < 34.99f) return context.getString(R.string.app_BMI_ObeseWeight_II);
        if(bmi < 39.99f) return context.getString(R.string.app_BMI_ObeseWeight_III);
        return context.getString(R.string.app_BMI_ObeseWeight_IV);
    }

    public int getBMIColor(float bmi) {
        if(bmi < 16.0f) return context.getResources().getColor(R.color.colorBMIRed);
        if(bmi < 16.99f) return context.getResources().getColor(R.color.colorBMIOrange);
        if(bmi < 18.49f) return context.getResources().getColor(R.color.colorBMIYellow);
        if(bmi < 24.99f) return context.getResources().getColor(R.color.colorBMIGreen);
        if(bmi < 29.99f) return context.getResources().getColor(R.color.colorBMIYellow);
        if(bmi < 34.99f) return context.getResources().getColor(R.color.colorBMIOrange);
        if(bmi < 39.99f) return context.getResources().getColor(R.color.colorBMIRed);
        return context.getResources().getColor(R.color.colorBMIBloody);
    }
}
        /*

    mniej niż 16 - wygłodzenie          czerwony #cc160d
    16 - 16.99 - wychudzenie            pomarańczowy #cc920d
    17 - 18.49 - niedowaga              zółty  #c2cc0d
    18.5 - 24.99 - wartość prawidłowa - zielony #1ecc0e
    25 - 29.99 - nadwaga                zółty
    30 - 34.99 - I stopień otyłości     pomarańczowy
    35 - 39.99 - II stopień otyłości    czerwony
    powyżej 40 - otyłość skrajna        krwawy  #820303

                                        FROM TO
Very severely underweight 		             less than 16
Severely underweight 	                16 - 16.99
Underweight 	                        17 - 18.49
Normal (healthy weight) 	            18.5 - 24.99
Overweight 	                            25 - 29.99
Obese Class I (Moderately obese) 	    30 - 34.99
Obese Class II (Severely obese) 	    35 - 39.99
Obese Class III (Very severely obese) 	more than 40

         */