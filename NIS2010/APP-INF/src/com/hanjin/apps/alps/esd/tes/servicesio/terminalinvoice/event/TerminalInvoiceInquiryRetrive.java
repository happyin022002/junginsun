/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryRetrive.java
*@FileTitle	: TerminalInvoiceInquiry
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * SPP_TES_005 에 대한 WebService Document Object including	Parameters<br>
 * - TerminalInvoiceIWSProxy의 Input	Parameter<br>
 * - SPP_TES_005Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */

public class TerminalInvoiceInquiryRetrive { 
	
	/**	(Param 객체) */
	private String userID = "";
	
	private	String dateGubun = null;			
	private	String fromDt = null;					
	private	String toDt = null;						
	private	String invoiceStatus =	null;		

	private	String invoiceNo = null;	
	private String vendorCode = "";
	
	/* 	2008-04-15 추가	*/
	private String issDt = null;
	private String rcvDdt = null;
	private String tmlInvStsCd = null;
	private String ydCd = null;
	private String currCd = null;
	private String ttlInvAmt = null;
	private String vatAmt = null;
	private String csrNo = null;
	private String payMzdLuCd = null;
	private String ftuUseCtnt1 = null;
	
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSeq = null; 	

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
		return tmlSoSeq;
	}

	/**
	 * 
	 * @param tml_so_seq
	 */
	public void setTml_so_seq(String tml_so_seq) {
		this.tmlSoSeq = tml_so_seq;
	}

	/**
	 * 
	 * @return
	 */
	public String getCsr_no() {
		return csrNo;
	}
	
	/**
	 * 
	 * @param csr_no
	 */
	public void setCsr_no(String csr_no) {
		this.csrNo = csr_no;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCurr_cd() {
		return currCd;
	}
	
	/**
	 * 
	 * @param curr_cd
	 */
	public void setCurr_cd(String curr_cd) {
		this.currCd = curr_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFtu_use_ctnt1() {
		return ftuUseCtnt1;
	}
	
	/**
	 * 
	 * @param ftu_use_ctnt1
	 */
	public void setFtu_use_ctnt1(String ftu_use_ctnt1) {
		this.ftuUseCtnt1 = ftu_use_ctnt1;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIss_dt() {
		return issDt;
	}
	
	/**
	 * 
	 * @param iss_dt
	 */
	public void setIss_dt(String iss_dt) {
		this.issDt = iss_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPay_mzd_lu_cd() {
		return payMzdLuCd;
	}
	
	/**
	 * 
	 * @param pay_mzd_lu_cd
	 */
	public void setPay_mzd_lu_cd(String pay_mzd_lu_cd) {
		this.payMzdLuCd = pay_mzd_lu_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRcv_dt() {
		return rcvDdt;
	}
	
	/**
	 * 
	 * @param rcv_dt
	 */
	public void setRcv_dt(String rcv_dt) {
		this.rcvDdt = rcv_dt;
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
	
	/**
	 * 
	 * @return
	 */
	public String getTtl_inv_amt() {
		return ttlInvAmt;
	}
	
	/**
	 * 
	 * @param ttl_inv_amt
	 */
	public void setTtl_inv_amt(String ttl_inv_amt) {
		this.ttlInvAmt = ttl_inv_amt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVat_amt() {
		return vatAmt;
	}
	
	/**
	 * 
	 * @param vat_amt
	 */
	public void setVat_amt(String vat_amt) {
		this.vatAmt = vat_amt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getYd_cd() {
		return ydCd;
	}
	
	/**
	 * 
	 * @param yd_cd
	 */
	public void setYd_cd(String yd_cd) {
		this.ydCd = yd_cd;
	}
	
	/**
	 * @return
	 */
	public String getUserID(){		
		return userID;	
	}
	
	/**
	 * @return
	 */
	public String getVendorCode(){		
		return vendorCode;	
	}
	
	/**
	 * @return
	 */
	public String getFromDt(){		
		return fromDt;				
	}
	
	/**
	 * @return
	 */
	public String getToDt()	{		
		return toDt;					
	}
	
	/**
	 * @return
	 */
	public String getInvoiceStatus(){		
		return invoiceStatus;		
	}
	
	/**
	 * @return
	 */
	public String getDateGubun(){		
		return dateGubun;			
	}
	
	/**
	 * @return
	 */
	public String getInvoiceNo(){		
		return invoiceNo;		
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {		
		this.userID = userID;	
	}
	
	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {		
		this.vendorCode = vendorCode;	
	}
	
	/**
	 * 
	 * @param fromDt
	 */
	public void	setFromDt(String fromDt) {		
		this.fromDt	= fromDt;			
	}
	
	/**
	 * 
	 * @param toDt
	 */
	public void	setToDt(String toDt) {		
		this.toDt = toDt;				
	}

	/**
	 * 
	 * @param invoiceStatus
	 */
	public void	setInvoiceStatus(String invoiceStatus){		
		this.invoiceStatus = invoiceStatus;		
	}

	/**
	 * 
	 * @param dateGubun
	 */
	public void	setDateGubun(String dateGubun) {		
		this.dateGubun = dateGubun;			
	}
	
	/**
	 * 
	 * @param invoiceNo
	 */
	public void	setInvoiceNo(String invoiceNo){		
		this.invoiceNo		= invoiceNo;		
	}
}
