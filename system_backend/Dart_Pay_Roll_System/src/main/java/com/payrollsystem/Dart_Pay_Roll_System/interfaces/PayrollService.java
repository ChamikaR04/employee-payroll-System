package com.payrollsystem.Dart_Pay_Roll_System.interfaces;

import com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO;
import com.payrollsystem.Dart_Pay_Roll_System.DTO.PayrollDTO;
import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;

import java.util.List;

public interface PayrollService {
    Employee addEmployee(PayrollDTO payrollDTO);

    List<EmployeeTableDTO> getAllEmp();

    EmployeeTableDTO getEmpById(int empNo);

    List<EmployeeTableDTO> getEmpByDep(String department);
}
