package com.java.springbootstarter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping(value = "/employees", produces = "application/json")
@Api(value = "EmployeeAPI", description = "Rest API for employees", tags = {"Employee"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/getemployees")
    @ApiOperation("Details of all the employees")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = EmployeeAccount.class)})
    public List<EmployeeAccount> getAllEmployees(){
        return employeeService.retieveAllEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation("Extract employee information by employee id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = EmployeeAccount.class)})
    public EmployeeAccount getEmployeeByID(@PathVariable ("id") String employeeid){
        return employeeService.retrieveEmployeeByID(employeeid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertemployee")
    @ApiOperation("Insert a new employee record")
    @ResponseBody
    public EmployeeAccount insertRecord(@RequestBody EmployeeAccount employeeAccount){
        EmployeeAccount emp = employeeService.insertNewEmployee(employeeAccount);
        return emp;
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/updateemployee/{id}")
    @ApiOperation("Update existing employee record")
    @ResponseBody
    public EmployeeAccount updateRecord(@PathVariable("id") String employeeid){
        return employeeService.updateEmployeeByID(employeeid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{eid}")
    @ApiOperation("Delete an employee record")
    @ResponseBody
    public void removeRecord(@PathVariable("eid") String empid){
        employeeService.deleteEmployeeByID(empid);
    }
}
