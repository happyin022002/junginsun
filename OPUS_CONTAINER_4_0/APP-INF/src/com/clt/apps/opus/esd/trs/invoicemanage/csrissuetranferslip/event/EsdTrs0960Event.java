/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_960Event.java
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-03-15 chkong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0960 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0960HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0960Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private String csrNo = "";

	/**
	 * @return the csrNo
	 */
	public String getCsrNo() {
		return csrNo;
	}

	/**
	 * @param csrNo the csrNo to set
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public EsdTrs0960Event(){}

	public String getEventName() {
		return "EsdTrs0960Event";
	}

	public String toString() {
		return "EsdTrs0960Event";
	}

}
