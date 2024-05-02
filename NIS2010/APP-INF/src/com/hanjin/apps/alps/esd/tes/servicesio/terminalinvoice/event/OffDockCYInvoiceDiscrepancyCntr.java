/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : OffDockCYInvoiceDiscrepancyCntr.java
*@FileTitle	: OffDockCYInvoiceDiscrepancyCntr
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
public class OffDockCYInvoiceDiscrepancyCntr {
	
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSq = null;
	
	/**
	 * 
	 * @return
	 */
	public String getTml_so_ofc_cty_cd() {
		return tmlSoOfcCtyCd;
	}
	
	/**
	 * 
	 * @param tml_so_ofc_cty_cd
	 */
	public void setTml_so_ofc_cty_cd(String tml_so_ofc_cty_cd) {
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTml_so_seq() {
		return tmlSoSq;
	}
	
	/**
	 * 
	 * @param tml_so_seq
	 */
	public void setTml_so_seq(String tml_so_seq) {
		this.tmlSoSq = tml_so_seq;
	}	
}
