/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGemFns0510001Event.java
 * @FileTitle : ERP(A/P)에서 일반관리비 집계대상 전표에 대하여 예산대비실적 집행율 정보를 요청한다.
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-06-25
 * @LastModifier : choijungmi
 * @LastVersion : 1.0
 * 2009-06-25 choijungmi
 * 
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS051_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS051_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsGemFns0510001Event extends EventSupport {
	private static final long serialVersionUID = 6498880634263177698L;
	/*
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
	*/

	public String csrNo = "";

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

}