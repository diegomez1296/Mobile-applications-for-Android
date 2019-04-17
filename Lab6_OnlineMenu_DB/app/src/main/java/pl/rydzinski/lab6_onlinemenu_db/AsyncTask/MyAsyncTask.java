package pl.rydzinski.lab6_onlinemenu_db.AsyncTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;
import android.util.TimingLogger;
import android.widget.Toast;

import pl.rydzinski.lab6_onlinemenu_db.OnlineMenuDatabaseHelper;

public class MyAsyncTask extends AsyncTask<Integer, Void, Boolean> {

    private String name;
    private String amount;
    Context context;
    ContentValues newItem;

    public MyAsyncTask(String name, String amount, Context context) {
        this.name = name;
        this.amount = amount;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        newItem = new ContentValues();

        newItem.put("NAME", name);
        newItem.put("AMOUNT", amount);
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {

        try {
            double start = System.currentTimeMillis();

            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(context);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            db.insert("AORDER", null, newItem);
            double end = System.currentTimeMillis() - start;
            Log.e("TIME", "doInBackground: " + end+"msek"); //10 msek
            return true;

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(context, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        if (aBoolean) {
            Toast toast = Toast.makeText(context, "Your order is in progress", Toast.LENGTH_SHORT);
            toast.show();
        }
    }





}
