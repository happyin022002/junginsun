/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryList.java
*@FileTitle : TerminalInvoiceInquiryList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * SPP_TES_005Response 에 대한 WebService Document Object including Parameters<br>
 * - TerminalInvoiceIWSProxy의 Output Parameter<br>
 * - SPP_TES_005EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */
public class TerminalInvoiceInquiryList {
	
	/** (Param 객체) */
	private int seq = 0;
	private	String tmlServiceOrderNo		= null;	
	
	private String yardCd	= null;						//yd_cd 
	private	String invoiceNumber		= null;			//inv_no
	private	String ttlInvAMT			= null;			//ttl_inv_amt
	private	String vatAMT			= null;				//vat_amt
	private	String issuedDate		= null;				//iss_dt
	private	String receivedDate		= null;				//rcv_dt
	
	private String yardNm	= null;						//yd_nm
	private	String invoiceCurrency		= null;	        //curr_cd   
	private	String invoiceTotalAMT			= null;		//ttl_amt
	private	String invoiceStatus			= null;	 	//tml_inv_sts_nm
	private	String paymentMethod			= null;		//inv_pay_mzd_cd	      
	private	String checkTTNumber		= null;			//inv_chk_trns_no
	
	/* 	2008-04-17 by KJJ 추가	*/
	private String tmlInvStsCd = null;
	private String tesTmlSoHdrCsrNo = null;
	private String apInvHdrCsrNo = null;
	
	/*	2008-04-21 by KJJ 추가 	*/
	private String rjctSts = null;
	private String tmlInvRjctStsNm = null;
	private String invRjctRmk = null;
	
	/*	2008-04-22 by KJJ 추가 	*/
	private String tmlInvTpCd = null;
	
	/**
	 * 
	 * @return
	 */
	public String getTml_inv_tp_cd() {
		return tmlInvTpCd;
	}

