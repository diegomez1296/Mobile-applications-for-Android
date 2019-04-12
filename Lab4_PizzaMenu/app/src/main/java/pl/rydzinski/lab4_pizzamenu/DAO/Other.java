package pl.rydzinski.lab4_pizzamenu.DAO;

import pl.rydzinski.lab4_pizzamenu.R;

public class Other extends Food {

    public Other(String name, String description, Float price, int imageResourceId) {
        super(name, description, price, imageResourceId);
    }

    public static final Other[] others = {
            new Other("Nick Nacks (15g)", "Double-Crunch Peanuts.",
                    0.99f, R.drawable.nicn),
            new Other("Oreo", "Oreo is a brand of cookie usually consisting of two chocolate wafers with a sweet crème filling, marketed as \"Chocolate Sandwich Cookie\".",
                    2.99f, R.drawable.oreo)
    };
}
