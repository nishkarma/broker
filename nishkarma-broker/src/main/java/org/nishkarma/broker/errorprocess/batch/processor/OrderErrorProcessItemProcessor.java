/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.errorprocess.batch.processor;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.exception.JmsErrorStage;
import org.nishkarma.broker.common.util.MarshallUtil;
import org.nishkarma.broker.errorprocess.model.JmsErrorProcessStatus;
import org.nishkarma.broker.errorprocess.model.TbJmsProcessErrLog;
import org.nishkarma.broker.errorprocess.repository.TbJmsProcessErrLogMapper;
import org.nishkarma.broker.errorprocess.service.OrderErrorProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 7. 15. 오후 6:04:27
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 7. 15. lee suk jae
 *          -------------------------------------------------------------------
 */

public class OrderErrorProcessItemProcessor implements
		ItemProcessor<TbJmsProcessErrLog, TbJmsProcessErrLog>, InitializingBean {

	private Logger logger = LoggerFactory
			.getLogger(OrderErrorProcessItemProcessor.class);

	@Autowired
	private TbJmsProcessErrLogMapper tbJmsProcessErrLogMapper;

	@Autowired
	OrderErrorProcessService orderErrorProcessService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public TbJmsProcessErrLog process(TbJmsProcessErrLog tbJmsProcessErrLog)
			throws Exception {
		logger.debug("--OrderErrorProcessItemProcessor-start");

		logger.debug(
				"--OrderErrorProcessItemProcessor-process-tbJmsProcessErrLog-ErrorLogId={}",
				tbJmsProcessErrLog.getErrorLogId());

		switch (JmsErrorStage.getEnumCode(tbJmsProcessErrLog.getErrorStage())) {

		case FRONT_TRANS_ERROR:
		case ERP_INSERT_ERROR:
			orderErrorProcessService.processErrorOrder(tbJmsProcessErrLog);
			break;

		case FRONT_UPDATE_ERROR:
			orderErrorProcessService
					.processErrorOrderFrontUpdate(tbJmsProcessErrLog);
			break;

		default:
			try {
				logger.error("undefined JmsErrorStage for Error Object: \n{}",
						MarshallUtil.marshal(tbJmsProcessErrLog));
			} catch (Exception me) {
				logger.error(ExceptionUtils.getStackTrace(me));
			}

			break;
		}

		tbJmsProcessErrLog.setErrorYn("N");
		tbJmsProcessErrLog.setErrorMessage(null);
		// process lock release
		tbJmsProcessErrLog.setStatus(JmsErrorProcessStatus.COMPLETE.getValue());

		return tbJmsProcessErrLog;

	}
}
