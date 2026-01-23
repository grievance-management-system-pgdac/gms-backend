package com.grievance_management.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeLoginRequest {

    @NotBlank
    private String empnum;

    @NotBlank
    private String password;

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
