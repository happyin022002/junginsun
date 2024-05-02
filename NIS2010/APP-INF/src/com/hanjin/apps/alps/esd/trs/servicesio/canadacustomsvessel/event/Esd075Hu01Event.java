/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD075_HU01Event.java
*@FileTitle : Canada Customs Vessel 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.event;

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
public class Esd075Hu01Event extends EventSupport{
	
	public Esd075Hu01Event(){}
		
	public XmlObject xmlData = null;

	public String getEventName() {
		return "Esd075Hu01Event";
	}

	public String toString() {
		return "Esd075Hu01Event";
	}

	public XmlObject getXmlObject() {
		return xmlData;
	}

	public void setXmlObject(XmlObject xmlData) {
		this.xmlData = xmlData;
	}
	
}
