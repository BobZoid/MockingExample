package LetsManageThisEmployee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryOfEmployeesTest {

    @Test
    public void findAllOnEmptyReturnsEmptyList() {
        RepositoryOfEmployees empRepo = new RepositoryOfEmployees();
        var empList = empRepo.findAll();
        assertEquals(0, empList.size());
    }
}
