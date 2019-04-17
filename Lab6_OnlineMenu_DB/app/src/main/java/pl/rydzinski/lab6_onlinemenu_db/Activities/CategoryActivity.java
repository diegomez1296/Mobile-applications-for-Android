package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.TimingLogger;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pl.rydzinski.lab6_onlinemenu_db.DAO.Food;
import pl.rydzinski.lab6_onlinemenu_db.OnlineMenuDatabaseHelper;

public class CategoryActivity extends ListActivity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        category = getIntent().getStringExtra("category");

        setAdapter();

    }

    private void setAdapter() {

        ListView list = getListView();

        switch (category) {
            case "PIZZA":
                ArrayAdapter<Food> listAdapter_Pizza = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getFoodNamesFromDB("PIZZA"));
                list.setAdapter(listAdapter_Pizza);
                break;
            case "DRINK":
                ArrayAdapter<Food> listAdapter_Drink = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getFoodNamesFromDB("DRINK"));
                list.setAdapter(listAdapter_Drink);
                break;
            case "OTHER":
                ArrayAdapter<Food> listAdapter_Other = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getFoodNamesFromDB("OTHER"));
                list.setAdapter(listAdapter_Other);
                break;
        }
    }

    @Override
    protected void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(CategoryActivity.this, DetailsActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("id", (int) id);
        startActivity(intent);
    }

    public Food[] getFoodNamesFromDB(String nameTable) {
        try {
            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.query(nameTable,
                    new String[]{"NAME"},
                    null, null,
                    null, null, null);

            Food[] foods = new Food[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < foods.length; i++) {
                foods[i] = new Food(cursor.getString(0));
                cursor.moveToNext();
            }
            return foods;

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        return new Food[] {new Food("")};
    }
}
