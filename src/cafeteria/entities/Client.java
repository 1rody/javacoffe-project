package cafeteria.entities;

public class Client extends Person {
    private Integer order;

    //Construtores
    public Client(){
        super();
    }

    public Client(String name, String email, String cpf, Integer order){
        super(name, email, cpf);
        this.order = order;
    }

    public Client(String name, String cpf, Integer order){
        super(name, cpf);
        this.order = order;
    }

    //O get e o set

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    
}
