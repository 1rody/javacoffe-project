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
		for (Order order: orders){
			if (order.getId().equals(id)){
				orders.remove(order);
				return true;
			}
		}
		return false;
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