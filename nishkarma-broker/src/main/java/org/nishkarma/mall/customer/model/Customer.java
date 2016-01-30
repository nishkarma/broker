package org.nishkarma.mall.customer.model;

import java.math.BigDecimal;

public class Customer {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * null
     */
    private BigDecimal version;

    /**
     * null
     */
    private String name;

    /**
     * null
     */
    private BigDecimal credit;

    /**
     * CUSTOMER.ID
     *
     * @return the value of CUSTOMER.ID
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * CUSTOMER.ID
     *
     * @param id the value for CUSTOMER.ID
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * CUSTOMER.VERSION
     *
     * @return the value of CUSTOMER.VERSION
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * CUSTOMER.VERSION
     *
     * @param version the value for CUSTOMER.VERSION
     */
    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    /**
     * CUSTOMER.NAME
     *
     * @return the value of CUSTOMER.NAME
     */
    public String getName() {
        return name;
    }

    /**
     * CUSTOMER.NAME
     *
     * @param name the value for CUSTOMER.NAME
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * CUSTOMER.CREDIT
     *
     * @return the value of CUSTOMER.CREDIT
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * CUSTOMER.CREDIT
     *
     * @param credit the value for CUSTOMER.CREDIT
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
    
	public Customer increaseCreditBy(BigDecimal sum) {
		Customer newCredit = new Customer();
		newCredit.credit = this.credit.add(sum);
		newCredit.name = this.name;
		newCredit.id = this.id;
		return newCredit;
	}
    
}