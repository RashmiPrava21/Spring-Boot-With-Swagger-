package com.java.springbootstarter;

import com.springbootswagger.exceptions.EmployeeNotFoundException;
import com.springbootswagger.exceptions.InvalidEmployeeRecord;
import javafx.beans.InvalidationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<EmployeeAccount> employees = new ArrayList<EmployeeAccount>();

 /*   static{

        EmployeeAccount employeeAccount1 = new EmployeeAccount("1001", "rashmi","patro","rpatro1@umbc.edu","3016756506","RP123",90000.0f,"MN146","DP256");
        EmployeeAccount employeeAccount2 = new EmployeeAccount("1002", "shilpa","dhandhan","shdilab1@umbc.edu","3016756506","VB123",90000.0f,"CP3546","DI256");

         employees.add(employeeAccount1);
        employees.add(employeeAccount2);

    }
*/
    public List<EmployeeAccount> retieveAllEmployees(){
        return employees;
    }

    public EmployeeAccount retrieveEmployeeByID(String employeeid){

        for(EmployeeAccount employee : employees){
            if(employee.getEmployeeID().equals(employeeid)){
                return employee;
            }
        }

        throw new EmployeeNotFoundException("Employee doesn't exist!!", null);

    }

    public EmployeeAccount insertNewEmployee(EmployeeAccount employeeAccount) {

        EmployeeAccount employee = new EmployeeAccount();

        if(employeeAccount != null){
            employee.setEmployeeID(EmployeeIDGenerator.getId());
            employee.setEmployeeFirstName(employeeAccount.getEmployeeFirstName());
            employee.setEmployeeLastName(employeeAccount.getEmployeeLastName());
            employee.setEmployeeEmail(employeeAccount.getEmployeeEmail());
            employee.setEmployeeJobID(employeeAccount.getEmployeeJobID());
            employee.setEmployeePhoneNumber(employeeAccount.getEmployeePhoneNumber());
            employee.setEmployeeSalary(employeeAccount.getEmployeeSalary());
            employee.setEmployeeManagerID(employeeAccount.getEmployeeManagerID());
            employee.setEmployeeDepartmentID(employeeAccount.getEmployeeDepartmentID());

            employees.add(employee);
            return employee;
        }

        throw new InvalidEmployeeRecord("Employee record doesn't exist", null);

    }

    public EmployeeAccount updateEmployeeByID(String empID){

        for(EmployeeAccount employeeAccount : employees){

            if(employeeAccount.getEmployeeID().equals(empID) && employeeAccount.getEmployeeFirstName() != null){
                employeeAccount.setEmployeeFirstName("Happy");
                return employeeAccount;
            }

        }

        return null;

    }

    public void deleteEmployeeByID(String empID){

        EmployeeAccount employeeAccountExisting = new EmployeeAccount();
        for(EmployeeAccount emp : employees){

            if(emp.getEmployeeID().equals(empID)){
                employeeAccountExisting = emp;
                break;
            }

        }

        if(!employeeAccountExisting.equals(null)){
            employees.remove(employeeAccountExisting);
        }else{
            throw new EmployeeNotFoundException("Employee ID doesn't exist!!", null);
        }

    }

}
