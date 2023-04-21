package com.MensesTracker.web.dtos.requests;

import com.MensesTracker.web.models.Cycle;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class UserDtoRequests {
    private Long id;
    private String name;
    private String password;
    private String eMail;

}
