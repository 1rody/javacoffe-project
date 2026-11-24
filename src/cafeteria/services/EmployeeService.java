package cafeteria.services;
import cafeteria.entities.Employee;

import java.util.ArrayList;

public class EmployeeService {
    private ArrayList <Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public boolean removeEmployee(String cpf) {
        return employees.removeIf(e -> e.getCpf().equals(cpf));
    }
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public EmployeeService(){
        employees.add(new Employee("Rodolfo","rodolfo@gmail.com","000.000.000-10", 10,"caixa", 1700.0));
        employees.add(new Employee("Gustavo","gustavo@hotmail.com","000.000.000-20",20,"faxineiro", 1700.0));
        employees.add(new Employee("Cristhofer","cristhofer@yahoo.com","000.000.000-30",30,"garçom", 1700.0));
        employees.add(new Employee("Alan","alan@gmail.com","000.000.000-40",40,"estoquista",1700.0));
        employees.add(new Employee("Jorge","jorge@gmail.com","000.000.000-50",50,"caixa",1700.0));
        employees.add(new Employee("Emanuele","emanuele@gmail.com","000.000.000-60",60,"garçonete",1700.0));
        employees.add(new Employee("Lara","lara@hotmail.com","000.000.000-70",70,"estoquista",1700.0));
    }
}
