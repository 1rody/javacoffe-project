package cafeteria.entities;

import java.util.ArrayList;
import java.util.List;

/** Pedido: tem um {@link Client} e uma lista de {@link Coffee} (composição). */
public class Order {
    private Integer id;
    private Client client;
    private List<Coffee> coffees =  new ArrayList<>();


    /** Cria o pedido vazio. */
    public Order() {}

    /** Cria o pedido com ID e cliente. */
    public Order(Integer id, Client client) {
        this.id = id;
        this.client = client;
    }

    /** Adiciona um café ao pedido. */
    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);

    }
    /** Remove um café do pedido. */
    public void removeCoffee(Coffee coffee) {
        coffees.remove(coffee);
    }

    /** Retorna a soma dos preços dos cafés do pedido. */
    public Double total() {
        double totals = 0.0;
        for(Coffee c : coffees) {
            totals += c.getPrice();
        }
        return totals;
    }

    /** Retorna o ID. */
    public Integer getId() {
        return id;
    }

    /** Retorna o cliente. */
    public Client getClient() {
        return client;
    }

    /** Retorna os cafés do pedido. */
    public List<Coffee> getCoffees() {
        return coffees;
    }

    /** Resume o pedido em texto. */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client.getName() +
                ", Coffees=" + coffees +
                '}';
    }
}
