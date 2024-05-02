/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : OffDockCYInvoiceDiscrepancyCntrResponse.java
*@FileTitle	: OffDockCYInvoiceDiscrepancyCntrResponse
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
public class OffDockCYInvoiceDiscrepancyCntrResponse {
	private String	a1Flag	= "FakeFlag1";
	private OffDockCYInvoiceDiscrepancyCntrList[] offDockCYInvoiceDiscrepancyCntrList;
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
