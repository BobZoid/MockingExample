package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

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
}
