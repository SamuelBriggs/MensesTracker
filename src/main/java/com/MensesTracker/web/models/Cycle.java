package com.MensesTracker.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name= "cycles")
public class Cycle {
    // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;
    private Month monthInEffect;
    private LocalDate startDay;
    private LocalDate ovulationDay;
    private LocalDate endingDay;
    private List<LocalDate> periodDays;
    private List<LocalDate> safePeriod;
    private List<LocalDate> fertileWindow;

    public Month getMonthInEffect() {
        return monthInEffect;
    }

    public void setMonthInEffect(Month monthInEffect) {
        this.monthInEffect = monthInEffect;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getOvulationDay() {
        return ovulationDay;
    }

    public void setOvulationDay(LocalDate ovulationDay) {
        this.ovulationDay = ovulationDay;
    }

    public LocalDate getEndingDay() {
        return endingDay;
    }

    public void setEndingDay(LocalDate endingDay) {
        this.endingDay = endingDay;
    }

    public List<LocalDate> getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(List<LocalDate> periodDays) {
        this.periodDays = periodDays;
    }

    public List<LocalDate> getSafePeriod() {
        return safePeriod;
    }

    public void setSafePeriod(List<LocalDate> safePeriod) {
        this.safePeriod = safePeriod;
    }

    public List<LocalDate> getFertileWindow() {
        return fertileWindow;
    }

    public void setFertileWindow(List<LocalDate> fertileWindow) {
        this.fertileWindow = fertileWindow;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "MonthInEffect=" + monthInEffect +
                ", startDay=" + startDay +
                ", ovulationDay=" + ovulationDay +
                ", endingDay=" + endingDay +
                ", periodDays=" + periodDays +
                ", safePeriod=" + safePeriod +
                ", fertileWindow=" + fertileWindow +
                '}';
    }
}
