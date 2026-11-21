package cafeteria.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private Client client;
    private List<Coffee> Coffees =  new ArrayList<>();


    public Order() {};

    public Order(Integer id, Client client) {
        this.id = id;
        this.client = client;
    }

    public void addCoffe(Coffee coffee) {
        Coffees.add(coffee);

    }
    public void removeCoffe(Coffee coffee) {
        Coffees.remove(coffee);
    }

    public Double Total() {
        double totals = 0.0;
        for(Coffee c : Coffees) {
            totals += c.getPrice();
        }
        return totals;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Coffee> getCoffees() {
        return Coffees;
    }
}
