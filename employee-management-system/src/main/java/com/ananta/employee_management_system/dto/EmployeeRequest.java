package com.ananta.employee_management_system.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class EmployeeRequest {

    @NotBlank
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String department;
    @Positive
    private double salary;
}
