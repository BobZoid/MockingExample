package LetsManageThisEmployee;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryOfEmployees implements EmployeeRepository {
    List<Employee> empRepo = new ArrayList<>();

    RepositoryOfEmployees() {}

    RepositoryOfEmployees(List<Employee> repo) {
        empRepo=repo;
    }

    @Override
    public List<Employee> findAll() {
        return empRepo;
    }

    @Override
    public Employee save(Employee e) {
        empRepo.add(e);
        int index = empRepo.indexOf(e);
        return empRepo.get(index);
    }
}
