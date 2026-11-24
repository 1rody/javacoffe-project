package cafeteria.entities;

/** Base abstrata de {@link Client} e {@link Employee}: nome, e-mail e CPF. */
public abstract class Person {
    private String name;
    private String email;
    private String cpf;

    //Construtores

    /** Cria a pessoa vazia. */
    public Person(){

    }

    /** Cria a pessoa com nome, e-mail e CPF. */
    public Person(String name, String email, String cpf){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    /** Cria a pessoa com nome e CPF. */
    public Person(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    //Getter & Setters 
    
    /** Retorna o nome. */
    public String getName() {
        return name;
    }

    /** Altera o nome. */
    public void setName(String name) {
        this.name = name;
    }

    /** Retorna o e-mail. */
    public String getEmail() {
        return email;
    }

    /** Altera o e-mail. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Retorna o CPF (chave de busca). */
    public String getCpf() {
        return cpf;
    }

    /** Altera o CPF. */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
