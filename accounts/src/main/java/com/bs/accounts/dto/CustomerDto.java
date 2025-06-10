package com.bs.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name can not be empty")
    @Size(min = 5,max = 30)
    private String name;

    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobileNumber;
    @NotEmpty(message = "Name can not be empty")
    @Email(message = "Please input valid value")
    private String email;

    private AccountsDto accountsDto;
}
