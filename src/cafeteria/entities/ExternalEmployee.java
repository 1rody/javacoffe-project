package cafeteria.entities;

/** Funcionário terceirizado: empresa, valor da hora e horas trabalhadas. Recebe valor da hora x horas. */
public class ExternalEmployee extends Employee{
    private String companyName;
    private Double hourValue;
    private Double hourWorked;
    //Construtores
    /** Cria o terceirizado vazio. */
    public ExternalEmployee(){
        super();
    }

    /** Cria o terceirizado com todos os dados. */
    public ExternalEmployee(String name, String email, String cpf, Integer id, String occupation, Double salary, String companyName, Double hourValue, Double hourWorked){
        super(name, email, cpf, id, occupation, salary);
        this.companyName = companyName;
        this.hourValue = hourValue;
        this.hourWorked = hourWorked;
    }

    //O Get & o Set
    /** Retorna a empresa. */
    public String getCompanyName() {
        return companyName;
    }

    /** Altera a empresa. */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /** Retorna o valor da hora. */
    public Double getHourValue() {
        return hourValue;
    }

    /** Altera o valor da hora. */
    public void setHourValue(Double hourValue) {
        this.hourValue = hourValue;
    }

    /** Retorna as horas trabalhadas. */
    public Double getHourWorked() {
        return hourWorked;
    }

    /** Altera as horas trabalhadas. */
    public void setHourWorked(Double hourWorked) {
        this.hourWorked = hourWorked;
    }

    /** Retorna valor da hora x horas trabalhadas (ignora o salário herdado). */
    @Override 
    public double calculatePayment(){
        return this.hourValue * this.hourWorked;
    }
}
