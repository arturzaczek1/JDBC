import jbdc.Employee;
import jbdc.EmployeeDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JdbcTest {

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
        System.out.println(employeeDAO.getEmployeeById(6).toString());
    }
    @Test
    public void testOfUpdateJob(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.updateJob("sekretarka",2);
    }
    @Test void testOfAddEmployee (){
//        Employee damian = Employee.builder().name("Damian").lastName("Zieliński").job("malarz").build();
        Employee damian= new Employee();
        damian.setName("Damian");
        damian.setLastName("Zeiliński");
        damian.setJob("malarz");
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(damian);
        testOfEmployeeList();
    }
}
