package pl.rydzinski.lab6_onlinemenu_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OnlineMenuDatabaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "OnlineMenuDB";
    private static int DB_VERSION = 1;

    public OnlineMenuDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        db.execSQL(createTable("PIZZA"));
        db.execSQL(createTable("DRINK"));
        db.execSQL(createTable("OTHER"));

        //Insert Items
        db.insert("PIZZA", null,
                createItem("Chicken Supreme", "With Tomato Sauce, Chicken Meat, Chicken Salami, Chicken Loaf, Mushrooms, Capsicums, Onions, Mozzarella Cheese.",
                11.99f, R.drawable.chicken_supreme));
        db.insert("PIZZA", null,
                createItem("Hawaiian Supreme", "With Tomato Sauce, Chicken Meat, Chicken Loaf, Pineapples, Mozzarella Cheese.",
                        14.99f, R.drawable.hawaiian_supreme));
        db.insert("PIZZA", null,
                createItem("Island Supreme", "With Thousand Island Sauce, Crabsticks, Tuna, Pineapples, Onions, Mozzarella Cheese.",
                        16.99f, R.drawable.island_supreme));

        db.insert("DRINK", null,
                createItem("Cuba Libre", "Cuba Libre is a highball cocktail consisting of cola, rum, and in many recipes lime juice on ice.",
                        6.99f, R.drawable.cubalibre));
        db.insert("DRINK", null,
                createItem("Mojito", "Mojito is a cocktail that consists of five ingredients: white rum, sugar, lime juice, soda water, and mint.",
                        7.99f, R.drawable.mojito));
        db.insert("DRINK", null,
                createItem("#Zółte Najlepsze", "Created with the help of God.",
                        999.99f, R.drawable.godgold));

        db.insert("OTHER", null,
                createItem("Nick Nacks (15g)", "Double-Crunch Peanuts.",
                        0.99f, R.drawable.nicn));
        db.insert("OTHER", null,
                createItem("Oreo", "Oreo is a brand of cookie usually consisting of two chocolate wafers with a sweet crème filling, marketed as \"Chocolate Sandwich Cookie\".",
                        2.99f, R.drawable.oreo));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createTable(String nameTable) {
         return "CREATE TABLE "+nameTable+" (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "PRICE REAL, "
                + "IMAGE_RESOURCE_ID INTEGER);";
    }

    private ContentValues createItem(String name, String description, float price, int imageResId) {
        ContentValues newItem = new ContentValues();

        newItem.put("NAME", name);
        newItem.put("DESCRIPTION", description);
        newItem.put("PRICE", price);
        newItem.put("IMAGE_RESOURCE_ID", imageResId);

        return newItem;
    }

}
