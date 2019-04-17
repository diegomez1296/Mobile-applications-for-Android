package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.rydzinski.lab6_onlinemenu_db.DAO.Food;
import pl.rydzinski.lab6_onlinemenu_db.OnlineMenuDatabaseHelper;
import pl.rydzinski.lab6_onlinemenu_db.R;


public class DetailsActivity extends ToolbarCreator {

    private String getCategory;
    private int getId;

    private ImageView imageView_Photo;
    private TextView textView_Name;
    private TextView textView_Description;
    private TextView textView_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setIdMenu(R.menu.submit_menu);
        setThisActivity(DetailsActivity.this);

        getCategory = getIntent().getStringExtra("category");
        getId = getIntent().getIntExtra("id", 0);

        imageView_Photo = findViewById(R.id.photo);
        textView_Name = findViewById(R.id.name);
        textView_Description = findViewById(R.id.description);
        textView_Price = findViewById(R.id.price);

        Food food = getFoodFromDB(getCategory, getId+1);
        setContentOfProduct(food);
    }

    private void setContentOfProduct(Food food) {
        imageView_Photo.setImageResource(food.getImageResourceId());
        imageView_Photo.setContentDescription(food.getName());
        textView_Name.setText(food.getName());
        textView_Description.setText(food.getDescription());
        textView_Price.setText(getString(R.string.AppCurrency) + food.getPrice());

        //Submit
        setFoodName(food.getName());
    }

    public Food getFoodFromDB(String nameTable, int foodId) {
        try {
            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.query(nameTable,
                    new String[]{"NAME", "DESCRIPTION", "PRICE", "IMAGE_RESOURCE_ID"},
                    "_id = ?", new String[]{Integer.toString(foodId)},
                    null, null, null);

            cursor.moveToFirst();

            return new Food(cursor.getString(0), cursor.getString(1), cursor.getFloat(2), cursor.getInt(3));

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        return new Food("", "", 0.0f, 0);

    }
}
