/**
 * Nishkarma EAI Project
 */
package org.nishkarma.mall.order.service;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오전 11:37:10
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 7.     lee suk jae
 *          -------------------------------------------------------------------
 */

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.jmsproducer.service.JmsOrderProducer;
import org.nishkarma.mall.order.model.TbTmpOrder;
import org.nishkarma.mall.order.repository.TbTmpOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmpOrdService {

	private Logger logger = LoggerFactory.getLogger(TmpOrdService.class);

	@Autowired
	private TbTmpOrderMapper tbTmpOrderMapper;
	
	@Autowired
	private JmsOrderProducer jmsOrderProducer;
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param tbTmpOrder
	 */
	private TbTmpOrder saveTmpOrder(TbTmpOrder tbTmpOrder) {
		tbTmpOrderMapper.insert(tbTmpOrder);
		
		logger.debug("tbTmpOrder.getOrdId()={}", tbTmpOrder.getOrdId());

		return tbTmpOrderMapper.selectByPrimaryKey(tbTmpOrder.getOrdId());
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	public void ordProduce() {

		try {

			int produce_cnt = 1000;

			for (int i = 0; i < produce_cnt; i++) {

				TbTmpOrder tbTmpOrder = new TbTmpOrder();

				Short goodId = (short) (i + 100);
				Short ordAmt = (short) (goodId * 10);

				tbTmpOrder.setGoodId(goodId);
				tbTmpOrder.setOrdAmt(ordAmt);

				tbTmpOrder = saveTmpOrder(tbTmpOrder);
				
				jmsOrderProducer.sendOrderMessages(tbTmpOrder);
			}

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}

	}

}
