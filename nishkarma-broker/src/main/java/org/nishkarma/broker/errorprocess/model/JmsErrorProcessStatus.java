/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.errorprocess.model;

/** <pre>
 * 
 * </pre>
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 12. 오전 8:41:51
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 12. lee suk jae
 *          -------------------------------------------------------------------
 */

public enum  JmsErrorProcessStatus {
	INITIAL((short)0),
	PROCESSING((short)1),
	COMPLETE((short)2);
	
	private short value;
	
	private JmsErrorProcessStatus(short value) {
		this.value = value;
	}
	
	public short getValue() {
		return this.value;
	}

}
