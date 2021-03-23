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
}
