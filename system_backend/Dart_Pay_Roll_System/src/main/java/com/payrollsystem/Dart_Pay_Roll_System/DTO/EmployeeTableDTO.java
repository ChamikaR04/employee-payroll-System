package com.payrollsystem.Dart_Pay_Roll_System.DTO;

import lombok.Data;

@Data
public class EmployeeTableDTO {
    private int emp_no;
    private String displayName;
    private String f_name;
    private String m_name;
    private String l_name;
    private String nic;
    private String mobile;
    private String mobile2;
    private String address;
    private String designation;
    private String department;
    private String epf_no;
    private int basic_salary;
    private int daily_salary;
    private int budget_allowance;
    private int incentive;
    private int special_incentive;
    private int service_incentive;
    private int grand_incentive;
    private int transport_fee;
    private int attendance_bonus;
    private boolean ot_allowed;
    private boolean late_allowed;
    private boolean etf_epf_allowed;


    public EmployeeTableDTO(int emp_no, String displayName, String f_name, String m_name, String l_name, String nic, String mobile, String mobile2, String address, String designation, String department,String epf_no,int basic_salary, int budget_allowance, int special_incentive, int service_incentive, int grand_incentive, int transport_fee, int attendance_bonus, boolean ot_allowed, boolean late_allowed, boolean etf_epf_allowed) {
        this.emp_no = emp_no;
        this.displayName = displayName;
        this.f_name = f_name;
        this.m_name = m_name;
        this.l_name = l_name;
        this.nic = nic;
        this.mobile = mobile;
        this.mobile2 = mobile2;
        this.address = address;
        this.designation = designation;
        this.department = department;
        this.epf_no = epf_no;
        this.basic_salary = basic_salary;
        this.daily_salary = basic_salary/12;
        this.budget_allowance = budget_allowance;
        this.special_incentive = special_incentive;
        this.service_incentive = service_incentive;
        this.grand_incentive = grand_incentive;
        this.transport_fee = transport_fee;
        this.attendance_bonus = attendance_bonus;
        this.ot_allowed = ot_allowed;
        this.late_allowed = late_allowed;
        this.etf_epf_allowed = etf_epf_allowed;
    }



}
