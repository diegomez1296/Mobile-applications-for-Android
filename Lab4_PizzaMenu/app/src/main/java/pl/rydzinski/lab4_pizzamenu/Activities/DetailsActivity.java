package pl.rydzinski.lab4_pizzamenu.Activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pl.rydzinski.lab4_pizzamenu.DAO.Drink;
import pl.rydzinski.lab4_pizzamenu.DAO.Food;
import pl.rydzinski.lab4_pizzamenu.DAO.Other;
import pl.rydzinski.lab4_pizzamenu.DAO.Pizza;
import pl.rydzinski.lab4_pizzamenu.R;

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

        getInfoAboutProduct();
    }

    private void getInfoAboutProduct() {

        switch (getCategory) {
            case "PIZZA":
                Food foodP = Pizza.pizzas[getId];
                setContentOfProduct(foodP);
                break;
            case "DRINK":
                Food foodD = Drink.drinks[getId];
                setContentOfProduct(foodD);
                break;
            case "OTHER":
                Food foodO = Other.others[getId];
                setContentOfProduct(foodO);
                break;
        }
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
}
