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
                //foreach para leitura de funcionarios
                break;
            case 4:
                System.out.println(" Cadastro de items ao menu");
                sc.nextLine();
                System.out.print("Nome do CAFÉ: ");
                String coffeName = sc.nextLine();
                System.out.print("Descrição: ");
                String coffeDescription = sc.nextLine();
                System.out.print("Preço: ");
                double coffePrice = sc.nextDouble();
                sc.nextLine();
                System.out.print("Lactose: (s/n)");
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
                break;
            case 2:
                System.out.println("=====REMOCAO DE CLIENTE=====");

                System.out.print("Digite o nome/CPF do cliente: ");
                String nameOrCpf;
                do {
                    nameOrCpf=sc.nextLine();
                    if(clientService.removeClient(nameOrCpf)){
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.print("\nCliente nao encontrado\nTente novamente:");
                    }
                } while(!clientService.removeClient(nameOrCpf));
                break;
            default:
                System.out.println("Opcao invalida!");
                System.out.println("Digite 1, 2 ou 0 para sair");
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
                Order newOrder = new Order();
                System.out.println("Indo para a seção de produtos...");
                System.out.println("\nExibindo os produtos...\n");
                Coffee coffe = new Coffee();
                coffe.exibirTipos();
                System.out.println("\n> Qual café deseja selecionar? (Nome)\n");
                coffeename = sc.nextLine();
                coffe.setCoffeename(coffeename);
                coffe.controle(coffeename);
                System.out.println("\nPossui intolerância à lactose?\n1- Possuo.\n0- Não possuo.");
                sclactose = sc.nextInt();
                while (sclactose != 0 && sclactose != 1) {
                System.out.println("Valor inválido! Digite 0 ou 1.");
                sclactose = sc.nextInt();
                sc.nextLine();
                }
                if (sclactose == 1) {
                    lactose = true;
                } else {
                    lactose = false;
                }
                coffe.setLactose(lactose);
                System.out.println(coffe.statusLactose(lactose));
                System.out.println(coffe.toString());
                orderService.addOrder(newOrder);
                break;
            case 2:
                System.out.println("Qual o id do pedido que deseja remover?");
                System.out.print("ID do pedido: ");
                Integer id = sc.nextInt();
                sc.nextLine();
                orderService.removeOrder(id);
                System.out.println("Pedido removido!");
                break;
            case 3:
                
                break;
            case 4:

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
