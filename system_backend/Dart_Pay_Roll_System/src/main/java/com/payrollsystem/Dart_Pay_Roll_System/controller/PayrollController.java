package com.payrollsystem.Dart_Pay_Roll_System.controller;

import com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO;
import com.payrollsystem.Dart_Pay_Roll_System.DTO.PayrollDTO;
import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;
import com.payrollsystem.Dart_Pay_Roll_System.interfaces.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping(value = "/addEmployee",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Employee addEmployee(@RequestPart("data") PayrollDTO payrollDTO, @RequestPart(value = "image", required = false) MultipartFile image) {
        payrollDTO.setImage(image);
        return payrollService.addEmployee(payrollDTO);
    }
    @GetMapping("/getAllEmp")
    public List<EmployeeTableDTO> getAllEMp(){
        return payrollService.getAllEmp();
    }
    @GetMapping("/getEmpById")
    public EmployeeTableDTO getEmpById(@RequestParam int emp_no){
        return payrollService.getEmpById(emp_no);
    }
    @GetMapping("/getEmpByDep")
    public List<EmployeeTableDTO> getEmpByDep(@RequestParam String department){
        return payrollService.getEmpByDep(department);
    }
}
