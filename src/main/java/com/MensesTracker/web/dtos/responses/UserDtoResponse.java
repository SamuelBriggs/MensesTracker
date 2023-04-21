package com.MensesTracker.web.dtos.responses;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDtoResponse {
    private Long id;
    private String name;
    private String eMail;

}
