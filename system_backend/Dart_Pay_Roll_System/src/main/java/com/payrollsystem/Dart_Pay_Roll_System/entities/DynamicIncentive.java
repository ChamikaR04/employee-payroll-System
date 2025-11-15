package com.payrollsystem.Dart_Pay_Roll_System.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dynamic_intcentives")
public class DynamicIncentive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intcentive_id;
    @ManyToOne
    @JoinColumn(name = "empNo")
    private Employee employee;
    private String title;
    private int amount;

}
