/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.exception;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 12. 오전 10:38:52
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 12. lee suk jae
 *          -------------------------------------------------------------------
 */

public enum JmsErrorStage implements ErrorStage {

	OK((short) 0),
	FRONT_TRANS_ERROR((short) 100), 
	ERP_INSERT_ERROR((short) 200), 
	FRONT_UPDATE_ERROR((short) 300), 
	UNDEFINED_ERROR((short) 999);

	private final short code;

	private JmsErrorStage(short code) {
		this.code = code;
	}

	public short getCode() {
		return code;
	}

	public static JmsErrorStage getEnumCode(short code) {

		JmsErrorStage returnErrorEnum;

		switch (code) {
		
		case (short) 0:
			returnErrorEnum = OK;
			break;

		case (short) 100:
			returnErrorEnum = FRONT_TRANS_ERROR;
			break;

		case (short) 200:
			returnErrorEnum = ERP_INSERT_ERROR;
			break;

		case (short) 300:
			returnErrorEnum = FRONT_UPDATE_ERROR;
			break;

		default:
			returnErrorEnum = UNDEFINED_ERROR;
			break;
		}

		return returnErrorEnum;
	}
}
