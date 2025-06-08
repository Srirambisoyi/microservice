package com.bs.accounts.mapper;

import com.bs.accounts.dto.AccountsDto;
import com.bs.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts,AccountsDto accountsDto)
    {
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        return accountsDto;
    }
    public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts)
    {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

}
