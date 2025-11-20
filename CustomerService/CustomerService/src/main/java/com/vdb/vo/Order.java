package com.vdb.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long orderId;

    @Size(min =2,message = "Order Description must be 2 characters")
    private String orderDescription;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderStartDate;

}
