package cafeteria.services;
import cafeteria.entities.Employee;
import cafeteria.entities.ExternalEmployee;

import java.util.ArrayList;
import java.util.Comparator;

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
    public Employee searchEmployee(String cpf) {
        for (Employee employee : employees) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }
    public ArrayList<Employee> getEmployeesSorted(){
        ArrayList<Employee> sorted = new ArrayList<>(employees); //copia da lista original
        sorted.sort(Comparator.comparing(e -> e.getName())); //ordena por nome
        return sorted;
    }

    //altera os dados que todo funcionario tem (o cpf e a chave, entao nao muda)
    public boolean updateEmployee(String cpf, String name, String email, Integer id, String occupation, Double salary) {
        Employee employee = searchEmployee(cpf);
        if (employee == null) {
            return false; //nao achou o funcionario
        }
        employee.setName(name);
        employee.setEmail(email);
        employee.setId(id);
        employee.setOccupation(occupation);
        employee.setSalary(salary);
        return true;
    }

    //altera os dados extras do funcionario terceirizado
    public boolean updateExternalEmployee(String cpf, String companyName, Double hourValue, Double hourWorked) {
        Employee employee = searchEmployee(cpf);
        if (employee instanceof ExternalEmployee) {
            ExternalEmployee external = (ExternalEmployee) employee; //converte para usar os set do terceirizado
            external.setCompanyName(companyName);
            external.setHourValue(hourValue);
            external.setHourWorked(hourWorked);
            return true;
        }
        return false; //nao existe ou nao e terceirizado
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
