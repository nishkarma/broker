/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.errorprocess.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.exception.JmsErrorStage;
import org.nishkarma.broker.common.exception.NishkarmaException;
import org.nishkarma.broker.errorprocess.model.TbJmsProcessErrLog;
import org.nishkarma.broker.jms.order.service.OrderMessageConsumer;
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
 * @Date 2015. 5. 12. 오후 4:53:05
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 12. lee suk jae
 *          -------------------------------------------------------------------
 */
@Service
public class OrderErrorProcessService {

	private Logger logger = LoggerFactory
			.getLogger(OrderErrorProcessService.class);

	@Autowired
	private OrderMessageConsumer orderMessageConsumer;

	@Autowired
	private TbTmpOrderMapper tbTmpOrderMapper;

	@Autowired
	private TbTmpErpOrdersMapper tbTmpErpOrdersMapper;

	public void processErrorOrder(TbJmsProcessErrLog tbJmsProcessErrLog)
			throws NishkarmaException {
		try {
			TbTmpOrder tbTmpOrder = tbTmpOrderMapper
					.selectByPrimaryKey(tbJmsProcessErrLog.getRelId());
			orderMessageConsumer.processOrder(tbTmpOrder, false);
		} catch (NishkarmaException se) {
			throw new NishkarmaException(se.getMessage(), se.getErrorCode());
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new NishkarmaException(e.getMessage(),
					JmsErrorStage.UNDEFINED_ERROR);
		}
	}

	public void processErrorOrderFrontUpdate(
			TbJmsProcessErrLog tbJmsProcessErrLog) throws NishkarmaException {

		try {
			TbTmpOrder tbTmpOrder = tbTmpOrderMapper
					.selectByPrimaryKey(tbJmsProcessErrLog.getRelId());
			Integer erpOrderId = tbTmpErpOrdersMapper
					.selectErpOrderID(tbTmpOrder.getOrdId());
			tbTmpOrder.setErpOrderId(erpOrderId);

			orderMessageConsumer.updateTmpOrder(tbTmpOrder);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));

			throw new NishkarmaException(e.getMessage(),
					JmsErrorStage.FRONT_UPDATE_ERROR);
		}
	}

}
