package cafeteria.services;

import java.util.ArrayList;
import cafeteria.entities.Order;

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
}