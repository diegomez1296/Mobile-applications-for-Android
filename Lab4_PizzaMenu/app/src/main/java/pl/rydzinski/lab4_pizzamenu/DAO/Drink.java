package pl.rydzinski.lab4_pizzamenu.DAO;

import pl.rydzinski.lab4_pizzamenu.R;

public class Drink extends Food {

    public Drink(String name, String description, Float price, int imageResourceId) {
        super(name, description, price, imageResourceId);
    }

    public static final Drink[] drinks = {
            new Drink("Cuba Libre", "Cuba Libre is a highball cocktail consisting of cola, rum, and in many recipes lime juice on ice.",
                    6.99f, R.drawable.cubalibre),
            new Drink("Mojito", "Mojito is a cocktail that consists of five ingredients: white rum, sugar, lime juice, soda water, and mint.",
                    7.99f, R.drawable.mojito),
            new Drink("#Zółte Najlepsze", "Created with the help of God.",
                    999.99f, R.drawable.godgold)
    };
}
