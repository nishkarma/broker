package org.nishkarma.mall.customer.repository;

import java.math.BigDecimal;
import java.util.List;

import org.nishkarma.mall.customer.model.Customer;

public interface CustomerMapper {
	
	BigDecimal getAllCustomerCreditIds();

    List<Customer> getAllCustomerCredits();

    Customer getCustomerCreditById(BigDecimal id);

    int updateByPrimaryKey(Customer customer);
}