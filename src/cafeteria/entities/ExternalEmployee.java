package cafeteria.entities;

public class ExternalEmployee extends Employee{
    private String companyName;
    private Double hourValue;
    private Double hourWorked;
    //Construtores
    public ExternalEmployee(){
        super();
    }

    public ExternalEmployee(String name, String email, String cpf, Integer id, String occupation, Double salary, String companyName, Double hourValue, Double hourWorked){
        super(name, email, cpf, id, occupation, salary);
        this.companyName = companyName;
        this.hourValue = hourValue;
        this.hourWorked = hourWorked;
    }

    //O Get & o Set
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getHourValue() {
        return hourValue;
    }

    public void setHourValue(Double hourValue) {
        this.hourValue = hourValue;
    }

    public Double getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(Double hourWorked) {
        this.hourWorked = hourWorked;
    }

    //calculo de funcionário tercerizado com a mesma interface (acho ue )
    @Override 
    public double calculatePayment(){
        return this.hourValue * this.hourWorked;
    }
}
