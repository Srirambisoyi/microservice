package com.bs.accounts.service.impl;

import com.bs.accounts.constant.AccountsConstants;
import com.bs.accounts.dto.CustomerDto;
import com.bs.accounts.entity.Accounts;
import com.bs.accounts.entity.Customer;
import com.bs.accounts.exception.CustomerAlreadyExistException;
import com.bs.accounts.mapper.CustomerMapper;
import com.bs.accounts.repository.AccountsRepository;
import com.bs.accounts.repository.CustomerRepository;
import com.bs.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
       Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
       if(optionalCustomer.isPresent())
       {
           throw new CustomerAlreadyExistException("Customer alrady present in given mobile number");
       }
       customer.setCreatedAt(LocalDateTime.now());
       customer.setCreatedBy("SYSTEM");
       Customer savedCustomer=customerRepository.save(customer);

       accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer)
    {
        Accounts newAccount=new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("SYSTEM");
        return newAccount;
    }
}
