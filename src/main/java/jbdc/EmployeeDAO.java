package jbdc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {


    public List<Employee> getAllEmployeesList() {
        Connection connection = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            connection = Connections.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                list.add(Employee.builder().id(rs.getInt("id"))
                        .name(rs.getString("emp_name"))
                        .lastName(rs.getString("emp_lastname"))
                        .job(rs.getString("emp_job")).build());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public Employee getEmployeeById(Integer id) {
        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection2();
            String sql = "SELECT id,emp_name,emp_lastname,emp_job FROM employee WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("emp_name"))
                        .lastName(rs.getString("emp_lastname"))
                        .job(rs.getString("emp_job")).build();
            } else {
                return null;
            }

        } catch (SQLException sqlEx) {
            sqlEx.getErrorCode();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlEx) {
                sqlEx.getErrorCode();
            }
        }
        return null;
    }

    public void updateJob(String job, Integer id) {

        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection();
            String sql = "UPDATE employee SET emp_job = ? WHERE id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, job);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void addEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection();
            String sql = "INSERT INTO employee (emp_name, emp_lastname, emp_job) values (1,2,3)";
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getJob());

//            ps.execute();
            statement.executeQuery("INSERT INTO employee (emp_name, emp_lastname, emp_job) values " +
                    "(" + "Sławomir" + "," + "Dąbrowski" + " ," + "pomocnik" + " ) " );

        } catch (SQLException sqlE) {
            sqlE.getErrorCode();
        } finally {
            try {
                if (connection != null && connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlE) {
                sqlE.getErrorCode();
            }
        }
    }
}
