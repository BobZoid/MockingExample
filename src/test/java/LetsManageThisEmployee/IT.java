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
    RepositoryOfEmployees empRepo = new RepositoryOfEmployees(List.of(
            new Employee("a", 1),
            new Employee("b", 2),
            new Employee("c", 3)));
    EmployeeManager manager = new EmployeeManager(empRepo, bankService);

    @Test
    public void payEmployees() {
        assertEquals(3, manager.payEmployees());
    }

    @Test
    public void payEmployeesCatchesException() {
        doThrow(new RuntimeException()).when(bankService).pay("a", 1);
        assertEquals(2, manager.payEmployees());
        Employee a = empRepo.findAll().get(0);
        Employee b = empRepo.findAll().get(1);
        assertFalse(a.isPaid());
        assertTrue(b.isPaid());
    }

    @Test
    public void payEmployeeNoDataReturnsZero() {
        EmployeeManager manager2 = new EmployeeManager(new RepositoryOfEmployees(), bankService);
        assertEquals(0, manager2.payEmployees());
    }
}
