package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimingLogger;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pl.rydzinski.lab6_onlinemenu_db.DAO.Food;
import pl.rydzinski.lab6_onlinemenu_db.DAO.Order;
import pl.rydzinski.lab6_onlinemenu_db.OnlineMenuDatabaseHelper;
import pl.rydzinski.lab6_onlinemenu_db.R;

public class OrderActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView list = getListView();
        ArrayAdapter<Order> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getOrdersFromDB());
        list.setAdapter(listAdapter);
    }

    public Order[] getOrdersFromDB() {
        try {
            double start = System.currentTimeMillis();
            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getWritableDatabase();

            Cursor cursor = db.query("AORDER",
                    new String[]{"_id", "NAME", "AMOUNT"},
                    null, null,
                    null, null, null);

            cursor.moveToFirst();

            Order[] orders = new Order[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < orders.length; i++) {
                orders[i] = new Order(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                cursor.moveToNext();
            }
            double end = System.currentTimeMillis() - start;
            Log.e("TIME", "GetOrdersFromDB: " + end+"msek"); //6 msek
            return orders;


        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
            return new Order[]{};
        }
    }
}
