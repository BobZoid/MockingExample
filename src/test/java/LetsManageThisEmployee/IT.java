package LetsManageThisEmployee;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class IT {
    BankService bankService = mock(BankService.class);
    EmployeeManager manager = new EmployeeManager(new RepositoryOfEmployees(List.of(
            new Employee("a", 1),
            new Employee("b", 2),
            new Employee("c", 3))), bankService);

    @Test
    public void payEmployees() {
        assertEquals(3, manager.payEmployees());
    }

    @Test
    public void payEmployeesCatchesException() {
        doThrow(new RuntimeException()).when(bankService).pay("a", 1);
        assertEquals(2, manager.payEmployees());
    }
}
