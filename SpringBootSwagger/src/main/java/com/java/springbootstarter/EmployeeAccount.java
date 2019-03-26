package com.java.springbootstarter;

public class EmployeeAccount {

    private String employeeID;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private String employeeJobID;
    private Float employeeSalary;
    private String employeeManagerID;
    private String employeeDepartmentID;

    public EmployeeAccount(){

    }

    public EmployeeAccount(String employeeID, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhoneNumber,
                                                            String employeeJobID, Float employeeSalary, String employeeManagerID, String employeeDepartmentID){

        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeJobID = employeeJobID;
        this.employeeSalary = employeeSalary;
        this.employeeManagerID = employeeManagerID;
        this.employeeDepartmentID = employeeDepartmentID;

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeJobID() {
        return employeeJobID;
    }

    public void setEmployeeJobID(String employeeJobID) {
        this.employeeJobID = employeeJobID;
    }

    public Float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeManagerID() {
        return employeeManagerID;
    }

    public void setEmployeeManagerID(String employeeManagerID) {
        this.employeeManagerID = employeeManagerID;
    }

    public String getEmployeeDepartmentID() {
        return employeeDepartmentID;
    }

    public void setEmployeeDepartmentID(String employeeDepartmentID) {
        this.employeeDepartmentID = employeeDepartmentID;
    }

    public String toString(){

        return "Employee ID: "+ employeeID + "First Name: "+ employeeFirstName + "Last Name: "+ employeeLastName + "Email ID: "+ employeeEmail +
                        "Phone: "+ employeePhoneNumber+ "Job ID: "+ employeeJobID + "Salary: "+ employeeSalary + "Manager ID: "+ employeeManagerID +
                "Department ID: "+ employeeDepartmentID;

    }
}
