/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryResponse.java
*@FileTitle : TerminalInvoiceInquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryList;


/**
 * SPP_TES_005Response 에 대한 WebService Document Object including Parameters<br>
 * - TerminalInvoiceIWSProxy의 Output Parameter<br>
 * - SPP_TES_005EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */
public class TerminalInvoiceInquiryResponse {
	/** (Header) */
	private String	id				= "TerminalInvoiceInquiryResponse";
	private String	status			= null;
	private int		count			= 0;
	
	/** (Param 객체) */
	private TerminalInvoiceInquiryList[]	terminalInvoiceInquirylist	= null;


	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param
	 */
	public void setTerminalInvoiceInquiryList(TerminalInvoiceInquiryList[] TerminalInvoiceInquirylist) {
		this.terminalInvoiceInquirylist = TerminalInvoiceInquirylist;
	}

	/**
	 * @return
	 */
	public TerminalInvoiceInquiryList[] getTerminalInvoiceInquiryList() {
		return terminalInvoiceInquirylist;
	}


	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
