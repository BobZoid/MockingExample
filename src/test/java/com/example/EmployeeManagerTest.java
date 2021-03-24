package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {



    @Test
    void payEmpTest() {
        EmployeeManager emp = new EmployeeManager(new EmployeeRepositoryStub(), new BankServiceDouble());
        assertEquals(3, emp.payEmployees());
    }

    @Test
    void payEmpTestWithMockito() {
        EmployeeRepository empRepo = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        when(empRepo.findAll()).thenReturn(List.of(new Employee("a", 1), new Employee("b", 2), new Employee("c", 3)));
        EmployeeManager emp = new EmployeeManager(empRepo, bankService);
        assertEquals(3, emp.payEmployees());
    }

    @Test
    void payEmpCatchesException() {
        EmployeeRepository empRepo = mock(EmployeeRepository.class);
        when(empRepo.findAll()).thenReturn(List.of(new Employee("a", 1), new Employee("b", 2), new Employee("c", 3)));
        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay("a", 1);
        EmployeeManager emp = new EmployeeManager(empRepo, bankService);
        assertEquals(2, emp.payEmployees());
    }

    @Test
    void payEmpWithEmptyList() {
        EmployeeRepository empRepo = mock(EmployeeRepository.class);
        when(empRepo.findAll()).thenReturn(List.of());
        BankService bankService = mock(BankService.class);
        EmployeeManager emp = new EmployeeManager(empRepo, bankService);
        assertEquals(0, emp.payEmployees());
    }

    @Test
    void payEmpRecordsPayments() {
        Employee a = new Employee("a", 1);
        assertFalse(a.isPaid());
        EmployeeRepository empRepo = mock(EmployeeRepository.class);
        when(empRepo.findAll()).thenReturn(List.of(a));
        BankService bankService = mock(BankService.class);
        EmployeeManager emp = new EmployeeManager(empRepo, bankService);
        emp.payEmployees();
        assertTrue(a.isPaid());
    }

    @Test
    void payEmpWhenExceptionThrownNotPaid() {
        EmployeeRepository empRepo = mock(EmployeeRepository.class);
        Employee testEmployee = new Employee("d", 4);
        when(empRepo.findAll()).thenReturn(List.of(testEmployee,
                new Employee("a", 1),
                new Employee("b", 2),
                new Employee("c", 3)));
        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay("d", 4);
        EmployeeManager emp = new EmployeeManager(empRepo, bankService);
        assertFalse(testEmployee.isPaid());
    }
}
