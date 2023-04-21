package com.MensesTracker.web.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomCycleParameterRequest {

    LocalDate startDate;
    int cycleDays;
    int numberOfPeriodDays;
    int customNumberOfMonths;
}
