package cafeteria.entities;

public abstract class Person {
    private String name;
    private String email;
    private String cpf;

    //Construtores

    public Person(){

    }

    public Person(String name, String email, String cpf){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Person(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    //Getter & Setters 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
