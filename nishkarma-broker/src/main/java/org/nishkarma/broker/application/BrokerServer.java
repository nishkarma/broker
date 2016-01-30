/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.application;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nishkarma.broker.common.util.NishkarmaMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오전 11:38:59
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 7. lee suk jae
 *          -------------------------------------------------------------------
 */

public class BrokerServer {

	private static Logger logger = LoggerFactory.getLogger(BrokerServer.class);

	public static void main(String[] args) {

		try {

			if (args == null || args.length < 1) {
				System.out.println("Arguments Usage: activemq-server1.properties or activemq-server2.properties");
				System.exit(0);
			}
			
			String activemqServerCfg = args[0];
			System.getProperties().setProperty("activemq-server-config", activemqServerCfg);

			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"classpath:spring/business-config.xml");
			
			logger.info("---------------------------------------------");
			logger.info("-----Nishkarma-Broker BrokerServer started-----");
			logger.info("---------------------------------------------");
			
			NishkarmaMessageSource.setApplicationContext(applicationContext);

			applicationContext.registerShutdownHook();

		} catch (final Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
