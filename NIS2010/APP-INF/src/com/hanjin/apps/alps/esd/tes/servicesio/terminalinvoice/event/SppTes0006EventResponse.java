/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : SPP_TES_006EventResponse.java
*@FileTitle	: SPP_TES_006EventResponse
*Open Issues :
*Change	history	:
*@LastModifyDate : 2008-04-11
*@LastModifier : KJJ
*@LastVersion :	1.0
* 2008-04-11 KJJ
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * @author 
 * @see TerminalInvoiceInquiryRSC 참조
 * @since J2EE 1.4
 */
public class SppTes0006EventResponse extends EventResponseSupport{

	private static final long serialVersionUID = 1L;
	
	private int totalCount = 0;
	private String successFlag;
	private MarineTerminalInvoiceDiscrepancyCntrList[] marineTerminalInvoiceDiscrepancyCntrList;
	private OffDockCYInvoiceDiscrepancyCntrList[] offDockCYInvoiceDiscrepancyCntrList; 
	private MarineTerminalStorageInvoiceDiscrepancyCntrList[] marineTerminalStorageInvoiceDiscrepancyCntrList;
	
	/**
	 * 
	 *
	 */
	public SppTes0006EventResponse(){
		
	}
	
	/**
	 * 
	 * @param MarineTerminalInvoiceDiscrepancyCntrList
	 * @param successFlag
	 */
	public SppTes0006EventResponse(MarineTerminalInvoiceDiscrepancyCntrList[] MarineTerminalInvoiceDiscrepancyCntrList, String successFlag) {
		this.marineTerminalInvoiceDiscrepancyCntrList = MarineTerminalInvoiceDiscrepancyCntrList;
		this.successFlag = successFlag;
	}
	
	/**
	 * 
	 * @param MarineTerminalStorageInvoiceDiscrepancyCntrList
	 * @param successFlag
	 */
	public SppTes0006EventResponse(MarineTerminalStorageInvoiceDiscrepancyCntrList[] MarineTerminalStorageInvoiceDiscrepancyCntrList, String successFlag) {
		this.marineTerminalStorageInvoiceDiscrepancyCntrList = MarineTerminalStorageInvoiceDiscrepancyCntrList;
		this.successFlag = successFlag;
	}
	
	/**
	 * 
	 * @param OffDockCYInvoiceDiscrepancyCntrList
	 * @param successFlag
	 */
	public SppTes0006EventResponse(OffDockCYInvoiceDiscrepancyCntrList[] OffDockCYInvoiceDiscrepancyCntrList, String successFlag) {
		this.offDockCYInvoiceDiscrepancyCntrList = OffDockCYInvoiceDiscrepancyCntrList;
		this.successFlag = successFlag;
	}

	/**
	 * 
	 * @return
	 */
	public MarineTerminalInvoiceDiscrepancyCntrList[] getMarineTerminalInvoiceDiscrepancyCntrList() {
		return this.marineTerminalInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @param marineTerminalInvoiceDiscrepancyCntrList
	 */
	public void setMarineTerminalInvoiceDiscrepancyCntrList(
			MarineTerminalInvoiceDiscrepancyCntrList[] marineTerminalInvoiceDiscrepancyCntrList) {
		this.marineTerminalInvoiceDiscrepancyCntrList = marineTerminalInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @return
	 */
	public MarineTerminalStorageInvoiceDiscrepancyCntrList[] getMarineTerminalStorageInvoiceDiscrepancyCntrList() {
		return marineTerminalStorageInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @param marineTerminalStorageInvoiceDiscrepancyCntrList
	 */
	public void setMarineTerminalStorageInvoiceDiscrepancyCntrList(
			MarineTerminalStorageInvoiceDiscrepancyCntrList[] marineTerminalStorageInvoiceDiscrepancyCntrList) {
		this.marineTerminalStorageInvoiceDiscrepancyCntrList = marineTerminalStorageInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @return
	 */
	public OffDockCYInvoiceDiscrepancyCntrList[] getOffDockCYInvoiceDiscrepancyCntrList() {
		return offDockCYInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @param offDockCYInvoiceDiscrepancyCntrList
	 */
	public void setOffDockCYInvoiceDiscrepancyCntrList(
			OffDockCYInvoiceDiscrepancyCntrList[] offDockCYInvoiceDiscrepancyCntrList) {
		this.offDockCYInvoiceDiscrepancyCntrList = offDockCYInvoiceDiscrepancyCntrList;
	}

	/**
	 * 
	 * @return
	 */
	public String getSuccessFlag() {
		return successFlag;
	}

	/**
	 * 
	 * @param successFlag
	 */
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}	
	
	public String getEventName(){
		return "SPP_TES_006EventResponse"; 
	}
}
