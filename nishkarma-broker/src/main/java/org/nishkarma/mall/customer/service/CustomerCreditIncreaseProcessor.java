/*
 * Copyright 2006-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nishkarma.mall.customer.service;

import java.math.BigDecimal;

import org.nishkarma.mall.customer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Increases customer's credit by a fixed amount.
 * 
 * @author Robert Kasanicky
 */
public class CustomerCreditIncreaseProcessor implements
		ItemProcessor<Customer, Customer> {

	private Logger logger = LoggerFactory
			.getLogger(CustomerCreditIncreaseProcessor.class);

	private BigDecimal fixedAmount;

	@Override
	public Customer process(Customer item) throws Exception {
		return item.increaseCreditBy(fixedAmount);
	}

	public void setFixedAmount(long fixedAmount) {
		logger.debug("setFixedAmount-{}", fixedAmount);
		
		this.fixedAmount = new BigDecimal(fixedAmount);
	}

}
