package cafeteria.entities;

public class Client extends Person {

    //Construtores
    public Client(){
        super();
    }

    public Client(String name, String email, String cpf){
        super(name, email, cpf);
    }

    public Client(String name, String cpf){
        super(name, cpf);
    }

}
