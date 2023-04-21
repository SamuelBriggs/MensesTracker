package com.MensesTracker.web.service;

import com.MensesTracker.web.dtos.requests.CycleParameterRequest;
import com.MensesTracker.web.dtos.responses.UserDtoResponse;
import com.MensesTracker.web.models.Cycle;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    List<UserDtoResponse> findAllUsers();

    List<Cycle> calculateCycleFor12Months(CycleParameterRequest cycleParameterRequest);
}
