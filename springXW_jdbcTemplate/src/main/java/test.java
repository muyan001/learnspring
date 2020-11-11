import mybean.Employee;
import mydao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) throws SQLException {

        // 123




        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean.getConnection());

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = applicationContext.getBean(NamedParameterJdbcTemplate.class);
        System.out.println(jdbcTemplate);


        /***
         *  实验2：将emp_id=5的记录的salary字段更新为1300.00
         */

//        String sql = "update employee set salary = ? WHERE emp_id = ?;";
//        int update = jdbcTemplate.update(sql, 1300.00, 5);
//        System.out.println("更新员工：影响了多少行："+update);


        /**
         *  实验3：批量插入
         */

//        String batch = "INSERT INTO employee(emp_name,salary) VALUES (?,?);";
//
////        List<Object[]> 的长度就是要执行的次数，Object[]就是每次要执行的参数
//        List<Object[]> batchInsert = new ArrayList<Object[]>();
//        batchInsert.add(new Object[]{"张三","998.98"});
//        batchInsert.add(new Object[]{"李四","1998.98"});
//        batchInsert.add(new Object[]{"王五","2998.98"});
//        batchInsert.add(new Object[]{"赵六","3998.98"});
//        int[] ints = jdbcTemplate.batchUpdate(batch, batchInsert);
//        for(int i :ints){
//            System.out.println(i);
//        }

        /**
         *
         *  实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
         *
         *  javaBean需要和数据库中字段名一致，否则没发完成封装。
         *
         *  jdbcTemplate在方法级别进行了区分
         *  查询集合：jdbcTemplate.query();
         *  查询单个对象：jdbcTemplate.queryForObject()
         *  实验5：查询salary>4000的数据库记录，封装为List集合返回
         */


//        String sql4 = "select emp_id as empId, emp_name as empName,salary FROM employee WHERE emp_id = ?;";
//
//        // rowMapper:每一行记录和javabean属性如何映射
//        //  如何查询没结果会直接报错
//        Employee employee = jdbcTemplate.queryForObject(sql4, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
//        System.out.println(employee);


        /**
         * 实验5：查询salary>4000的数据库记录，封装为List集合返回
         */

        String sql5= "select emp_id as empId, emp_name as empName,salary FROM employee WHERE salary > ?;";

        List<Employee> employees = jdbcTemplate.query(sql5, new BeanPropertyRowMapper<Employee>(Employee.class), 4000);

        for (Employee employee:employees){
            System.out.println(employee);
        }


        /**
         *  实验6：查询最大salary
         */


        String sql6= "SELECT MAX(salary) FROM employee;";
        // 无论返回单个数据还是单个对象，都是调用jdbcTemplate.queryForObject()
        Double aDouble = jdbcTemplate.queryForObject(sql6, Double.class);
        System.out.println(aDouble);


        /**
         *  实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
         *
         *  具名参数：（具有名称的参数，参数不是占位符了，而是一个变量名）
         *      语法：    ：参数名
         *
         * spring有一个支持具名参数的jdbcTemplate
         *
         *  占位符参数： ？的顺序千万不能乱，传参数的时候一定要注意。
         */

        String sql7 = "INSERT INTO employee(emp_name,salary) VALUES (:empName,:salary);";

//        Map<String,Object> emp = new HashMap<String, Object>();
//        emp.put("empName","田七1");
//        emp.put("salary",9999.1);
//
//        int i = namedParameterJdbcTemplate.update(sql7, emp);
//
//        System.out.println(i);

        /**
         *   实验8：重复实验7，以SqlParameterSource形式传入参数值
         */


        String sql8 = "INSERT INTO employee(emp_name,salary) VALUES (:empName,:salary);";

//        Employee employee = new Employee();
//        employee.setEmpName("你好呀");
//        employee.setSalary(1789.2);
//
//        int i = namedParameterJdbcTemplate.update(sql8, new BeanPropertySqlParameterSource(employee));
//        System.out.println(i);


        /**
         *  实验9：创建BookDao，自动装配JdbcTemplate对象
         */


        EmployeeDao dao = applicationContext.getBean(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setEmpName("你好呀,我叫哈哈");
        employee.setSalary(19089.2);
        dao.saveEmplyee(employee);


    }
}


