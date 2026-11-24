package cafeteria.services;

import java.util.ArrayList;
import java.util.Comparator;

import cafeteria.entities.Order;
import cafeteria.entities.Coffee;

public class OrderService{
	private ArrayList <Order> orders = new ArrayList<>();

	//adicionar no array
	public void addOrder(Order order){
		orders.add(order);
	}

	//remover do array
	public boolean removeOrder(Integer id){
		return orders.removeIf(order -> order.getId().equals(id));
	}

	//pesquisar no array
	public Order orderSearch(Integer id){
		for (Order order: orders){
			if(order.getId().equals(id)){
				return order;
			}
		}
		return null;
	}

	// get do awway
	public ArrayList<Order> getOrders(){
		return orders;
	}

	public ArrayList<Order> getOrdersSorted(){
		ArrayList<Order> sorted = new ArrayList<>(orders); //copia da lista original
		sorted.sort(Comparator.comparingDouble(o -> o.total())); //ordena pelo valor total do pedido
		return sorted;
	}

	public boolean updateOrderCoffee(Integer id, Coffee newCoffee){
		Order order = orderSearch(id);
		if (order == null) {
			return false; //nao achou o pedido
		}
		order.getCoffees().clear(); //remove os cafes antigos
		order.addCoffee(newCoffee); //adiciona o novo
		return true;
	}
}