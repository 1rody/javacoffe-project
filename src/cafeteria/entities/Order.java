package cafeteria.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private Client client;
    private List<Coffee> coffees =  new ArrayList<>();


    public Order() {}

    public Order(Integer id, Client client) {
        this.id = id;
        this.client = client;
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);

    }
    public void removeCoffee(Coffee coffee) {
        coffees.remove(coffee);
    }

    public Double total() {
        double totals = 0.0;
        for(Coffee c : coffees) {
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
        return coffees;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client.getName() +
                ", Coffees=" + coffees +
                '}';
    }
}
