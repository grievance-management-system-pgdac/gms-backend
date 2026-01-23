package com.grievance_management.dto;

public class EmployeeLoginResponse {

    private Integer empId;
    private String empnum;
    private String empname;
    private String role;
    private String message;

    public EmployeeLoginResponse(Integer empId, String empnum, String empname, String role, String message) {
        this.empId = empId;
        this.empnum = empnum;
        this.empname = empname;
        this.role = role;
        this.message = message;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpnum() {
        return empnum;
    }

    public String getEmpname() {
        return empname;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}
