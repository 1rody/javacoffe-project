package cafeteria.view;

import cafeteria.entities.Employee;
import cafeteria.entities.ExternalEmployee;
import cafeteria.services.ClientService;
import cafeteria.services.EmployeeService;
import cafeteria.services.OrderService;

import java.util.Scanner;

public class Menu {
    //scanner do menu privado
    private Scanner sc = new Scanner(System.in);

    private EmployeeService employeeService = new EmployeeService();
    private ClientService clientService = new ClientService();
    private OrderService orderService = new OrderService();

    //diferente de main aqui a cafeteria ja foi criada
    public void start() {
        int option;

        do {
            //codigo para ir ao menu
            System.out.println("=====THE BEST COFFE =====");
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
        System.out.println("=====THE BEST COFFE STAFF =====");
        System.out.println("Insira a senha local para login");
        password = sc.nextInt();

        while(password != 12345) {
            System.out.println("Senha invalida favor tente novamente!");
            password = sc.nextInt();
        };

        System.out.println("=====THE BEST COFFE STAFF =====");
        System.out.println("Digite a opcao para realizar a acao");

        System.out.println("1- Cadastro de funcionario");
        System.out.println("2- Remocao de funcionario");
        System.out.println("0- Sair");

        int secondSelection;
        int thridSelection;
        secondSelection = sc.nextInt();

        switch (secondSelection) {
            case 1:

                System.out.println("Cadastro de funcionario:");

                System.out.println("1- Cadastro de funcionario");
                System.out.println("2- Cadastro de funcionario Terceirizado");

                thridSelection = sc.nextInt();

                if(thridSelection == 1) {
                    switch (thridSelection) {
                        case 1:
                            System.out.println(" Cadastro de funcionario CLT");

                            sc.nextLine();
                            System.out.print("Nome: ");
                            String name = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("CPF: ");
                            String cpf = sc.nextLine();
                            System.out.print("ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Cargo: ");
                            String occupation = sc.nextLine();
                            System.out.print("Salario: ");
                            double salary = sc.nextDouble();

                            Employee employee = new Employee(name, email, cpf, id, occupation, salary);
                            employeeService.addEmployee(employee);
                            System.out.println("Funcionario cadastrado!");
                            break;
                        case 2:
                            System.out.println(" Cadastro de funcionario Terceirizado");
                            sc.nextLine();
                            System.out.print("Nome: ");
                            String tname = sc.nextLine();
                            System.out.print("Email: ");
                            String temail = sc.nextLine();
                            System.out.print("CPF: ");
                            String tcpf = sc.nextLine();
                            System.out.print("ID: ");
                            int tid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Cargo: ");
                            String toccupation = sc.nextLine();
                            System.out.print("Salario: ");
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
                            System.out.println("Funcionario terceirizado cadastrado!");
                            break;

                    }
                }
                break;
            case 2:

        }

        if (secondSelection >= 3) {
            System.out.println("Opcao invalida favor tente novamente!");
        }


    }
    private  void clientMenu() {

    }
    private  void orderMenu() {
        int secondSelection;
        System.out.println("======= MENU DE ATENDIMENTO =========");

        System.out.println("Digite um valor abaixo para realizar a tarefa:");
        System.out.println("1. Novo pedido");
        System.out.println("2. Remover pedido");
        System.out.println("3. Ver um pedido e total");
        System.out.println("4. Listar todos os pedidos");
        System.out.println("5. Voltar");


        secondSelection = sc.nextInt();
    }
}
