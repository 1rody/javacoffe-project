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
}
