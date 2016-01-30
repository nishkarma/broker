/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 11. 오후 1:13:43
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 11. lee suk jae
 *          -------------------------------------------------------------------
 */

public class IPAuthenticationBroker extends BrokerFilter {

	private static Logger logger = LoggerFactory
			.getLogger(IPAuthenticationBroker.class);

	List<String> allowedIPAddresses;
	Pattern vmPattern = Pattern.compile("^vm://.{1,200}");;
	Pattern remotePattern = Pattern.compile("(tcp|nio)://([0-9\\.]*):.*");

	public IPAuthenticationBroker(Broker next, List<String> allowedIPAddresses) {
		super(next);
		this.allowedIPAddresses = allowedIPAddresses;
	}

	public void addConnection(ConnectionContext context, ConnectionInfo info)
			throws Exception {
		String remoteAddress = context.getConnection().getRemoteAddress();
		logger.debug("remoteAddress={}", remoteAddress);

		Matcher vmMatcher = vmPattern.matcher(remoteAddress);

		if (!vmMatcher.matches()) {
			Matcher matcher = remotePattern.matcher(remoteAddress);
			if (matcher.matches()) {
				
				//logger.debug("group-0={}", matcher.group(0));
				
				String ip = matcher.group(2);

				//logger.debug("ip={}", ip);

				if (!allowedIPAddresses.contains(ip)) {
					throw new SecurityException("Connecting from IP address "
							+ ip + " is not allowed");
				}
			} else {
				throw new SecurityException("Invalid remote address "
						+ remoteAddress);
			}
		}

		super.addConnection(context, info);
	}
}
