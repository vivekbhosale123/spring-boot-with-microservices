package com.vdb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_DETAIL")
public class Order {

    @Id
    private long orderId;

    @Size(min =2,message = "Order Description must be 2 characters")
    private String orderDescription;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderStartDate;

}
