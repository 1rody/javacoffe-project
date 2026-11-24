package cafeteria.entities;

/** Funcionário CLT: ID, cargo e salário, além dos dados de {@link Person}. Recebe o salário fixo. */
public class Employee extends Person implements Payable{
    private Integer id;
    private String occupation;
    private Double salary;

    //Construtores

    /** Cria o funcionário vazio. */
    public Employee(){
        super();
    }

    /** Cria o funcionário com todos os dados. */
    public Employee(String name, String email, String cpf, Integer id, String occupation, Double salary){
        super(name, email, cpf);
        this.id = id;
        this.occupation = occupation;
        this.salary = salary;
    }

    //Getters & Setters

    /** Retorna o ID. */
    public Integer getId() {
        return id;
    }

    /** Altera o ID. */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Retorna o cargo. */
    public String getOccupation() {
        return occupation;
    }

    /** Altera o cargo. */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /** Retorna o salário. */
    public Double getSalary() {
        return salary;
    }

    /** Altera o salário. */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /** Retorna o salário fixo. */
    @Override 
    public double calculatePayment(){
        return this.salary;
    }

}
