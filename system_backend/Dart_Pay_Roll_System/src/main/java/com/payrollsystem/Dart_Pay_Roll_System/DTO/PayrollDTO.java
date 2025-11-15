package com.payrollsystem.Dart_Pay_Roll_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PayrollDTO {
    private String displayName;
    private String f_name;
    private String m_name;
    private String l_name;
    private String nic;
    private String email;
    private String qualification;
    private String gender;
    private String civil_status;
    private String mobile1;
    private String mobile2;
    private String address;
    private String category;
    private MultipartFile image;

    private String epf_no;
    private LocalDate join_date;
    private LocalDate resign_date;
    private String department;
    private String salary_status;
    private String bank;
    private String branch;
    private String account_number;
    private String remarks;

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

    private List<DynamicIncentiveDTO> dynamicIncentives = new ArrayList<>();
}
