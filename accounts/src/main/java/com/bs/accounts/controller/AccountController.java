package com.bs.accounts.controller;

import com.bs.accounts.constant.AccountsConstants;
import com.bs.accounts.dto.CustomerDto;
import com.bs.accounts.dto.ResponseDto;
import com.bs.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Validated
public class AccountController {
    private IAccountService iAccountService;

@PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto)
    {
        iAccountService.createAccount(customerDto);
return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountdetails(@RequestParam     @Pattern(regexp = "(^$|[0-9]{10})")
                                                               String mobileNumber)
    {
        CustomerDto customerDto=iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto)
    {
        boolean isupdated=iAccountService.updateAccount(customerDto);
        if(isupdated)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }
        else
        {
            return
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
        }
    }
@DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam     @Pattern(regexp = "(^$|[0-9]{10})")
                                                     String mobileNumber)
    {
        boolean isDelete=iAccountService.deleteAccount(mobileNumber);
        if(isDelete)
        {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_201));
        }
        return
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE));

    }
}
