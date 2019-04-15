package pl.rydzinski.lab6_onlinemenu_db.DAO;

public class Food {

    private String name;
    private String description;
    private float price;
    private int imageResourceId;

    public Food(String name, String description, float price, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return name;
    }
}
