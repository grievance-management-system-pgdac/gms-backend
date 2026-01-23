package com.grievance_management.service;

import com.grievance_management.dto.EmployeeLoginRequest;
import com.grievance_management.dto.EmployeeLoginResponse;
import com.grievance_management.dto.EmployeeRegisterRequest;
import com.grievance_management.entity.Employee;
import com.grievance_management.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // ================= REGISTER =================
    @Transactional
    public Employee registerEmployee(EmployeeRegisterRequest request) {

        System.out.println("STEP 1: Registration started");

        // Required for DB triggers
        entityManager.createNativeQuery("SET @actor_id = 'E001'").executeUpdate();
        entityManager.createNativeQuery("SET @actor_role = 'EMPLOYEE'").executeUpdate();
        System.out.println("STEP 2: MySQL session variables set");

        Employee emp = new Employee();

        emp.setEmpnum(request.getEmpnum());
        emp.setEmpname(request.getEmpname());
        emp.setEmpEmail(request.getEmpEmail());
        emp.setDepartment(request.getDepartment());
        emp.setRole(request.getRole());
        emp.setAddress(request.getAddress());
        emp.setContactNum(request.getContactNum());
        emp.setPassword(request.getPassword());

        System.out.println("STEP 3: Entity populated");

        Employee saved = repository.save(emp);

        System.out.println("STEP 4: Employee saved with empnum = " + saved.getEmpnum());

        return saved;
    }

    // ================= LOGIN =================
    public EmployeeLoginResponse login(EmployeeLoginRequest request) {

        System.out.println("LOGIN: Step 1 → Login started");
        System.out.println("LOGIN: empnum = " + request.getEmpnum());

        Employee employee = repository.findByEmpnum(request.getEmpnum())
                .orElseThrow(() -> {
                    System.out.println("LOGIN ERROR: empnum not found");
                    return new RuntimeException("Invalid empnum or password");
                });

        System.out.println("LOGIN: Step 2 → Employee found");

        if (!employee.getPassword().equals(request.getPassword())) {
            System.out.println("LOGIN ERROR: Password mismatch");
            throw new RuntimeException("Invalid empnum or password");
        }

        System.out.println("LOGIN: Step 3 → Password matched");
        System.out.println("LOGIN SUCCESS");

        return new EmployeeLoginResponse(
                employee.getEmpId(),
                employee.getEmpnum(),
                employee.getEmpname(),
                employee.getRole(),
                "Login successful"
        );
    }
}
