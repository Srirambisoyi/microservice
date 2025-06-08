package com.bs.accounts.controller;

import com.bs.accounts.constant.AccountsConstants;
import com.bs.accounts.dto.AccountsDto;
import com.bs.accounts.dto.CustomerDto;
import com.bs.accounts.dto.ResponseDto;
import com.bs.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class AccountController {
    private IAccountService iAccountService;

@PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto)
    {
        iAccountService.createAccount(customerDto);
return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }
}
