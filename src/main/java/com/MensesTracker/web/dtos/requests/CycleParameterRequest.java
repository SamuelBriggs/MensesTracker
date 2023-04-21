package com.MensesTracker.web.dtos.requests;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CycleParameterRequest {

    String startDate;
    int cycleDays;
    int numberOfPeriodDays;
}