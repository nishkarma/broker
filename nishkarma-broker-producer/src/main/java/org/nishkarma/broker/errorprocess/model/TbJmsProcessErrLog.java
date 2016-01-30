package org.nishkarma.broker.errorprocess.model;

import java.util.Date;

public class TbJmsProcessErrLog {
    /**
     * error log seq
     */
    private Long errorLogId;

    /**
     * Queue Name
     */
    private String queueName;

    /**
     * Error Stage
     */
    private Short errorStage;

    /**
     * related id
     */
    private Long relId;

    /**
     * related seq
     */
    private Short relSeq;

    /**
     * P:Producer, C:Consumer
     */
    private String jmsType;

    /**
     * process status: 0 - initial, 1:processing, 2:complete
     */
    private Short status;

    /**
     * error yn:Y/N
     */
    private String errorYn;

    /**
     * retry count
     */
    private Short retryCnt;

    /**
     * error message
     */
    private String errorMessage;

    /**
     * entered date
     */
    private Date etrDate;

    /**
     * modified date
     */
    private Date updateDate;

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_LOG_ID
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.ERROR_LOG_ID
     */
    public Long getErrorLogId() {
        return errorLogId;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_LOG_ID
     *
     * @param errorLogId the value for TB_JMS_PROCESS_ERR_LOG.ERROR_LOG_ID
     */
    public void setErrorLogId(Long errorLogId) {
        this.errorLogId = errorLogId;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.QUEUE_NAME
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.QUEUE_NAME
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.QUEUE_NAME
     *
     * @param queueName the value for TB_JMS_PROCESS_ERR_LOG.QUEUE_NAME
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_STAGE
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.ERROR_STAGE
     */
    public Short getErrorStage() {
        return errorStage;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_STAGE
     *
     * @param errorStage the value for TB_JMS_PROCESS_ERR_LOG.ERROR_STAGE
     */
    public void setErrorStage(Short errorStage) {
        this.errorStage = errorStage;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.REL_ID
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.REL_ID
     */
    public Long getRelId() {
        return relId;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.REL_ID
     *
     * @param relId the value for TB_JMS_PROCESS_ERR_LOG.REL_ID
     */
    public void setRelId(Long relId) {
        this.relId = relId;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.REL_SEQ
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.REL_SEQ
     */
    public Short getRelSeq() {
        return relSeq;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.REL_SEQ
     *
     * @param relSeq the value for TB_JMS_PROCESS_ERR_LOG.REL_SEQ
     */
    public void setRelSeq(Short relSeq) {
        this.relSeq = relSeq;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.JMS_TYPE
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.JMS_TYPE
     */
    public String getJmsType() {
        return jmsType;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.JMS_TYPE
     *
     * @param jmsType the value for TB_JMS_PROCESS_ERR_LOG.JMS_TYPE
     */
    public void setJmsType(String jmsType) {
        this.jmsType = jmsType == null ? null : jmsType.trim();
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.STATUS
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.STATUS
     */
    public Short getStatus() {
        return status;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.STATUS
     *
     * @param status the value for TB_JMS_PROCESS_ERR_LOG.STATUS
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_YN
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.ERROR_YN
     */
    public String getErrorYn() {
        return errorYn;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_YN
     *
     * @param errorYn the value for TB_JMS_PROCESS_ERR_LOG.ERROR_YN
     */
    public void setErrorYn(String errorYn) {
        this.errorYn = errorYn == null ? null : errorYn.trim();
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.RETRY_CNT
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.RETRY_CNT
     */
    public Short getRetryCnt() {
        return retryCnt;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.RETRY_CNT
     *
     * @param retryCnt the value for TB_JMS_PROCESS_ERR_LOG.RETRY_CNT
     */
    public void setRetryCnt(Short retryCnt) {
        this.retryCnt = retryCnt;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_MESSAGE
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.ERROR_MESSAGE
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ERROR_MESSAGE
     *
     * @param errorMessage the value for TB_JMS_PROCESS_ERR_LOG.ERROR_MESSAGE
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ETR_DATE
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.ETR_DATE
     */
    public Date getEtrDate() {
        return etrDate;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.ETR_DATE
     *
     * @param etrDate the value for TB_JMS_PROCESS_ERR_LOG.ETR_DATE
     */
    public void setEtrDate(Date etrDate) {
        this.etrDate = etrDate;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.UPDATE_DATE
     *
     * @return the value of TB_JMS_PROCESS_ERR_LOG.UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * TB_JMS_PROCESS_ERR_LOG.UPDATE_DATE
     *
     * @param updateDate the value for TB_JMS_PROCESS_ERR_LOG.UPDATE_DATE
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}