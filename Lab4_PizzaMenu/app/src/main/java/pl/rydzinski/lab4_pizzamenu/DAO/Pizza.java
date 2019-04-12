package pl.rydzinski.lab4_pizzamenu.DAO;

import pl.rydzinski.lab4_pizzamenu.R;

public class Pizza extends Food {

    public Pizza(String name, String description, Float price, int imageResourceId) {
        super(name, description, price, imageResourceId);
    }

    public static final Pizza[] pizzas = {
            new Pizza("Chicken Supreme", "With Tomato Sauce, Chicken Meat, Chicken Salami, Chicken Loaf, Mushrooms, Capsicums, Onions, Mozzarella Cheese.",
                    11.99f, R.drawable.chicken_supreme),
            new Pizza("Hawaiian Supreme", "With Tomato Sauce, Chicken Meat, Chicken Loaf, Pineapples, Mozzarella Cheese.",
                    14.99f, R.drawable.hawaiian_supreme),
            new Pizza("Island Supreme", "With Thousand Island Sauce, Crabsticks, Tuna, Pineapples, Onions, Mozzarella Cheese.",
                    16.99f, R.drawable.island_supreme)
    };

}
