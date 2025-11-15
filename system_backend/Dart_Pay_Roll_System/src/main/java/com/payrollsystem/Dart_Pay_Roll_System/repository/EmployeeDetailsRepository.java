package com.payrollsystem.Dart_Pay_Roll_System.repository;

import com.payrollsystem.Dart_Pay_Roll_System.entities.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {
}
