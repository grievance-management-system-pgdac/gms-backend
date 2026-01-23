package com.grievance_management.dto;

public class EmployeeRegisterRequest {

    private String empnum;
    private String empname;
    private String empEmail;
    private String department;
    private String role;
    private String address;
    private String contactNum;
    private String password;

    public String getEmpnum() { return empnum; }
    public String getEmpname() { return empname; }
    public String getEmpEmail() { return empEmail; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public String getAddress() { return address; }
    public String getContactNum() { return contactNum; }
    public String getPassword() { return password; }
}
