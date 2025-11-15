package com.payrollsystem.Dart_Pay_Roll_System.repository;


import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;
import com.payrollsystem.Dart_Pay_Roll_System.entities.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer> {

}
