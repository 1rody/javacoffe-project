package cafeteria;

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

        Menu menu = new Menu(employeeService, clientService, orderService, coffeService);
        menu.start();
    }
}