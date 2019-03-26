package com.java.springbootstarter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

public class EmployeeServiceTest {

    EmployeeAccount employeeAccount;
    EmployeeService employeeService;
    EmployeeAccount savedAccount;

    @Before
    public void init(){

        employeeAccount = new EmployeeAccount();
        employeeService = new EmployeeService();

    }

    @Test
    public void testRetieveAllEmployees(){
        EmployeeAccount newEmployee1 = new EmployeeAccount(EmployeeIDGenerator.getId(), "nithin", "chandrashekhar", "ncc@umbc.edu", "7879-97", "MM098", 90079.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee2 = new EmployeeAccount(EmployeeIDGenerator.getId(), "rashmi", "patro", "rpp@umbc.edu", "7879-97", "MM098", 98579.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee3 = new EmployeeAccount(EmployeeIDGenerator.getId(), "vikram", "battina", "vmbb@umbc.edu", "7879-97", "MM098", 100079.0f, "Mng987", "DP09");

        employeeService.insertNewEmployee(newEmployee1);
        employeeService.insertNewEmployee(newEmployee2);
        employeeService.insertNewEmployee(newEmployee3);
        Assert.assertEquals(employeeService.retieveAllEmployees().size(), 3);
    }

    @Test
    public void testInsertNewEmployee(){

        try{
            EmployeeAccount newEmployee = new EmployeeAccount(EmployeeIDGenerator.getId(), "nithin", "chandrashekhar", "ncc@umbc.edu", "7879-97", "MM098", 90079.0f, "Mng987", "DP09");
            savedAccount = employeeService.insertNewEmployee(newEmployee);
        }catch (RuntimeException e){
            Assert.fail(e.getMessage());
        }

   }

    @Test
    public void testRetrieveEmployeeByID(){
        EmployeeAccount newEmployee = new EmployeeAccount(EmployeeIDGenerator.getId(), "nithin", "chandrashekhar", "ncc@umbc.edu", "7879-97", "MM098", 90079.0f, "Mng987", "DP09");
        EmployeeAccount expected = employeeService.insertNewEmployee(newEmployee);
        EmployeeAccount actual = employeeService.retrieveEmployeeByID(expected.getEmployeeID());
        Assert.assertSame(expected, actual);
    }

    @Test
    public void testUpdateEmployeeByID(){
        EmployeeAccount newEmployee1 = new EmployeeAccount(EmployeeIDGenerator.getId(), "nithin", "chandrashekhar", "ncc@umbc.edu", "7879-97", "MM098", 90079.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee2 = new EmployeeAccount(EmployeeIDGenerator.getId(), "rashmi", "patro", "rpp@umbc.edu", "7879-97", "MM098", 98579.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee3 = new EmployeeAccount(EmployeeIDGenerator.getId(), "vikram", "battina", "vmbb@umbc.edu", "7879-97", "MM098", 100079.0f, "Mng987", "DP09");

        EmployeeAccount saved1 = employeeService.insertNewEmployee(newEmployee1);
        EmployeeAccount saved2 = employeeService.insertNewEmployee(newEmployee2);
        EmployeeAccount saved3 = employeeService.insertNewEmployee(newEmployee3);

        EmployeeAccount updated1 = employeeService.updateEmployeeByID(saved1.getEmployeeID());
        EmployeeAccount updated2 = employeeService.updateEmployeeByID(saved2.getEmployeeID());
        EmployeeAccount updated3 = employeeService.updateEmployeeByID(saved3.getEmployeeID());

        Assert.assertEquals(updated1.getEmployeeFirstName(), "Happy");
        Assert.assertEquals(updated2.getEmployeeFirstName(), "Happy");
        Assert.assertEquals(updated3.getEmployeeFirstName(), "Happy");

    }

    @Test
    public void testDeleteEmployeeByID(){

        EmployeeAccount newEmployee1 = new EmployeeAccount(EmployeeIDGenerator.getId(), "nithin", "chandrashekhar", "ncc@umbc.edu", "7879-97", "MM098", 90079.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee2 = new EmployeeAccount(EmployeeIDGenerator.getId(), "rashmi", "patro", "rpp@umbc.edu", "7879-97", "MM098", 98579.0f, "Mng987", "DP09");
        EmployeeAccount newEmployee3 = new EmployeeAccount(EmployeeIDGenerator.getId(), "vikram", "battina", "vmbb@umbc.edu", "7879-97", "MM098", 100079.0f, "Mng987", "DP09");

        EmployeeAccount saved1 = employeeService.insertNewEmployee(newEmployee1);
        EmployeeAccount saved2 = employeeService.insertNewEmployee(newEmployee2);
        EmployeeAccount saved3 = employeeService.insertNewEmployee(newEmployee3);

        employeeService.deleteEmployeeByID(saved1.getEmployeeID());
        Assert.assertEquals(employeeService.retieveAllEmployees().size(), 2);

    }

}
