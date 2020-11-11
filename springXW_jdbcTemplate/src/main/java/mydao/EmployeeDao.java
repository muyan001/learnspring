package mydao;

import mybean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveEmplyee(Employee employee){

        String sql = "INSERT INTO employee(emp_name,salary) VALUES (?,?);";
        jdbcTemplate.update(sql,employee.getEmpName(),employee.getSalary());

    }
}
