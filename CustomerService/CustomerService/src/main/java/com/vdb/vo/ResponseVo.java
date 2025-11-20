package com.vdb.vo;

import com.vdb.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {

    private Customer customer;

    private Product product;

    private Order order;

}
