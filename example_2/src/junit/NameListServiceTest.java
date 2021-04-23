package junit;

import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {
    @Test
    public void testAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] allEmployee = nameListService.getAllEmployee();
        for (Employee employee : allEmployee) {
            System.out.println(employee);// 打印每个成员
        }

    }

    @Test
    public void testGetEmployee(){
        NameListService nameListService = new NameListService();
        Employee employee = null;
        try {
            employee = nameListService.getEmployee(10);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());;
        }

    }
}
