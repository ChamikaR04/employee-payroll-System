package com.payrollsystem.Dart_Pay_Roll_System.repository;

import com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO;
import com.payrollsystem.Dart_Pay_Roll_System.entities.Employee;
import com.payrollsystem.Dart_Pay_Roll_System.entities.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByDisplayName(String displayName);

    @Query("SELECT new com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO(" +
            "e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, " +
            "e.contactNumbers, e.contactNumbers, " + // both will be split later in service
            "e.address, e.category, ed.department, ed.epf_no," +
            "es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, " +
            "es.ot_allowed, es.late_allowed, es.etf_epf_allowed) " +
            "FROM Employee e " +
            "JOIN e.employeeDetails ed " +
            "JOIN e.employeeSalary es " +
            "LEFT JOIN e.dynamicIncentives di " +
            "GROUP BY e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, e.contactNumbers, " +
            "e.address, e.category, es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, es.ot_allowed, es.late_allowed, es.etf_epf_allowed")
    List<EmployeeTableDTO> fetchALLEmployeeData();

    @Query("SELECT new com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO(" +
            "e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, " +
            "e.contactNumbers, e.contactNumbers, " + // both will be split later in service
            "e.address, e.category, ed.department, ed.epf_no, " +
            "es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, " +
            "es.ot_allowed, es.late_allowed, es.etf_epf_allowed) " +
            "FROM Employee e " +
            "JOIN e.employeeDetails ed " +
            "JOIN e.employeeSalary es " +
            "LEFT JOIN e.dynamicIncentives di " +
            "WHERE e.empNo = :emp_no " +
            "GROUP BY e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, e.contactNumbers, " +
            "e.address, e.category, es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, es.ot_allowed, es.late_allowed, es.etf_epf_allowed")
    EmployeeTableDTO findEmployeeById(@Param("emp_no") int empNo);



    @Query("SELECT new com.payrollsystem.Dart_Pay_Roll_System.DTO.EmployeeTableDTO(" +
            "e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, " +
            "e.contactNumbers, e.contactNumbers, " + // both will be split later in service
            "e.address, e.category, ed.department, ed.epf_no, " +
            "es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, " +
            "es.ot_allowed, es.late_allowed, es.etf_epf_allowed) " +
            "FROM Employee e " +
            "JOIN e.employeeDetails ed " +
            "JOIN e.employeeSalary es " +
            "LEFT JOIN e.dynamicIncentives di " +
            "WHERE ed.department = :department " +
            "GROUP BY e.empNo, e.displayName, e.f_name, e.m_name, e.l_name, e.nic, e.contactNumbers, " +
            "e.address, e.category, es.basic_salary, es.budget_allowance, " +
            "es.special_incentive, es.service_incentive, es.grand_incentive, " +
            "es.transport_fee, es.attendance_bonus, es.ot_allowed, es.late_allowed, es.etf_epf_allowed")
    List<EmployeeTableDTO> findEmpByDepartment(@Param("department") String department);

}
