package cafeteria.view;

import cafeteria.entities.Client;
import cafeteria.entities.Coffee;
import cafeteria.entities.Employee;
import cafeteria.entities.ExternalEmployee;
import cafeteria.entities.Order;
import cafeteria.services.ClientService;
import cafeteria.services.CoffeService;
import cafeteria.services.EmployeeService;
import cafeteria.services.OrderService;
import java.util.Scanner;
import java.util.List;

public class Menu {
    //scanner do menu privado
    private Scanner sc = new Scanner(System.in);

    private EmployeeService employeeService = new EmployeeService();
    private ClientService clientService = new ClientService();
    private OrderService orderService = new OrderService();
    private CoffeService coffeService = new CoffeService();

    //diferente de main aqui a cafeteria ja foi criada
    public void start() {
        int option;

        do {
            //codigo para ir ao menu
            System.out.println("=====THE BEST COFFE=====");
            System.out.println("Digite a opcao para entrar no sistema");
            System.out.println("1- Gestao da equipe");
            System.out.println("2- Cadastro de cliente");
            System.out.println("3- Atendimento");
            System.out.println("0- Sair");

            option = sc.nextInt();

            switch (option) {
                case 1 -> employeeMenu();
                case 2 -> clientMenu();
                case 3 -> orderMenu();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (option != 0);
    }
    private void employeeMenu() {
        int password;
        System.out.println("=====THE BEST COFFE STAFF=====");
        System.out.println("Insira a senha local para login");
        password = sc.nextInt();

        while(password != 12345) {
            System.out.println("Senha invalida favor tente novamente!");
            password = sc.nextInt();
        };

        System.out.println("=====THE BEST COFFE STAFF =====");
        System.out.println("Digite a opção para realizar a ação");

        System.out.println("1- Cadastro de funcionários");
        System.out.println("2- Remoção de funcionários");
        System.out.println("3- Lista de funcionários");
        System.out.println("4- Cadastro dos cafés");
        System.out.println("0- Sair");

        int secondSelection;
        int thirdSelection;
        secondSelection = sc.nextInt();

        switch (secondSelection) {
            case 1:

                System.out.println("Cadastro de funcionários:");
                System.out.println("1- Cadastro de funcionários");
                System.out.println("2- Cadastro de funcionários Terceirizados");
                thirdSelection = sc.nextInt();

                switch (thirdSelection) {
                    case 1:
                        System.out.println(" Cadastro de funcionário CLT");

                        sc.nextLine();
                        System.out.print("Nome: ");
                        String name = sc.nextLine();
                        System.out.print("E-Mail: ");
                        String email = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Cargo: ");
                        String occupation = sc.nextLine();
                        System.out.print("Salário: ");
                        double salary = sc.nextDouble();

                        Employee employee = new Employee(name, email, cpf, id, occupation, salary);
                        employeeService.addEmployee(employee);
                        System.out.println("Funcionário cadastrado!");
                        break;
                    case 2:
                        System.out.println(" Cadastro de funcionário Terceirizado");
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String tname = sc.nextLine();
                        System.out.print("E-Mail: ");
                        String temail = sc.nextLine();
                        System.out.print("CPF: ");
                        String tcpf = sc.nextLine();
                        System.out.print("ID: ");
                        int tid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Cargo: ");
                        String toccupation = sc.nextLine();
                        System.out.print("Salário: ");
                        double tsalary = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Empresa: ");
                        String company = sc.nextLine();
                        System.out.print("Valor da hora: ");
                        double hourValue = sc.nextDouble();
                        System.out.print("Horas trabalhadas: ");
                        double hourWorked = sc.nextDouble();

                        ExternalEmployee tEmployee = new ExternalEmployee(tname, temail, tcpf, tid, toccupation, tsalary, company, hourValue, hourWorked);
                        employeeService.addEmployee(tEmployee);
                        System.out.println("Funcionário terceirizado cadastrado!");
                        break;

                }
            break;
            case 2:
                System.out.print("REMOÇÃO DE FUNCIONÁRIO ");
                sc.nextLine();
                System.out.print("CPF do funcionário: ");
                String cpf = sc.nextLine();

                if (employeeService.removeEmployee(cpf)) {
                    System.out.println("Funcionário removido!");
                } else {
                    System.out.println("Funcionário nao encontrado!");
                }
                break;
            case 3:
                System.out.println("=====LISTA DE FUNCIONÁRIOS=====");
                if (employeeService.getEmployees().isEmpty()) {
                    System.out.println("Nenhum funcionário cadastrado!");
                } else {
                    System.out.println("\nExibindo os funcionários...\n");
                    for (Employee emp : employeeService.getEmployees()) {
                        System.out.println("| Nome: " + emp.getName());
                        System.out.println("| E-Mail: " + emp.getEmail());
                        System.out.println("| CPF: " + emp.getCpf());
                        System.out.println("| ID: " + emp.getId());
                        System.out.println("| Cargo: " + emp.getOccupation());

                        if (emp instanceof ExternalEmployee) {
                            ExternalEmployee external = (ExternalEmployee) emp;
                            System.out.println("| Tipo: Terceirizado");
                            System.out.println("| Empresa: " + external.getCompanyName());
                            System.out.println("| Valor da hora: R$ " + String.format("%.2f", external.getHourValue()));
                            System.out.println("| Horas trabalhadas: " + external.getHourWorked());
                        } else {
                            System.out.println("| Tipo: CLT");
                        }

                        System.out.println("| Pagamento: R$ " + String.format("%.2f", emp.calculatePayment()) + "\n");
                    }
                }
                break;
            case 4:
                System.out.println(" Cadastro de items ao menu");
                sc.nextLine();
                System.out.print("Nome do CAFÉ: ");
                String coffeName = sc.nextLine();

                if (coffeService.searchCoffee(coffeName) != null) {
                    System.out.println("Café já cadastrado!");
                    break;
                }

                System.out.print("Descrição: ");
                String coffeDescription = sc.nextLine();
                System.out.print("Preço: ");
                double coffePrice = sc.nextDouble();
                sc.nextLine();
                System.out.print("Contém lactose: (s/n)");
                boolean coffeLactose = sc.nextLine().equalsIgnoreCase("s");

                //cria o novo cafe
                Coffee coffee = new Coffee(coffeName, coffePrice, coffeDescription, coffeLactose);
                //adiciona o novo cafe
                coffeService.addCoffee(coffee);

                System.out.println(" Café cadastrado!");
                break;

        }

        if (secondSelection >= 5) {
            System.out.println("Opcao invalida favor tente novamente!");
        }

    }
    private  void clientMenu() {
        int secondSelection;
        //precisa n so criei a senha de ex pra validar o menu de funcionario

        System.out.println("Digite a opcao para realizar a acao");

        System.out.println("1- Cadastro de cliente");
        System.out.println("2- Remocao de cliente");
        System.out.println("3- Lista de clientes");
        System.out.println("0- Sair");

        secondSelection=sc.nextInt();
        sc.nextLine();

        switch (secondSelection){
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.println("=====CADASTRO DE CLIENTE======");
                System.out.print("Nome: ");
                String name=sc.nextLine();

                System.out.print("\nE-Mail: ");
                String email=sc.nextLine();

                System.out.print("\nCPF: ");
                String cpf=sc.nextLine();

                Client client = new Client(name, email, cpf);
                clientService.addClient(client);
                break;
            case 2:
                System.out.println("=====REMOCAO DE CLIENTE=====");

                System.out.print("Digite o CPF do cliente: ");
                String cpfClient;
                do {
                    cpfClient =sc.nextLine();
                    if(clientService.removeClient(cpfClient)){
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.print("\nCliente nao encontrado\nTente novamente:");
                    }
                } while(!clientService.removeClient(cpfClient));
                break;
            case 3:
                System.out.println("=====LISTA DE CLIENTES=====");
                if (clientService.getClients().isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado!");
                } else {
                    System.out.println("\nExibindo os clientes...\n");
                    for (Client c : clientService.getClients()) {
                        System.out.println("Nome: " + c.getName());
                        System.out.println("E-Mail: " + c.getEmail());
                        System.out.println("CPF: " + c.getCpf() + "\n");
                    }
                }
                break;
            default:
                System.out.println("Opcao invalida!");
                System.out.println("Digite 1, 2, 3 ou 0 para sair");
                break;

        }
    }

    private  void orderMenu() {
        int secondSelection;
        System.out.println("=====MENU DE ATENDIMENTO=====");

        System.out.println("Digite um valor abaixo para realizar a tarefa:");
        System.out.println("1. Novo pedido");
        System.out.println("2. Remover pedido");
        System.out.println("3. Ver um pedido e total");
        System.out.println("4. Listar todos os pedidos");
        System.out.println("5. Voltar");

        secondSelection = sc.nextInt();
        sc.nextLine();

        String coffeename;
        int sclactose;
        boolean lactose = false;
        switch (secondSelection) {
            case 1:
                System.out.println("\nCriando pedido...");
                System.out.print("ID do pedido: ");
                int orderId = sc.nextInt();
                sc.nextLine();

                Client orderClient = null;
                List<Client> registeredClients = clientService.getClients();

                if (!registeredClients.isEmpty()) {
                    System.out.println("\nClientes cadastrados:");
                    for (int i = 0; i < registeredClients.size(); i++) {
                        Client c = registeredClients.get(i);
                        System.out.println((i + 1) + "- " + c.getName() + " (CPF: " + c.getCpf() + ")");
                    }
                    int newClientOption = registeredClients.size() + 1;
                    System.out.println(newClientOption + "- Cadastrar novo cliente");
                    System.out.print("Digite a opção: ");
                    int clientOption = sc.nextInt();
                    sc.nextLine();
                    while (clientOption < 1 || clientOption > newClientOption) {
                        System.out.println("Valor inválido! Digite um valor entre 1 e " + newClientOption + ".");
                        clientOption = sc.nextInt();
                        sc.nextLine();
                    }
                    if (clientOption != newClientOption) {
                        orderClient = registeredClients.get(clientOption - 1);
                    }
                }

                if (orderClient == null) {
                    System.out.println("\nCadastro de novo cliente:");
                    System.out.print("Nome do cliente: ");
                    String clientName = sc.nextLine();
                    System.out.print("E-Mail: ");
                    String clientEmail = sc.nextLine();
                    System.out.print("CPF: ");
                    String clientCpf = sc.nextLine();

                    orderClient = new Client(clientName, clientEmail, clientCpf);
                    clientService.addClient(orderClient);
                }

                Order newOrder = new Order(orderId, orderClient);

                System.out.println("Indo para a seção de produtos...");
                System.out.println("\nExibindo os produtos...\n");
                System.out.println("| Tipos disponíveis:");
                for (Coffee item : coffeService.getCoffees()) {
                    System.out.println("| " + item.getCoffeename() + " - R$ " + String.format("%.2f", item.getPrice()));
                }

                Coffee selected = null;
                while (selected == null) {
                    System.out.println("\n> Digite o nome do café selecionado:\n");
                    coffeename = sc.nextLine();
                    selected = coffeService.searchCoffee(coffeename);
                    if (selected == null) {
                        System.out.println("Erro: <Nenhum tipo válido>\n");
                    }
                }
                System.out.println("\n| Descrição: " + selected.getDescription());

                System.out.println("\nPossui intolerância à lactose?\n1- Possuo.\n0- Não possuo.");
                sclactose = sc.nextInt();
                sc.nextLine();
                while (sclactose != 0 && sclactose != 1) {
                    System.out.println("Valor inválido! Digite 0 ou 1.");
                    sclactose = sc.nextInt();
                    sc.nextLine();
                }
                lactose = (sclactose == 1);

                //copia do item do cardápio, para a lactose do cliente não alterar o cadastro do café
                Coffee coffe = new Coffee(selected.getCoffeename(), selected.getPrice(), selected.getDescription(), lactose);
                if (lactose && selected.getLactose()) {
                    System.out.println("|Atenção: este café contém lactose!");
                }
                System.out.println(coffe.statusLactose(lactose));
                System.out.println(coffe.toString());

                newOrder.addCoffee(coffe);
                orderService.addOrder(newOrder);
                System.out.println("\nPedido criado!");
                break;
            case 2:
                System.out.println("Qual o id do pedido que deseja remover?");
                System.out.print("ID do pedido: ");
                Integer id = sc.nextInt();
                sc.nextLine();
                if (orderService.removeOrder(id)) {
                    System.out.println("Pedido removido!");
                } else {
                    System.out.println("Pedido não encontrado!");
                }
                break;
            case 3:
                System.out.println("=====VER PEDIDO E TOTAL=====");
                System.out.print("ID do pedido: ");
                Integer searchId = sc.nextInt();
                sc.nextLine();

                Order foundOrder = orderService.orderSearch(searchId);
                if (foundOrder == null) {
                    System.out.println("Pedido não encontrado!");
                } else {
                    System.out.println("\nExibindo pedido...\n");
                    System.out.println(foundOrder.toString());
                    System.out.println("\n Total do pedido: R$ " + String.format("%.2f", foundOrder.total()));
                }
                break;
            case 4:
                System.out.println("=====LISTA DE PEDIDOS=====");
                if (orderService.getOrders().isEmpty()) {
                    System.out.println("Nenhum pedido cadastrado!");
                } else {
                    System.out.println("\nExibindo os pedidos...\n");
                    for (Order o : orderService.getOrders()) {
                        System.out.println(o.toString());
                        System.out.println("| Total do pedido: R$ " + String.format("%.2f", o.total()) + "\n");
                    }
                }
                break;
            case 5:
                start();
                break;
            default:
                System.out.println("Erro: Valor inválido.\nValores válidos: {1. Novo pedido, 2. Remover pedido, 3. Ver um pedido e total, 4. Listar todos os pedidos, 5. Voltar}\n");
                orderMenu();
        }
    }
}
