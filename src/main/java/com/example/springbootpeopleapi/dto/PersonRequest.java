package com.example.springbootpeopleapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class PersonRequest {
    @NotEmpty(message = "name should not be null")
    private String name;
    @NotEmpty(message = "surname should not be null")
    private String surname;
    private int age;
}
