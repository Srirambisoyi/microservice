package com.bs.accounts.service;

import com.bs.accounts.dto.CustomerDto;

public interface IAccountService {

    /*
    * @param CustomerDto-Customer object
     */
    public void createAccount(CustomerDto customerDto);
}
