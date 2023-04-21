package com.MensesTracker.web.controller;

import com.MensesTracker.web.dtos.requests.CycleParameterRequest;
import com.MensesTracker.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Service
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/calculateCycle")
    public ResponseEntity<?> calculateCycle(@RequestBody CycleParameterRequest cycleParameterRequest){
        return new ResponseEntity<>(userService.calculateCycleFor12Months(cycleParameterRequest), HttpStatus.CREATED);
    }



}
