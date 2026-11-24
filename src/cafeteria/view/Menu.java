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

/**
 * Interface de console da cafeteria: mostra os menus, lê o teclado e delega aos services (recebidos pelo
 * construtor). Áreas: gestão da equipe e cafés (com senha), clientes e atendimento (pedidos).
 */
public class Menu {
    //scanner do menu privado
    private Scanner sc = new Scanner(System.in);

    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final OrderService orderService;
    private final CoffeService coffeService;

    /** Recebe os services já criados (injeção de dependência). */
    public Menu(EmployeeService employeeService, ClientService clientService,
                    OrderService orderService, CoffeService coffeService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.orderService = orderService;
        this.coffeService = coffeService;
    }


    /** Exibe o menu principal até digitar 0 e abre o submenu escolhido. */
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
    /** Gestão da equipe (senha local 12345): uma ação por vez sobre funcionários e cafés. */
    private void employeeMenu() {
        int password;
        System.out.println("=====THE BEST COFFE STAFF=====");
        System.out.println("Insira a senha local para login");
        password = sc.nextInt();

        //repete até a senha estar correta
        while(password != 12345) {
            System.out.println("Senha invalida favor tente novamente!");
            password = sc.nextInt();
        };

        System.out.println("=====THE BEST COFFE STAFF =====");
        System.out.println("Digite a opção para realizar a ação");

        System.out.println("1- Cadastro de funcionários");
        System.out.println("2- Remoção de funcionários");
        System.out.println("3- Lista de funcionários");
        System.out.println("4- Lista de funcionários ordenada por nome");
        System.out.println("5- Cadastro dos cafés");
        System.out.println("6- Alterar funcionário");
        System.out.println("7- Remover café");
        System.out.println("8- Alterar café");
        System.out.println("9- Lista de cafés");
        System.out.println("10- Lista de cafés ordenada por nome");

        int secondSelection;
        int thirdSelection;
        secondSelection = sc.nextInt();

        switch (secondSelection) {
            case 1:

                System.out.println("Cadastro de funcionários:");
                System.out.println("1- Cadastro de funcionários");
                System.out.println("2- Cadastro de funcionários Terceirizados");
                thirdSelection = sc.nextInt();

                //1 = CLT, 2 = terceirizado
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
                    System.out.printf("%-5s | %-15s | %-25s | %-15s | %-15s | %-20s | %-12s%n",
                            "ID", "NOME", "E-MAIL", "CPF", "CARGO", "TIPO/EMPRESA", "PAGAMENTO");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");

                    for (Employee emp : employeeService.getEmployees()) {
                        String tipoInfo = "CLT";
                        if (emp instanceof ExternalEmployee) {
                            ExternalEmployee external = (ExternalEmployee) emp;
                            tipoInfo = "Terc. (" + external.getCompanyName() + ")";
                        }

                        //pagamento polimórfico: CLT ou terceirizado
                        System.out.printf("%-5d | %-15s | %-25s | %-15s | %-15s | %-20s | R$ %8.2f%n",
                                emp.getId(),
                                emp.getName(),
                                emp.getEmail(),
                                emp.getCpf(),
                                emp.getOccupation(),
                                tipoInfo,
                                emp.calculatePayment());
                    }
                }
                break;
            case 4:
                System.out.println("=====LISTA DE FUNCIONÁRIOS ORDENADA=====");
                if (employeeService.getEmployeesSorted().isEmpty()) {
                    System.out.println("Nenhum funcionário cadastrado!");
                } else {
                    System.out.println("\nExibindo os funcionários...\n");
                    System.out.printf("%-5s | %-15s | %-25s | %-15s | %-15s | %-20s | %-12s%n",
                            "ID", "NOME", "E-MAIL", "CPF", "CARGO", "TIPO/EMPRESA", "PAGAMENTO");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");

                    for (Employee emp : employeeService.getEmployeesSorted()) {
                        String tipoInfo = "CLT";
                        if (emp instanceof ExternalEmployee) {
                            ExternalEmployee external = (ExternalEmployee) emp;
                            tipoInfo = "Terc. (" + external.getCompanyName() + ")";
                        }

                        System.out.printf("%-5d | %-15s | %-25s | %-15s | %-15s | %-20s | R$ %8.2f%n",
                                emp.getId(),
                                emp.getName(),
                                emp.getEmail(),
                                emp.getCpf(),
                                emp.getOccupation(),
                                tipoInfo,
                                emp.calculatePayment());
                    }
                }
                break;
            case 5:
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
            case 6:
                System.out.println("=====ALTERAR FUNCIONÁRIO=====");
                sc.nextLine(); //limpa o enter que sobrou do nextInt
                System.out.print("CPF do funcionário: ");
                String alterCpf = sc.nextLine();

                Employee foundEmployee = employeeService.searchEmployee(alterCpf);
                if (foundEmployee == null) {
                    System.out.println("Funcionário nao encontrado!");
                    break; //sai do switch
                }

                System.out.println("Digite os novos dados:");
                System.out.print("Nome: ");
                String alterName = sc.nextLine();
                System.out.print("E-Mail: ");
                String alterEmail = sc.nextLine();
                System.out.print("ID: ");
                int alterId = sc.nextInt();
                sc.nextLine();
                System.out.print("Cargo: ");
                String alterOccupation = sc.nextLine();
                System.out.print("Salário: ");
                double alterSalary = sc.nextDouble();
                employeeService.updateEmployee(alterCpf, alterName, alterEmail, alterId, alterOccupation, alterSalary);

                //se for terceirizado, pede tambem os dados extras
                if (foundEmployee instanceof ExternalEmployee) {
                    sc.nextLine();
                    System.out.print("Empresa: ");
                    String alterCompany = sc.nextLine();
                    System.out.print("Valor da hora: ");
                    double alterHourValue = sc.nextDouble();
                    System.out.print("Horas trabalhadas: ");
                    double alterHourWorked = sc.nextDouble();
                    employeeService.updateExternalEmployee(alterCpf, alterCompany, alterHourValue, alterHourWorked);
                }
                System.out.println("Funcionário alterado!");
                break;
            case 7:
                System.out.println("=====REMOVER CAFÉ=====");
                sc.nextLine(); //limpa o enter que sobrou do nextInt
                System.out.print("Nome do café: ");
                String removeCoffeeName = sc.nextLine();

                if (coffeService.removeCoffee(removeCoffeeName)) {
                    System.out.println("Café removido!");
                } else {
                    System.out.println("Café nao encontrado!");
                }
                break;
            case 8:
                System.out.println("=====ALTERAR CAFÉ=====");
                sc.nextLine(); //limpa o enter que sobrou do nextInt
                System.out.print("Nome do café: ");
                String alterCoffeeName = sc.nextLine();

                if (coffeService.searchCoffee(alterCoffeeName) == null) {
                    System.out.println("Café nao encontrado!");
                    break; //sai do switch
                }

                System.out.print("Novo preço: ");
                double alterCoffeePrice = sc.nextDouble();
                sc.nextLine();
                System.out.print("Nova descrição: ");
                String alterCoffeeDescription = sc.nextLine();
                System.out.print("Contém lactose: (s/n)");
                boolean alterCoffeeLactose = sc.nextLine().equalsIgnoreCase("s");

                coffeService.updateCoffee(alterCoffeeName, alterCoffeePrice, alterCoffeeDescription, alterCoffeeLactose);
                System.out.println("Café alterado!");
                break;
            case 9:
                System.out.println("=====LISTA DE CAFÉS=====");
                if (coffeService.getCoffees().isEmpty()) {
                    System.out.println("Nenhum café cadastrado!");
                } else {
                    System.out.println("\nExibindo os cafés...\n");
                    for (Coffee item : coffeService.getCoffees()) { //ordem de cadastro
                        System.out.println("| Nome: " + item.getCoffeename());
                        System.out.println("| Preço: R$ " + String.format("%.2f", item.getPrice()));
                        if (item.getLactose()) {
                            System.out.println("| Contém lactose: Sim\n");
                        } else {
                            System.out.println("| Contém lactose: Não\n");
                        }
                    }
                }
                break;
            case 10:
                System.out.println("=====LISTA DE CAFÉS ORDENADA=====");
                if (coffeService.getCoffees().isEmpty()) {
                    System.out.println("Nenhum café cadastrado!");
                } else {
                    System.out.println("\nExibindo os cafés...\n");
                    for (Coffee item : coffeService.getCoffeesSorted()) { //ordenada por nome
                        System.out.println("| Nome: " + item.getCoffeename());
                        System.out.println("| Preço: R$ " + String.format("%.2f", item.getPrice()));
                        if (item.getLactose()) {
                            System.out.println("| Contém lactose: Sim\n");
                        } else {
                            System.out.println("| Contém lactose: Não\n");
                        }
                    }
                }
                break;
        }

