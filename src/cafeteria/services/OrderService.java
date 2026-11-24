package cafeteria.services;

import java.util.ArrayList;
import java.util.Comparator;

import cafeteria.entities.Order;
import cafeteria.entities.Coffee;

/** Serviço de pedidos: lista em memória com cadastro, remoção, busca, listagem e troca de café. */
public class OrderService{
	private ArrayList <Order> orders = new ArrayList<>();

	/** Adiciona um pedido. */
	public void addOrder(Order order){
		orders.add(order);
	}

	/** Remove o pedido pelo ID; retorna true se removeu. */
	public boolean removeOrder(Integer id){
		return orders.removeIf(order -> order.getId().equals(id));
	}

	/** Busca pelo ID; retorna null se não achar. */
	public Order orderSearch(Integer id){
		for (Order order: orders){
			if(order.getId().equals(id)){
				return order;
			}
		}
		return null;
	}

	/** Retorna os pedidos na ordem de cadastro. */
	public ArrayList<Order> getOrders(){
		return orders;
	}

	/** Retorna uma cópia ordenada pelo total. */
	public ArrayList<Order> getOrdersSorted(){
		ArrayList<Order> sorted = new ArrayList<>(orders); //copia da lista original
		sorted.sort(Comparator.comparingDouble(o -> o.total())); //ordena pelo valor total do pedido
		return sorted;
	}

	/** Troca o café do pedido pelo novo; retorna false se não achar o pedido. */
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