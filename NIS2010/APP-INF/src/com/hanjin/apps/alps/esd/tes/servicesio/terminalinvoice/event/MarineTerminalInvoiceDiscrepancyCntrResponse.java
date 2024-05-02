/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : MarineTerminalInvoiceDiscrepancyCntrResponse.java
*@FileTitle	: MarineTerminalInvoiceDiscrepancyCntrResponse
*Open Issues :
*Change	history	:
*@LastModifyDate : 2008-04-11
*@LastModifier : KJJ
*@LastVersion :	1.0
* 2008-04-11 KJJ
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * @author 
 * @see TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */
public class MarineTerminalInvoiceDiscrepancyCntrResponse {
	private String	a1Flag	= "FakeFlag1";
	private MarineTerminalInvoiceDiscrepancyCntrList[] marineTerminalInvoiceDiscrepancyCntrList;
	private int count = 0;
	private String status = null;
	
	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	public MarineTerminalInvoiceDiscrepancyCntrList[] getMarineTerminalInvoiceDiscrepancyCntrList() {
		return marineTerminalInvoiceDiscrepancyCntrList;
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
	 * @return Returns the a1Flag.
	 */
	public String getA1Flag() {
		return a1Flag;
	}

	/**
	 * @param flag The a1Flag to set.
	 */
	public void setA1Flag(String flag) {
		a1Flag = flag;
	}


}
