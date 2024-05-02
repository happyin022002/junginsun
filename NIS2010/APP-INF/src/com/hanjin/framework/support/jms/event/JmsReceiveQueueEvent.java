/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueEvent.java
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

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Event 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueEvent 참조
 * @since J2EE 1.4
 */
public class JmsReceiveQueueEvent extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1916279700293092409L;
	private String event = "";

	/** event getter 메서드.<br>
	 */
	public String getEvent() {
		return event;
	}

	/** event setter 메서드.<br>
	 * @param event String
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/** ReceiveQueueEvent 생성자<br>
	 */
	public JmsReceiveQueueEvent() {
	}

	/** ReceiveQueueEvent setter 메서드.<br>
	 * @param event String
	 */
	public JmsReceiveQueueEvent(String event) {
		this.event = event;
	}

	public Object object = null;

	/**
	 * eventName getter 메서드
	 */
	public String getEventName() {
		return "JmsReceiveQueueEvent";
	}

	/**
	 * toString() 메서드
	 */
	public String toString() {
		return "JmsReceiveQueueEvent";
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
