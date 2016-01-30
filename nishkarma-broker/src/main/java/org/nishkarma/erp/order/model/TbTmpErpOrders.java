package org.nishkarma.erp.order.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbTmpErpOrders {
    /**
     * null
     */
    private Integer orderId;

    /**
     * null
     */
    private BigDecimal customerId;

    /**
     * null
     */
    private BigDecimal orderTotal;

    /**
     * null
     */
    private Date orderTimestamp;

    /**
     * null
     */
    private BigDecimal userId;

    /**
     * null
     */
    private BigDecimal frontOrderId;

    /**
     * TB_TMP_ERP_ORDERS.ORDER_ID
     *
     * @return the value of TB_TMP_ERP_ORDERS.ORDER_ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * TB_TMP_ERP_ORDERS.ORDER_ID
     *
     * @param orderId the value for TB_TMP_ERP_ORDERS.ORDER_ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * TB_TMP_ERP_ORDERS.CUSTOMER_ID
     *
     * @return the value of TB_TMP_ERP_ORDERS.CUSTOMER_ID
     */
    public BigDecimal getCustomerId() {
        return customerId;
    }

    /**
     * TB_TMP_ERP_ORDERS.CUSTOMER_ID
     *
     * @param customerId the value for TB_TMP_ERP_ORDERS.CUSTOMER_ID
     */
    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }

    /**
     * TB_TMP_ERP_ORDERS.ORDER_TOTAL
     *
     * @return the value of TB_TMP_ERP_ORDERS.ORDER_TOTAL
     */
    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    /**
     * TB_TMP_ERP_ORDERS.ORDER_TOTAL
     *
     * @param orderTotal the value for TB_TMP_ERP_ORDERS.ORDER_TOTAL
     */
    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * TB_TMP_ERP_ORDERS.ORDER_TIMESTAMP
     *
     * @return the value of TB_TMP_ERP_ORDERS.ORDER_TIMESTAMP
     */
    public Date getOrderTimestamp() {
        return orderTimestamp;
    }

    /**
     * TB_TMP_ERP_ORDERS.ORDER_TIMESTAMP
     *
     * @param orderTimestamp the value for TB_TMP_ERP_ORDERS.ORDER_TIMESTAMP
     */
    public void setOrderTimestamp(Date orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    /**
     * TB_TMP_ERP_ORDERS.USER_ID
     *
     * @return the value of TB_TMP_ERP_ORDERS.USER_ID
     */
    public BigDecimal getUserId() {
        return userId;
    }

    /**
     * TB_TMP_ERP_ORDERS.USER_ID
     *
     * @param userId the value for TB_TMP_ERP_ORDERS.USER_ID
     */
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    /**
     * TB_TMP_ERP_ORDERS.FRONT_ORDER_ID
     *
     * @return the value of TB_TMP_ERP_ORDERS.FRONT_ORDER_ID
     */
    public BigDecimal getFrontOrderId() {
        return frontOrderId;
    }

    /**
     * TB_TMP_ERP_ORDERS.FRONT_ORDER_ID
     *
     * @param frontOrderId the value for TB_TMP_ERP_ORDERS.FRONT_ORDER_ID
     */
    public void setFrontOrderId(BigDecimal frontOrderId) {
        this.frontOrderId = frontOrderId;
    }
}