        if (secondSelection >= 5) {
            System.out.println("Opcao invalida favor tente novamente!");
        }

    }
    /** Menu de clientes: cadastrar, remover, alterar e listar (uma ação por vez). */
    private  void clientMenu() {
        int secondSelection;

        System.out.println("Digite a opcao para realizar a acao");

        System.out.println("1- Cadastro de cliente");
        System.out.println("2- Remocao de cliente");
        System.out.println("3- Lista de clientes");
        System.out.println("4- Lista de clientes ordenada por nome");
        System.out.println("5- Alterar cliente");
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
                    System.out.printf("%-20s | %-28s | %-15s%n", "NOME", "E-MAIL", "CPF");
                    System.out.println("---------------------------------------------------------------------");

                    for (Client c : clientService.getClients()) {
                        System.out.printf("%-20s | %-28s | %-15s%n",
                                c.getName(),
                                c.getEmail(),
                                c.getCpf());
                    }
                }
                break;
            case 4:
                System.out.println("=====LISTA DE CLIENTES ORDENADA=====");
                if (clientService.getClientsSorted().isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado!");
                } else {
                    System.out.println("\nExibindo os clientes...\n");
                    System.out.printf("%-20s | %-28s | %-15s%n", "NOME", "E-MAIL", "CPF");
                    System.out.println("---------------------------------------------------------------------");

                    for (Client c : clientService.getClientsSorted()) {
                        System.out.printf("%-20s | %-28s | %-15s%n",
                                c.getName(),
                                c.getEmail(),
                                c.getCpf());
                    }
                }
            case 5:
                System.out.println("=====ALTERAR CLIENTE=====");
                System.out.print("CPF do cliente: ");
                String alterCpf = sc.nextLine();
                System.out.print("Novo nome: ");
                String alterName = sc.nextLine();
                System.out.print("Novo E-Mail: ");
                String alterEmail = sc.nextLine();

                if (clientService.updateClient(alterCpf, alterName, alterEmail)) {
                    System.out.println("Cliente alterado!");
                } else {
                    System.out.println("Cliente nao encontrado!");
                }
                break;
            default:
                System.out.println("Opcao invalida!");
                System.out.println("Digite 1, 2, 3 ou 0 para sair");
                break;

        }
    }

    /** Menu de atendimento: criar, remover, consultar, listar e alterar pedidos (uma ação por vez). */
    private  void orderMenu() {
        int secondSelection;
        System.out.println("=====MENU DE ATENDIMENTO=====");

        System.out.println("Digite um valor abaixo para realizar a tarefa:");
        System.out.println("1. Novo pedido");
        System.out.println("2. Remover pedido");
        System.out.println("3. Ver um pedido e total");
        System.out.println("4. Listar todos os pedidos");
        System.out.println("5. Listar pedidos ordenados por total");
        System.out.println("6. Alterar pedido");
        System.out.println("0. Voltar");

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

                //cliente existente ou novo
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

                //composição: pedido com cliente e café
                Order newOrder = new Order(orderId, orderClient);

                System.out.println("Indo para a seção de produtos...");
                System.out.println("\nExibindo os produtos...\n");
                System.out.println("| Tipos disponíveis:");
                for (Coffee item : coffeService.getCoffees()) {
                    System.out.println("| " + item.getCoffeename() + " - R$ " + String.format("%.2f", item.getPrice()));
                }

                //repete até um café válido
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
                //avisa: cliente intolerante e café com lactose
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
                //confere o ID e exibe a tabela de todos os pedidos
                System.out.println("=====VER PEDIDO E TOTAL=====");
                System.out.print("ID do pedido: ");
                Integer searchId = sc.nextInt();
                sc.nextLine();

                Order foundOrder = orderService.orderSearch(searchId);
                if (foundOrder == null) {
                    System.out.println("Pedido não encontrado!");
                } else {
                    System.out.println("\nExibindo os pedidos...\n");
                    System.out.printf("%-5s | %-20s | %-10s | %-12s%n", "ID", "CLIENTE", "QTD ITENS", "TOTAL");
                    System.out.println("--------------------------------------------------------");

                    for (Order o : orderService.getOrders()) {
                        System.out.printf("%-5d | %-20s | %-10d | R$ %8.2f%n",
                                o.getId(),
                                o.getClient().getName(),
                                o.getCoffees().size(),
                                o.total());
                    }
                }

                break;
            case 4:
                System.out.println("=====LISTA DE PEDIDOS=====");
                if (orderService.getOrders().isEmpty()) {
                    System.out.printf("Nenhum pedido cadastrado!");
                } else {
                    System.out.println("\nExibindo os pedidos...\n");
                    System.out.printf("%-5s | %-20s | %-10s | %-12s%n", "ID", "CLIENTE", "QTD ITENS", "TOTAL");
                    System.out.println("--------------------------------------------------------");

                    for (Order o : orderService.getOrders()) {
                        System.out.printf("%-5d | %-20s | %-10d | R$ %8.2f%n",
                                o.getId(),
                                o.getClient().getName(),
                                o.getCoffees().size(),
                                o.total());
                    }
                }
                break;
            case 5:
                System.out.println("=====LISTA DE PEDIDOS ORDENADA=====");
                if (orderService.getOrdersSorted().isEmpty()) {
                    System.out.printf("Nenhum pedido cadastrado!");
                } else {
                    System.out.println("\nExibindo os pedidos...\n");
                    System.out.printf("%-5s | %-20s | %-10s | %-12s%n", "ID", "CLIENTE", "QTD ITENS", "TOTAL");
                    System.out.println("--------------------------------------------------------");

                    for (Order o : orderService.getOrdersSorted()) {
                        System.out.printf("%-5d | %-20s | %-10d | R$ %8.2f%n",
                                o.getId(),
                                o.getClient().getName(),
                                o.getCoffees().size(),
                                o.total());
                    }
                }
            case 6:
                System.out.println("=====ALTERAR PEDIDO=====");
                System.out.print("ID do pedido: ");
                Integer alterId = sc.nextInt();
                sc.nextLine();

                if (orderService.orderSearch(alterId) == null) {
                    System.out.println("Pedido não encontrado!");
                    break; //sai do switch
                }

                System.out.println("\n| Tipos disponíveis:");
                for (Coffee item : coffeService.getCoffees()) {
                    System.out.println("| " + item.getCoffeename() + " - R$ " + String.format("%.2f", item.getPrice()));
                }

                //repete ate o usuario digitar um cafe que existe
                Coffee alterSelected = null;
                while (alterSelected == null) {
                    System.out.println("\n> Digite o nome do novo café:\n");
                    coffeename = sc.nextLine();
                    alterSelected = coffeService.searchCoffee(coffeename);
                    if (alterSelected == null) {
                        System.out.println("Erro: <Nenhum tipo válido>\n");
                    }
                }

                System.out.println("\nPossui intolerância à lactose?\n1- Possuo.\n0- Não possuo.");
                sclactose = sc.nextInt();
                sc.nextLine();
                while (sclactose != 0 && sclactose != 1) {
                    System.out.println("Valor inválido! Digite 0 ou 1.");
                    sclactose = sc.nextInt();
                    sc.nextLine();
                }
                lactose = (sclactose == 1);

                //copia do cafe do cardapio, para a lactose do cliente nao alterar o cadastro do cafe
                Coffee alterCoffee = new Coffee(alterSelected.getCoffeename(), alterSelected.getPrice(), alterSelected.getDescription(), lactose);
                orderService.updateOrderCoffee(alterId, alterCoffee);
                System.out.println("\nPedido alterado!");
                break;
            case 0:
                break;
            default:
                System.out.println("Erro: Valor inválido.\nValores válidos: {1. Novo pedido, 2. Remover pedido, 3. Ver um pedido e total, 4. Listar todos os pedidos, 5. Voltar}\n");
                orderMenu();
        }
    }
}
