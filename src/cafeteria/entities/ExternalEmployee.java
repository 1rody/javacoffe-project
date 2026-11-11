package cafeteria.entities;

public class ExternalEmployee extends Employee{
    private String companyName;

    //Construtores
    public ExternalEmployee(){
        super();
    }

    public ExternalEmployee(String name, String email, String cpf, Integer id, String occupation, Double salary, String companyName){
        super(name, email, cpf, id, occupation, salary);
        this.companyName = companyName;
    }

    //O Get & o Set
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
