
//classe Programa, serve como main
package cafeteria;

import cafeteria.services.ClientService;
import cafeteria.services.CoffeService;
import cafeteria.services.EmployeeService;
import cafeteria.services.OrderService;
import cafeteria.view.Menu;

/**
 * Sistema de console da cafeteria "The Best Coffe": gerencia equipe, cardápio, clientes e pedidos
 * (cadastrar, alterar, remover e listar). Os dados ficam só em memória.
 */
public class Programa {
    /** Cria os services e os injeta no Menu, que conduz o programa. */
    public static void main(String[] args) {

        //cria os services e os injeta no Menu (injeção de dependência)
        EmployeeService employeeService = new EmployeeService();
        ClientService clientService = new ClientService();
        OrderService orderService = new OrderService();
        CoffeService coffeService = new CoffeService();

        Menu menu = new Menu(employeeService, clientService, orderService, coffeService);
        menu.start();
    }
}