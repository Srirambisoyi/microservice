package com.bs.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Accounts extends BaseEntity{
    @Id
    private Long accountNumber;
    private Long  customerId;
    private String accountType;
    private String branchAddress;

}
