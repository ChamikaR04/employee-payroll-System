package com.payrollsystem.Dart_Pay_Roll_System.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "emp_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int details_id;
    @OneToOne
    @JoinColumn(name = "empNo")
    private Employee employee;
    private String epf_no;
    private LocalDate join_date;
    private LocalDate resign_date;
    private String department;
    private String salary_status;
    private String bank;
    private String branch;
    private String account_number;
    private String remarks;

    public void getJoin_date(LocalDate joinDate) {
    }
}
