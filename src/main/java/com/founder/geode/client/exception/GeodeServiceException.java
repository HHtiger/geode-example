package com.founder.geode.client.exception;

public class GeodeServiceException extends RuntimeException{

	private static final long serialVersionUID = 3996302283131409817L;

	/**
	 * @param code 异常码
	 */
	public GeodeServiceException(String code) {
		super(code);
	}

	/**
	 * @param code 异常码
	 * @param params 参数
	 */
	public GeodeServiceException(String code, Object[] params) {
	}

	/**
	 * @param code 异常码
	 * @param message 异常信息
	 */
	public GeodeServiceException(String code, String message) {
	}

	/**
	 * @param code 异常码
	 * @param cause 异常对象
	 */
	public GeodeServiceException(String code, Throwable cause) {
		super(code, cause);
	}

	/**
	 * @param code 异常码
	 * @param params 参数
	 * @param message 异常信息
	 */
	public GeodeServiceException(String code, Object[] params, String message) {
	}

	/**
	 * @param code 异常码
	 * @param message 异常信息
	 * @param cause 异常对象
	 */
	public GeodeServiceException(String code, String message, Throwable cause) {
	}

	/**
	 * @param code 异常码
	 * @param params 参数
	 * @param cause 异常对象
	 */
	public GeodeServiceException(String code, Object[] params, Throwable cause) {
	}

	/**
	 * @param code 异常码
	 * @param params 参数
	 * @param message 异常信息
	 * @param cause 异常对象
	 */
	public GeodeServiceException(String code, Object[] params, String message,
                                 Throwable cause) {
	}


}
