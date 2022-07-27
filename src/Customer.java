import java.util.ArrayList;

public class Customer extends BankingSystem {
    // customer can have any number of accounts
    ArrayList<Account> accounts = new ArrayList<>();

    // instance field
    private String name;
    private int id;

    // default constructor
    public Customer () {

    }
    public Customer (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
