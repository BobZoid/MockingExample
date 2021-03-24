package LetsManageThisEmployee;

import com.example.Employee;
import com.example.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryOfEmployeesTest {
    RepositoryOfEmployees empRepo = new RepositoryOfEmployees();


    @Test
    public void findAllOnEmptyReturnsEmptyList() {
        var empList = empRepo.findAll();
        assertEquals(0, empList.size());
    }

    @Test
    public void findAllAfterSaveReturnsListWithEmployees() {
        empRepo.save(new Employee("a", 1));
        empRepo.save(new Employee("b", 2));
        assertEquals(2, empRepo.findAll().size());
    }

    @Test
    public void afterSaveFindAllReturnsCorrectContent() {
        empRepo.save(new Employee("c", 3));
        var empList = empRepo.findAll();
        assertEquals("c", empList.get(0).getId());
        assertEquals(3, empList.get(0).getSalary());
    }

    @Test
    public void constructorWithList() {
        Employee a = new Employee("a", 1);
        Employee b = new Employee("b", 2);
        Employee c = new Employee("c", 3);
        RepositoryOfEmployees empRepo2 = new RepositoryOfEmployees(List.of(a,b,c));
        assertEquals(3, empRepo2.findAll().size());
        assertTrue(empRepo2.findAll().contains(a));
        assertTrue(empRepo2.findAll().contains(b));
        assertTrue(empRepo2.findAll().contains(c));
    }

    @Test
    public void equalIdOverWritesPreviousEntry() {
        empRepo.save(new Employee("a", 1));
        empRepo.save(new Employee("a", 2));
        assertEquals(1, empRepo.findAll().size());
        assertEquals("a", empRepo.findAll().get(0).getId());
        assertEquals(2, empRepo.findAll().get(0).getSalary());
    }

}
