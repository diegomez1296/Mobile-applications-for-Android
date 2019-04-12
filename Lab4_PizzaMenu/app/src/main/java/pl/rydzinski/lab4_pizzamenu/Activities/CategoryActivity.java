package pl.rydzinski.lab4_pizzamenu.Activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pl.rydzinski.lab4_pizzamenu.DAO.Drink;
import pl.rydzinski.lab4_pizzamenu.DAO.Other;
import pl.rydzinski.lab4_pizzamenu.DAO.Pizza;

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
                ArrayAdapter<Pizza> listAdapter_Pizza = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Pizza.pizzas);
                list.setAdapter(listAdapter_Pizza);
                break;
            case "DRINK":
                ArrayAdapter<Drink> listAdapter_Drink = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
                list.setAdapter(listAdapter_Drink);
                break;
            case "OTHER":
                ArrayAdapter<Other> listAdapter_Other = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Other.others);
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

}
