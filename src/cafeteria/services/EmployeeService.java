package cafeteria.services;
import cafeteria.entities.Employee;
import cafeteria.entities.ExternalEmployee;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Serviço de funcionários (CLT e terceirizados): lista em memória com cadastro, remoção, busca,
 * alteração e listagem (inicia com 7 funcionários).
 */
public class EmployeeService {
    private ArrayList <Employee> employees = new ArrayList<>();

    /** Adiciona um funcionário. */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    /** Remove o funcionário pelo CPF; retorna true se removeu. */
    public boolean removeEmployee(String cpf) {
        return employees.removeIf(e -> e.getCpf().equals(cpf));
    }
    /** Retorna os funcionários na ordem de cadastro. */
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
    /** Busca pelo CPF; retorna null se não achar. */
    public Employee searchEmployee(String cpf) {
        for (Employee employee : employees) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }
    /** Retorna uma cópia ordenada por nome. */
    public ArrayList<Employee> getEmployeesSorted(){
        ArrayList<Employee> sorted = new ArrayList<>(employees); //copia da lista original
        sorted.sort(Comparator.comparing(e -> e.getName())); //ordena por nome
        return sorted;
    }

    /** Altera os dados comuns do funcionário do CPF (o CPF não muda); retorna false se não achar. */
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

    /** Altera os dados extras do terceirizado; retorna false se não achar ou não for terceirizado. */
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
    /** Inicia com 7 funcionários CLT de exemplo. */
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
