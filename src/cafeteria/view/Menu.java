package cafeteria.view;

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

        if(password == 12345) {
            System.out.println("=====THE BEST COFFE STAFF =====");
            System.out.println("Digite a opcao para realizar a acao");

            System.out.println("1- Cadastro de funcionario");
            System.out.println("2- Remocao de funcionario");
            System.out.println("3- Atendimento");
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


                    if (thridSelection > 2) {
                        System.out.println("Opcao invalida favor tente novamente!");
                    }
                    else {
                        switch (thridSelection) {
                            case 1:
                                System.out.println("Cadastro de funcionario CLT");
                                break;
                            case 2:
                                System.out.println(" Cadastro de funcionario Terceirizado");
                        }
                    }
                    break;
                case 2:

            }

            if (secondSelection >= 3) {
                System.out.println("Opcao invalida favor tente novamente!");
            }
        }
        else {
            do {
                System.out.println("Senha invalida favor tente novamente!");
                password = sc.nextInt();
            } while(password != 12345);
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
