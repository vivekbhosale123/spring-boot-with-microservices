package com.vdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    private long custId;

    @Size(min = 2,message = "custmer name should be 2 character at least")
    private String custName;

    private String custAddress;

    @Range(min = 1000000000,max = 9999999999L,message = "Number should be 10 digits")
    private long custContactNumber;

    @Email(message = "email should be proper the way email")
    private String custEmailId;

    private String custPassword;

    private long orderId;

    private long productId;

}

