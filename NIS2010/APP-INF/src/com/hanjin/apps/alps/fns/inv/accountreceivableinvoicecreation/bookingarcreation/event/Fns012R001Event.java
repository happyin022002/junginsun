/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGemFns0090001Event.java
 * @FileTitle : ERP(A/P)에서 일반관리비 집계대상 전표에 대하여 GEM로 인터페이스 한다
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-06-16
 * @LastModifier : choijungmi
 * @LastVersion : 1.0
 * 2009-06-16 choijungmi
 * 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.event;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS043-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Jung Hwi Taek
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class Fns012R001Event extends EventSupport {
	private static final long serialVersionUID = -3185463831351987650L;
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}