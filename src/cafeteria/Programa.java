package cafeteria;
import cafeteria.entities.Order;
import cafeteria.services.ClientService;
import cafeteria.services.CoffeService;
import cafeteria.services.EmployeeService;
import cafeteria.services.OrderService;
import cafeteria.view.Menu;

public class Programa {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        ClientService clientService = new ClientService();
        OrderService orderService = new OrderService();
        CoffeService coffeService = new CoffeService();

        Order o1 = new Order(1, clientService.getClients().get(0));
        o1.addCoffee(coffeService.getCoffees().get(0));
        orderService.addOrder(o1);

        Order o2 = new Order(2, clientService.getClients().get(1));
        o2.addCoffee(coffeService.getCoffees().get(1));
        orderService.addOrder(o2);

        Order o3 = new Order(3, clientService.getClients().get(2));
        o3.addCoffee(coffeService.getCoffees().get(2));
        orderService.addOrder(o3);

        Order o4 = new Order(4, clientService.getClients().get(3));
        o4.addCoffee(coffeService.getCoffees().get(3));
        orderService.addOrder(o4);

        Order o5 = new Order(5, clientService.getClients().get(4));
        o5.addCoffee(coffeService.getCoffees().get(4));
        orderService.addOrder(o5);

        Order o6 = new Order(6, clientService.getClients().get(5));
        o6.addCoffee(coffeService.getCoffees().get(5));
        orderService.addOrder(o6);

        Order o7 = new Order(7, clientService.getClients().get(6));
        o7.addCoffee(coffeService.getCoffees().get(6));
        orderService.addOrder(o7);


        Menu menu = new Menu(employeeService, clientService, orderService, coffeService);
        menu.start();
    }
}