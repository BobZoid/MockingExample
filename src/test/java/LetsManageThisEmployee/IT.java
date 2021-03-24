package LetsManageThisEmployee;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class IT {
    EmployeeManager manager = new EmployeeManager(new RepositoryOfEmployees(List.of(
            new Employee("a", 1),
            new Employee("b", 2),
            new Employee("c", 3))), mock(BankService.class));

    @Test
    public void payEmployees() {
        assertEquals(3, manager.payEmployees());
    }
}
