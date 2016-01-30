/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.exception;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 6. 오후 1:32:29
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 6.     lee suk jae
 *          -------------------------------------------------------------------
 */

public class NishkarmaException extends RuntimeException {

	private static final long serialVersionUID = -3963610280814214831L;

	private ErrorStage errorCode;
	
	/**
	 * Constructs a new runtime exception with {@code null} as its detail
	 * message. The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public NishkarmaException() {
		super();
	}

	/**
	 * Constructs a new runtime exception with the specified detail message. The
	 * cause is not initialized, and may subsequently be initialized by a call
	 * to {@link #initCause}.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public NishkarmaException(String message) {
		super(message);
	}
	
	public NishkarmaException(String message, ErrorStage errorCode) {
		super(message);
		this.setErrorCode(errorCode);
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.
	 * <p>
	 * Note that the detail message associated with {@code cause} is <i>not</i>
	 * automatically incorporated in this runtime exception's detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 * @since 1.4
	 */
	public NishkarmaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NishkarmaException(String message, Throwable cause, ErrorStage errorCode) {
		super(message, cause);
		this.setErrorCode(errorCode);
	}
	
	/**
	 * Constructs a new runtime exception with the specified cause and a detail
	 * message of <tt>(cause==null ? null : cause.toString())</tt> (which
	 * typically contains the class and detail message of <tt>cause</tt>). This
	 * constructor is useful for runtime exceptions that are little more than
	 * wrappers for other throwables.
	 * 
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 * @since 1.4
	 */
	public NishkarmaException(Throwable cause) {
		super(cause);
	}

	public NishkarmaException(Throwable cause, ErrorStage errorCode) {
		super(cause);
		this.setErrorCode(errorCode);
	}
	
	/**
	 * Constructs a new runtime exception with the specified detail message,
	 * cause, suppression enabled or disabled, and writable stack trace enabled
	 * or disabled.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause. (A {@code null} value is permitted, and indicates
	 *            that the cause is nonexistent or unknown.)
	 * @param enableSuppression
	 *            whether or not suppression is enabled or disabled
	 * @param writableStackTrace
	 *            whether or not the stack trace should be writable
	 * 
	 * @since 1.7
	 */
	protected NishkarmaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	protected NishkarmaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace, ErrorStage errorCode) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.setErrorCode(errorCode);
	}

	/**
	 * @return the errorCode
	 */
	public ErrorStage getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(ErrorStage errorCode) {
		this.errorCode = errorCode;
	}
}

