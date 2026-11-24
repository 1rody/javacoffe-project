package cafeteria.entities;

/** Cliente da cafeteria (uma {@link Person} sem campos extras). */
public class Client extends Person {

    //Construtores
    /** Cria o cliente vazio. */
    public Client(){
        super();
    }

    /** Cria o cliente com nome, e-mail e CPF. */
    public Client(String name, String email, String cpf){
        super(name, email, cpf);
    }

    /** Cria o cliente com nome e CPF. */
    public Client(String name, String cpf){
        super(name, cpf);
    }

}
