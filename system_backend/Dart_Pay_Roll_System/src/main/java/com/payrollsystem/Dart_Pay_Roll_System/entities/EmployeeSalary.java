package com.payrollsystem.Dart_Pay_Roll_System.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="emp_salary")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salary_id;
    @OneToOne
    @JoinColumn(name = "empNo")
    private Employee employee;
    private int basic_salary;
    private int budget_allowance;
    private int service_incentive;
    private int special_incentive;
    private int grand_incentive;
    private int transport_fee;
    private int attendance_bonus;
    private int adjustment;
    private boolean ot_allowed;
    private boolean late_allowed;
    private boolean etf_epf_allowed;
}