	/**
	 * 
	 * @param tml_inv_tp_cd
	 */
	public void setTml_inv_tp_cd(String tml_inv_tp_cd) {
		this.tmlInvTpCd = tml_inv_tp_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getInv_rjct_rmk() {
		return invRjctRmk;
	}

	/**
	 * 
	 * @param inv_rjct_rmk
	 */
	public void setInv_rjct_rmk(String inv_rjct_rmk) {
		this.invRjctRmk = inv_rjct_rmk;
	}

	/**
	 * 
	 * @return
	 */
	public String getRjct_sts() {
		return rjctSts;
	}

	/**
	 * 
	 * @param rjct_sts
	 */
	public void setRjct_sts(String rjct_sts) {
		this.rjctSts = rjct_sts;
	}

	/**
	 * 
	 * @return
	 */
	public String getTml_inv_rjct_sts_nm() {
		return tmlInvRjctStsNm;
	}

	/**
	 * 
	 * @param tml_inv_rjct_sts_nm
	 */
	public void setTml_inv_rjct_sts_nm(String tml_inv_rjct_sts_nm) {
		this.tmlInvRjctStsNm = tml_inv_rjct_sts_nm;
	}

	/**
	 * 
	 * @return
	 */
	public String getAp_inv_hdr_csr_no() {
		return apInvHdrCsrNo;
	}
	
	/**
	 * 
	 * @param ap_inv_hdr_csr_no
	 */
	public void setAp_inv_hdr_csr_no(String ap_inv_hdr_csr_no) {
		this.apInvHdrCsrNo = ap_inv_hdr_csr_no;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTes_tml_so_hdr_csr_no() {
		return tesTmlSoHdrCsrNo;
	}
	
	/**
	 * 
	 * @param tes_tml_so_hdr_csr_no
	 */
	public void setTes_tml_so_hdr_csr_no(String tes_tml_so_hdr_csr_no) {
		this.tesTmlSoHdrCsrNo = tes_tml_so_hdr_csr_no;
	}
	
	/**
	 * @return checkTTNumber을 리턴합니다.
	 */
	public String getCheckTTNumber() {
		return checkTTNumber;
	}
	/**
	 * @param checkTTNumber 설정하려는 checkTTNumber입니다.
	 */
	public void setCheckTTNumber(String checkTTNumber) {
		this.checkTTNumber = checkTTNumber;
	}
	/**
	 * @return invoiceCurrency을 리턴합니다.
	 */
	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}
	/**
	 * @param invoiceCurrency 설정하려는 invoiceCurrency입니다.
	 */
	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
	}
	/**
	 * @return invoiceNumber을 리턴합니다.
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	/**
	 * @param invoiceNumber 설정하려는 invoiceNumber입니다.
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * @return invoiceStatus을 리턴합니다.
	 */
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	/**
	 * @param invoiceStatus 설정하려는 invoiceStatus입니다.
	 */
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	/**
	 * @return invoiceTotalAMT을 리턴합니다.
	 */
	public String getInvoiceTotalAMT() {
		return invoiceTotalAMT;
	}
	/**
	 * @param invoiceTotalAMT 설정하려는 invoiceTotalAMT입니다.
	 */
	public void setInvoiceTotalAMT(String invoiceTotalAMT) {
		this.invoiceTotalAMT = invoiceTotalAMT;
	}
	/**
	 * @return issuedDate을 리턴합니다.
	 */
	public String getIssuedDate() {
		return issuedDate;
	}
	/**
	 * @param issuedDate 설정하려는 issuedDate입니다.
	 */
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	/**
	 * @return paymentMethod을 리턴합니다.
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod 설정하려는 paymentMethod입니다.
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return receivedDate을 리턴합니다.
	 */
	public String getReceivedDate() {
		return receivedDate;
	}
	/**
	 * @param receivedDate 설정하려는 receivedDate입니다.
	 */
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	/**
	 * @return seq을 리턴합니다.
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq 설정하려는 seq입니다.
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return tmlServiceOrderNo을 리턴합니다.
	 */
	public String getTmlServiceOrderNo() {
		return tmlServiceOrderNo;
	}
	/**
	 * @param tmlServiceOrderNo 설정하려는 tmlServiceOrderNo입니다.
	 */
	public void setTmlServiceOrderNo(String tmlServiceOrderNo) {
		this.tmlServiceOrderNo = tmlServiceOrderNo;
	}
	/**
	 * @return ttlInvAMT을 리턴합니다.
	 */
	public String getTtlInvAMT() {
		return ttlInvAMT;
	}
	/**
	 * @param ttlInvAMT 설정하려는 ttlInvAMT입니다.
	 */
	public void setTtlInvAMT(String ttlInvAMT) {
		this.ttlInvAMT = ttlInvAMT;
	}
	/**
	 * @return vatAMT을 리턴합니다.
	 */
	public String getVatAMT() {
		return vatAMT;
	}
	/**
	 * @param vatAMT 설정하려는 vatAMT입니다.
	 */
	public void setVatAMT(String vatAMT) {
		this.vatAMT = vatAMT;
	}
	/**
	 * @return yardNm을 리턴합니다.
	 */
	public String getYardCd() {
		return yardCd;
	}
	/**
	 * @param yardNm 설정하려는 yardNm입니다.
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	/**
	 * @return yardNm을 리턴합니다.
	 */
	public String getYardNm() {
		return yardNm;
	}
	/**
	 * @param yardNm 설정하려는 yardNm입니다.
	 */
	public void setYardNm(String yardNm) {
		this.yardNm = yardNm;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTml_inv_sts_cd() {
		return tmlInvStsCd;
	}
	
	/**
	 * 
	 * @param tml_inv_sts_cd
	 */
	public void setTml_inv_sts_cd(String tml_inv_sts_cd) {
		this.tmlInvStsCd = tml_inv_sts_cd;
	}
}

