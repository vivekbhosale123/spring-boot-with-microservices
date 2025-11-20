package com.vdb.service;

import com.vdb.entity.Customer;
import com.vdb.repository.CustomerRepository;
import com.vdb.vo.Order;
import com.vdb.vo.Product;
import com.vdb.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private ProductClient productClient;

    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public ResponseVo findById(long custId)
    {
        ResponseVo responseVo=new ResponseVo();

        Customer customer=customerRepository.findById(custId).get();

        Product product=productClient.findById(customer.getProductId());

        Order order=orderClient.findById(customer.getOrderId());

        responseVo.setCustomer(customer);
        responseVo.setProduct(product);
        responseVo.setOrder(order);

        return responseVo;
    }




    public boolean signIn(String custEmailId,String custPassword)
    {
        boolean flag=false;

        Customer customer=customerRepository.findByCustEmailIdAndCustPassword(custEmailId, custPassword);

        if(customer!=null)
        {
            flag=true;
        }

        return flag;
    }

    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    public Customer update(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public void deleteById(long custId)
    {
        customerRepository.deleteById(custId);
    }

}
