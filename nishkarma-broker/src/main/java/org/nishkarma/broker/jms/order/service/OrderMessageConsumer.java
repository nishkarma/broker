/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.jms.order.service;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.exception.JmsErrorStage;
import org.nishkarma.broker.common.exception.NishkarmaException;
import org.nishkarma.broker.common.util.MarshallUtil;
import org.nishkarma.broker.errorprocess.model.JmsErrorProcessStatus;
import org.nishkarma.broker.errorprocess.model.JmsType;
import org.nishkarma.broker.errorprocess.model.TbJmsProcessErrLog;
import org.nishkarma.broker.errorprocess.repository.TbJmsProcessErrLogMapper;
import org.nishkarma.erp.order.model.TbTmpErpOrders;
import org.nishkarma.erp.order.repository.TbTmpErpOrdersMapper;
import org.nishkarma.mall.order.model.TbTmpOrder;
import org.nishkarma.mall.order.repository.TbTmpOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오후 7:57:17
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 7. lee suk jae
 *          -------------------------------------------------------------------
 */

@Service
public class OrderMessageConsumer {

	private Logger logger = LoggerFactory.getLogger(OrderMessageConsumer.class);

	private Logger jmsErrorInsertFailLogger = LoggerFactory
			.getLogger("jmsErrorInsertFailLogger");

	@Autowired
	private TbTmpErpOrdersMapper tbTmpErpOrdersMapper;

	@Autowired
	private TbTmpOrderMapper tbTmpOrderMapper;

	@Autowired
	private TbJmsProcessErrLogMapper tbJmsProcessErrLogMapper;

	public void processOrder(TbTmpOrder tbTmpOrder, boolean doTbJmsProcessErrLog)
			throws NishkarmaException {

		try {
			logger.debug("--1.received-front-getOrdId={}",
					tbTmpOrder.getOrdId());

			TbTmpErpOrders tbTmpErpOrders = new TbTmpErpOrders();

			tbTmpErpOrders.setCustomerId(new BigDecimal(tbTmpOrder.getOrdId()));
			tbTmpErpOrders
					.setFrontOrderId(new BigDecimal(tbTmpOrder.getOrdId()));
			tbTmpErpOrders
					.setOrderTotal(new BigDecimal(tbTmpOrder.getOrdAmt()));

			tbTmpErpOrders.setOrderTimestamp(tbTmpOrder.getEtrDate());

			try {
				saveTmpErpOrder(tbTmpErpOrders);
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));

				if (doTbJmsProcessErrLog) {
					saveTbJmsProcessErrLog(tbTmpOrder,
							JmsErrorStage.ERP_INSERT_ERROR.getCode(),
							e.getLocalizedMessage());
				}

				throw new NishkarmaException(e.getMessage(),
						JmsErrorStage.ERP_INSERT_ERROR);

			}

			logger.debug("--2.tbTmpErpOrders.getOrderId()={}",
					tbTmpErpOrders.getOrderId());

			tbTmpOrder.setErpOrderId(tbTmpErpOrders.getOrderId());

			try {
				updateTmpOrder(tbTmpOrder);
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));

				if (doTbJmsProcessErrLog) {
					saveTbJmsProcessErrLog(tbTmpOrder,
							JmsErrorStage.FRONT_UPDATE_ERROR.getCode(),
							e.getLocalizedMessage());
				}
				throw new NishkarmaException(e.getMessage(),
						JmsErrorStage.FRONT_UPDATE_ERROR);
			}

		} catch (NishkarmaException se) {
			throw new NishkarmaException(se.getMessage(), se.getErrorCode());
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new NishkarmaException(e.getMessage(),
					JmsErrorStage.UNDEFINED_ERROR);
		}

	}

	public void processMessage(Object message) {
		try {
			TbTmpOrder tbTmpOrder = (TbTmpOrder) message;

			processOrder(tbTmpOrder, true);

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}

	private int saveTmpErpOrder(TbTmpErpOrders tbTmpErpOrders) throws Exception {
		// throw new Exception("1.saveTmpErpOrder");
		return tbTmpErpOrdersMapper.insert(tbTmpErpOrders);
	}

	public void updateTmpOrder(TbTmpOrder tbTmpOrder) throws Exception {

		// throw new Exception("2.updateTmpOrder");

		tbTmpOrderMapper.updateByPrimaryKey(tbTmpOrder);

		logger.debug("tbTmpOrder.getOrdId()={}", tbTmpOrder.getOrdId());

		return;

	}

	private void saveTbJmsProcessErrLog(TbTmpOrder tbTmpOrder,
			short errorStage, String errorMessage) {

		TbJmsProcessErrLog tbJmsProcessErrLog = null;
		try {

			tbJmsProcessErrLog = new TbJmsProcessErrLog();

			tbJmsProcessErrLog.setQueueName("ORDER.QUEUE");
			tbJmsProcessErrLog.setErrorStage(errorStage);
			tbJmsProcessErrLog.setRelId((long) tbTmpOrder.getOrdId());
			tbJmsProcessErrLog.setRelSeq((short) 0);
			tbJmsProcessErrLog.setErrorMessage(errorMessage);
			tbJmsProcessErrLog.setErrorYn("Y");
			tbJmsProcessErrLog.setJmsType(JmsType.CONSUMER.getValue());
			tbJmsProcessErrLog.setStatus(JmsErrorProcessStatus.INITIAL
					.getValue());

			tbJmsProcessErrLogMapper.insert(tbJmsProcessErrLog);

/*			throw new Exception("insert(tbJmsProcessErrLog)");*/
			
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));

			try {
				
				tbJmsProcessErrLog.setEtrDate(new Date());
				jmsErrorInsertFailLogger.error(MarshallUtil.marshal(tbJmsProcessErrLog));
			} catch (Exception me) {
				logger.error(ExceptionUtils.getStackTrace(me));
			}
		}
	}

}
