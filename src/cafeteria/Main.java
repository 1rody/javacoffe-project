package cafeteria;

import cafeteria.view.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //arraylist da cafeteria (em /view/menu) la cria a cafeteria
        Cafeteria cafeteria = new Cafeteria();


        //codigo para ir ao menu
        System.out.println("=====THE BEST COFFE =====");
        System.out.println("Digite a opcao para entrar no sistema");

        System.out.println("1- Cadastro de funcionario");
        System.out.println("2- Cadastro de cliente");
        System.out.println("3- Atendimento");
        System.out.println("0- Sair");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> cafeteria.cadastrarFuncionario();
            case 2 -> cafeteria.cadastrarCliente();
            case 3 -> cafeteria.realizarAtendimento();
        }
    }
}