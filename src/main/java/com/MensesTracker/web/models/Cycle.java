package com.MensesTracker.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cycles")
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDay;
    private LocalDate ovulationDay;
    private LocalDate endingDay;
    private List<LocalDate> periodDays;
    private List<LocalDate> safePeriod;
    private List<LocalDate> fertileWindow;

}
