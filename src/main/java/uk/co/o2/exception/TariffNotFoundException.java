package uk.co.o2.exception;

public class TariffNotFoundException extends Exception{


	
	/**
	 * Serial Version UId
	 */
	private static final long serialVersionUID = -2721380362951587609L;
	
	/**
	 * Error code
	 */
	private String code;
	
	/**
	 * Throwable instance
	 */
	private Throwable throwableObj;
	
	/**
	 * Error message
	 */
	private String message;
	
	/**
	 * Empty constructor 
	 */
	public TariffNotFoundException() {

	}

	/**
	 * Constructor take error message as argument 
	 * @param arg0 - String error message
	 */
	public TariffNotFoundException(String arg0) {
		super(arg0);
		this.message=arg0;
	}

	/**
	 * Constructor takes throwable instance
	 * @param Throwable 
	 */
	public TariffNotFoundException(Throwable arg0) {
		super(arg0);
		this.message=arg0.getMessage();
		this.throwableObj=arg0;
	}

	public TariffNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.message=arg0;
		this.throwableObj=arg1;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the throwableObj
	 */
	public Throwable getThrowableObj() {
		return throwableObj;
	}

	/**
	 * @param throwableObj the throwableObj to set
	 */
	public void setThrowableObj(Throwable throwableObj) {
		this.throwableObj = throwableObj;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
