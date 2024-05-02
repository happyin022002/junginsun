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
package com.clt.apps.opus.common.tableSync.jms.event;

import org.apache.xmlbeans.XmlObject;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * Event 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueEvent 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueEvent extends EventSupport {
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
	public ReceiveQueueEvent() {
	}

	/** ReceiveQueueEvent setter 메서드.<br>
	 * @param event String
	 */
	public ReceiveQueueEvent(String event) {
		this.event = event;
	}

	public XmlObject xmlObject = null;

	/**
	 * eventName getter 메서드
	 */
	public String getEventName() {
		return "ReceiveQueueEvent";
	}

	/**
	 * toString() 메서드
	 */
	public String toString() {
		return "ReceiveQueueEvent";
	}

	/**
	 * xmlObject getter 메서드 
	 * @return XmlObject
	 */
	public XmlObject getXmlObject() {
		return xmlObject;
	}

	/**
	 * xmlObject setter 메서
	 * @param xmlObject
	 */
	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}
