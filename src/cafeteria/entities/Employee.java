package cafeteria.entities;

public class Employee extends Person{
    private Integer id;
    private String occupation;
    private Double salary;

    //Construtores

    public Employee(){
        super();
    }

    public Employee(String name, String email, String cpf, Integer id, String occupation, Double salary){
        super(name, email, cpf);
        this.id = id;
        this.occupation = occupation;
        this.salary = salary;
    }

    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
