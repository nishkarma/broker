/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.jmsproducer.service;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오후 3:27:07
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 7.  lee suk jae
 *          -------------------------------------------------------------------
 */

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.exception.JmsErrorStage;
import org.nishkarma.broker.common.util.MarshallUtil;
import org.nishkarma.broker.errorprocess.model.JmsErrorProcessStatus;
import org.nishkarma.broker.errorprocess.model.JmsType;
import org.nishkarma.broker.errorprocess.model.TbJmsProcessErrLog;
import org.nishkarma.broker.errorprocess.repository.TbJmsProcessErrLogMapper;
import org.nishkarma.mall.order.model.TbTmpOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderProducer {

	private Logger logger = LoggerFactory.getLogger(JmsOrderProducer.class);
	private Logger jmsErrorInsertFailLogger = LoggerFactory.getLogger("jmsErrorInsertFailLogger");

	private JmsTemplate jmsTemplate;
	private String destinationName;

	@Autowired
	private TbJmsProcessErrLogMapper tbJmsProcessErrLogMapper;

	public void sendOrderMessages(final TbTmpOrder tbTmpOrder) {

		try {
			jmsTemplate.send(destinationName, new MessageCreator() {

				@Override
				public Message createMessage(Session session)
						throws JMSException {
					ObjectMessage message = session
							.createObjectMessage(tbTmpOrder);
					message.setIntProperty("OrdId", tbTmpOrder.getOrdId());

					logger.debug("--JMS Sending Order '{}'",
							tbTmpOrder.getOrdId());

					return message;
				}
			});

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			saveTbJmsProcessErrLog(tbTmpOrder, e.getMessage());
		}
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param tbTmpOrder
	 * @param errorMessage
	 */
	private void saveTbJmsProcessErrLog(TbTmpOrder tbTmpOrder, String errorMessage) {
		
		TbJmsProcessErrLog tbJmsProcessErrLog = null;
		try {
			
			tbJmsProcessErrLog = new TbJmsProcessErrLog();

			tbJmsProcessErrLog.setQueueName(destinationName);
			tbJmsProcessErrLog.setErrorStage(JmsErrorStage.FRONT_TRANS_ERROR.getCode());
			tbJmsProcessErrLog.setRelId((long)tbTmpOrder.getOrdId());
			tbJmsProcessErrLog.setRelSeq((short)0);
			tbJmsProcessErrLog.setErrorMessage(errorMessage);
			tbJmsProcessErrLog.setErrorYn("Y");
			tbJmsProcessErrLog.setJmsType(JmsType.PRODUCER.getValue());
			tbJmsProcessErrLog.setStatus(JmsErrorProcessStatus.INITIAL.getValue());
			
			tbJmsProcessErrLogMapper.insert(tbJmsProcessErrLog);
			
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			
			try { 
				jmsErrorInsertFailLogger.error("Error Object: \n{}", MarshallUtil.marshal(tbJmsProcessErrLog));
			} catch (Exception me) {
				logger.error(ExceptionUtils.getStackTrace(me));
			}
		}
	}

	/**
	 * @return the jmsTemplate
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * @param jmsTemplate
	 *            the jmsTemplate to set
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * @param destinationName
	 *            the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
}
