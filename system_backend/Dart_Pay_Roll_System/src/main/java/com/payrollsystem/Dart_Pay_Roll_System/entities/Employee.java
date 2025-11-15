package com.payrollsystem.Dart_Pay_Roll_System.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;
    private String displayName;
    private String f_name;
    private String m_name;
    private String l_name;
    private String nic;
    private String email;
    private String qualification;
    private String gender;
    private String civil_status;
    @Column(name = "cont_numbers")
    private String contactNumbers;
    private String address;
    private String category;
    private byte[] image;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeSalary employeeSalary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<DynamicIncentive> dynamicIncentives;

}
