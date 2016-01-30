/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.util;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import java.util.List;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 11. 오후 1:14:38
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 11. lee suk jae
 *          -------------------------------------------------------------------
 */

public class IPAuthenticationPlugin implements BrokerPlugin {

	List<String> allowedIPAddresses;

	public Broker installPlugin(Broker broker) throws Exception {
		return new IPAuthenticationBroker(broker, allowedIPAddresses);
	}

	public List<String> getAllowedIPAddresses() {
		return allowedIPAddresses;
	}

	public void setAllowedIPAddresses(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}
}