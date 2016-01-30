/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.errorprocess.model;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 12. 오전 8:41:51
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date________Auther____Desc.________________________________________
 *          2015. 5. 12. lee suk jae
 *          -------------------------------------------------------------------
 */

public enum  JmsType {
	PRODUCER("P"),
	CONSUMER("C");
	
	private String value;
	
	private JmsType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
