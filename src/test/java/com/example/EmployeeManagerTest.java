package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    EmployeeManager emp = new EmployeeManager(new EmployeeRepositoryStub(), new BankServiceDouble());

    @Test
    void payEmpTest() {
        assertEquals(3, emp.payEmployees());

    }
}
