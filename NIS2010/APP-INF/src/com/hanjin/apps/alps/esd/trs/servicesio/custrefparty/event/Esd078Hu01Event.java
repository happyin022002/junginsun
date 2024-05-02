/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Esd078Hu01Event.java
*@FileTitle : korea manifest sequence number 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-19
*@LastModifier : 김종호
*@LastVersion : 1.2
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* 2010-05-17 김종호 : 파일명 변경 및 ALPS New F/W에 따른 처리 작업
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Data Transfer Object including Parameters<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class Esd078Hu01Event extends EventSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Esd078Hu01Event(){}
		
	public XmlObject xmlData = null;

	public String getEventName() {
		return "Esd078Hu01Event";
	}

	public String toString() {
		return "Esd078Hu01Event";
	}

	public XmlObject getXmlObject() {
		return xmlData;
	}

	public void setXmlObject(XmlObject xmlData) {
		this.xmlData = xmlData;
	}
	
}
