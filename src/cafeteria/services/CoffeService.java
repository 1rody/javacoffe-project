package cafeteria.services;

import cafeteria.entities.Coffee;

import java.util.ArrayList;

public class CoffeService {
    private ArrayList<Coffee> coffees = new ArrayList<>();

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }
    public boolean removeCoffee(String name) {
        return coffees.removeIf(e -> e.getCoffeename().equals(name));
    }
}
