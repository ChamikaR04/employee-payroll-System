package com.payrollsystem.Dart_Pay_Roll_System.service;

import com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO;
import com.payrollsystem.Dart_Pay_Roll_System.DTO.PayrollDTO;
import com.payrollsystem.Dart_Pay_Roll_System.entities.DynamicIncentive;
import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;
import com.payrollsystem.Dart_Pay_Roll_System.entities.EmployeeDetails;
import com.payrollsystem.Dart_Pay_Roll_System.entities.EmployeeSalary;
import com.payrollsystem.Dart_Pay_Roll_System.interfaces.PayrollService;
import com.payrollsystem.Dart_Pay_Roll_System.repository.DynamicIntcentiveRepository;
import com.payrollsystem.Dart_Pay_Roll_System.repository.EmployeeDetailsRepository;
import com.payrollsystem.Dart_Pay_Roll_System.repository.EmployeeRepository;
import com.payrollsystem.Dart_Pay_Roll_System.repository.EmployeeSalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PayrollServiceImpl implements PayrollService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    EmployeeSalaryRepository employeeSalaryRepository;

    @Autowired
    DynamicIntcentiveRepository dynamicIncentiveRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public Employee addEmployee(PayrollDTO payrollDTO) {
        Optional<Employee> existing_emp=employeeRepository.findByDisplayName(payrollDTO.getDisplayName());
        if(existing_emp.isPresent()){
            throw new RuntimeException("employee already exists");
        }else {


            Employee emp = modelMapper.map(payrollDTO, Employee.class);
            String combinedContacts = Stream.of(payrollDTO.getMobile1(), payrollDTO.getMobile2())
                    .filter(num -> num != null && !num.isBlank())
                    .collect(Collectors.joining(","));
            emp.setContactNumbers(combinedContacts);
            if (payrollDTO.getImage() != null) {
                try {
                    emp.setImage(payrollDTO.getImage().getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            emp = employeeRepository.save(emp);

            EmployeeDetails empD = modelMapper.map(payrollDTO, EmployeeDetails.class);
            empD.setEmployee(emp);
            employeeDetailsRepository.save(empD);

            EmployeeSalary empS = modelMapper.map(payrollDTO, EmployeeSalary.class);
            empS.setEmployee(emp);
            employeeSalaryRepository.save(empS);

            final Employee savedEmp = emp;


            List<DynamicIncentive> incentives = payrollDTO.getDynamicIncentives().stream()
                    .map(i -> {
                        DynamicIncentive incentive = new DynamicIncentive();
                        incentive.setTitle(i.getTitle());
                        incentive.setAmount(i.getAmount());
                        incentive.setEmployee(savedEmp); // assign the employee FK
                        return incentive;
                    })
                    .collect(Collectors.toList());
            dynamicIncentiveRepository.saveAll(incentives);


            return emp;
        }
    }

    @Override
    public List<EmployeeTableDTO> getAllEmp() {
        List<EmployeeTableDTO> employees = employeeRepository.fetchALLEmployeeData();
        for (EmployeeTableDTO emp : employees) {
            if (emp.getMobile() != null && emp.getMobile().contains(",")) {
                String[] numbers = emp.getMobile().split(",");
                emp.setMobile(numbers[0].trim());
                if (numbers.length > 1) {
                    emp.setMobile2(numbers[1].trim());
                }
            } else {
                emp.setMobile2(null);
            }
            double totalIncentive = calTotalIncentive(emp.getEmp_no());
            emp.setIncentive((int) totalIncentive);

        }
        return employees;
    }


    @Override
    public EmployeeTableDTO getEmpById(int empNo) {
        EmployeeTableDTO emp = employeeRepository.findEmployeeById(empNo);
        if (emp.getMobile() != null) {
            String[] nums = emp.getMobile().split(",");
            emp.setMobile(nums[0]);
            emp.setMobile2(nums.length > 1 ? nums[1] : "");
            emp.setIncentive((calTotalIncentive(empNo)));

        }
        return emp;
    }
    public int calTotalIncentive(int empNo) {
        List<DynamicIncentive> incentives = dynamicIncentiveRepository.findByEmployeeEmpNo(empNo);
        int total = incentives.stream()
                .mapToInt(DynamicIncentive::getAmount)
                .sum();

        return total;

    }

    @Override
    public List<EmployeeTableDTO> getEmpByDep(String department) {
        List<EmployeeTableDTO> employees = employeeRepository.findEmpByDepartment(department);
        for (EmployeeTableDTO emp : employees) {
            if (emp.getMobile() != null && emp.getMobile().contains(",")) {
                String[] numbers = emp.getMobile().split(",");
                emp.setMobile(numbers[0].trim());
                if (numbers.length > 1) {
                    emp.setMobile2(numbers[1].trim());
                }
            } else {
                emp.setMobile2(null);
            }
            double totalIncentive = calTotalIncentive(emp.getEmp_no());
            emp.setIncentive((int) totalIncentive);

        }
        return employees;
    }

}

