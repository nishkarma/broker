package org.nishkarma.mall.order.model;

import java.io.Serializable;
import java.util.Date;

public class TbTmpOrder implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4745145707071456560L;

	/**
     * 주문번호
     */
    private Integer ordId;

    /**
     * 상품번호
     */
    private Short goodId;

    /**
     * 주문액
     */
    private Short ordAmt;

    /**
     * 입력일자
     */
    private Date etrDate;

    /**
     * 수정일자
     */
    private Date updateDate;

    /**
     * ERP주문번호
     */
    private Integer erpOrderId;

    /**
     * ERP전송일자
     */
    private Date erpTransDate;

    /**
     * TB_TMP_ORDER.ORD_ID
     *
     * @return the value of TB_TMP_ORDER.ORD_ID
     */
    public Integer getOrdId() {
        return ordId;
    }

    /**
     * TB_TMP_ORDER.ORD_ID
     *
     * @param ordId the value for TB_TMP_ORDER.ORD_ID
     */
    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    /**
     * TB_TMP_ORDER.GOOD_ID
     *
     * @return the value of TB_TMP_ORDER.GOOD_ID
     */
    public Short getGoodId() {
        return goodId;
    }

    /**
     * TB_TMP_ORDER.GOOD_ID
     *
     * @param goodId the value for TB_TMP_ORDER.GOOD_ID
     */
    public void setGoodId(Short goodId) {
        this.goodId = goodId;
    }

    /**
     * TB_TMP_ORDER.ORD_AMT
     *
     * @return the value of TB_TMP_ORDER.ORD_AMT
     */
    public Short getOrdAmt() {
        return ordAmt;
    }

    /**
     * TB_TMP_ORDER.ORD_AMT
     *
     * @param ordAmt the value for TB_TMP_ORDER.ORD_AMT
     */
    public void setOrdAmt(Short ordAmt) {
        this.ordAmt = ordAmt;
    }

    /**
     * TB_TMP_ORDER.ETR_DATE
     *
     * @return the value of TB_TMP_ORDER.ETR_DATE
     */
    public Date getEtrDate() {
        return etrDate;
    }

    /**
     * TB_TMP_ORDER.ETR_DATE
     *
     * @param etrDate the value for TB_TMP_ORDER.ETR_DATE
     */
    public void setEtrDate(Date etrDate) {
        this.etrDate = etrDate;
    }

    /**
     * TB_TMP_ORDER.UPDATE_DATE
     *
     * @return the value of TB_TMP_ORDER.UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * TB_TMP_ORDER.UPDATE_DATE
     *
     * @param updateDate the value for TB_TMP_ORDER.UPDATE_DATE
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * TB_TMP_ORDER.ERP_ORDER_ID
     *
     * @return the value of TB_TMP_ORDER.ERP_ORDER_ID
     */
    public Integer getErpOrderId() {
        return erpOrderId;
    }

    /**
     * TB_TMP_ORDER.ERP_ORDER_ID
     *
     * @param erpOrderId the value for TB_TMP_ORDER.ERP_ORDER_ID
     */
    public void setErpOrderId(Integer erpOrderId) {
        this.erpOrderId = erpOrderId;
    }

    /**
     * TB_TMP_ORDER.ERP_TRANS_DATE
     *
     * @return the value of TB_TMP_ORDER.ERP_TRANS_DATE
     */
    public Date getErpTransDate() {
        return erpTransDate;
    }

    /**
     * TB_TMP_ORDER.ERP_TRANS_DATE
     *
     * @param erpTransDate the value for TB_TMP_ORDER.ERP_TRANS_DATE
     */
    public void setErpTransDate(Date erpTransDate) {
        this.erpTransDate = erpTransDate;
    }
}