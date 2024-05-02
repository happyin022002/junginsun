/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueEventResponse.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.framework.support.jms.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * Event의 피드백을 담당한다.
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueEvent 참조
 * @since J2EE 1.4
 */
public class JmsReceiveQueueEventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;

	public String message = null;

	/**
	 * 생성자
	 *
	 */
	public JmsReceiveQueueEventResponse() {
	}

	/**
	 * 생성자
	 * @param object
	 */
	public JmsReceiveQueueEventResponse(String message) {
		this.message = message;
	}

	/**
	 * toString()
	 */
	public String toString() {
		return "JmsReceiveQueueEventResponse";
	}

	/**
	 * eventName getter 메서드
	 * @return String
	 */
	public String getEventName() {
		return "JmsReceiveQueueEventResponse";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
