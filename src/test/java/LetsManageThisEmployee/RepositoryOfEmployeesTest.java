package LetsManageThisEmployee;

import com.example.Employee;
import org.junit.jupiter.api.Test;

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
}
