package com.payrollsystem.Dart_Pay_Roll_System.repository;

import com.payrollsystem.Dart_Pay_Roll_System.entities.DynamicIncentive;
import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicIntcentiveRepository extends JpaRepository<DynamicIncentive, Integer> {
    @Query("SELECT SUM(CAST(d.amount AS int)) FROM DynamicIncentive d WHERE d.employee = :employee")
    Integer getTotalIncentiveByEmployee(@Param("employee") Employee employee);

    List<DynamicIncentive> findByEmployeeEmpNo(int emp_no);


}
