/**
 * Nishkarma EAI Project
 */
package org.nishkarma.mall.jmsproducer.application;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.util.NishkarmaMessageSource;
import org.nishkarma.mall.order.service.TmpOrdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오전 11:38:59
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 7.     lee suk jae
 *          -------------------------------------------------------------------
 */

public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	private static ClassPathXmlApplicationContext applicationContext = null;

	public static void main(String[] args) {
		try {
			applicationContext = new ClassPathXmlApplicationContext(
					"classpath:spring/business-config.xml");
			
			NishkarmaMessageSource.setApplicationContext(applicationContext);
			
			applicationContext.registerShutdownHook();
			
			logger.debug("---start---");
			
			TmpOrdService tmpOrdService = (TmpOrdService) applicationContext.getBean("tmpOrdService");
			tmpOrdService.ordProduce();
			
			logger.debug("---end---");
			
		} catch (final Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			if (applicationContext != null) {
				try {
					applicationContext.close();
				} catch (final Exception e) {
				}
			}
		}
	}
}
