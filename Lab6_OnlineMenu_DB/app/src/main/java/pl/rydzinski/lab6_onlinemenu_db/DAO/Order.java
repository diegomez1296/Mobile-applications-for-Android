package pl.rydzinski.lab6_onlinemenu_db.DAO;

public class Order {

    private int id;
    private String name;
    private String amount;

    public Order(int id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + name + " " + "Amount: " + amount;
    }
}
