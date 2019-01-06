import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeDAOTest {

    @Test
    public void testOfEmployeeList() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> list= employeeDAO.getAllEmployeesList();
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }
    @Test
    public void testOfEmployeeById(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println(employeeDAO.getEmployeeById(4).toString());
    }
}
