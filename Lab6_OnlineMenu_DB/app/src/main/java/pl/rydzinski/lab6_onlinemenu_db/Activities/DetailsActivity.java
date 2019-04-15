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

    private ImageView ImageView_Photo;
    private TextView TextView_Name;
    private TextView TextView_Description;
    private TextView TextView_Price;

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

        ImageView_Photo = findViewById(R.id.photo);
        TextView_Name = findViewById(R.id.name);
        TextView_Description = findViewById(R.id.description);
        TextView_Price = findViewById(R.id.price);

        Food food = getFoodFromDB(getCategory, getId+1);
        setContentOfProduct(food);
    }

    private void setContentOfProduct(Food food) {
        ImageView_Photo.setImageResource(food.getImageResourceId());
        ImageView_Photo.setContentDescription(food.getName());
        TextView_Name.setText(food.getName());
        TextView_Description.setText(food.getDescription());
        TextView_Price.setText(getString(R.string.AppCurrency) + food.getPrice());

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
