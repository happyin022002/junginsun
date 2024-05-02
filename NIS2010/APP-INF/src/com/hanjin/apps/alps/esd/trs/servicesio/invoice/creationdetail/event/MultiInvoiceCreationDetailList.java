/*=========================================================
 *Copyright(c) 2006 CyberLogitec
*@FileName : SPP_TRS_I10Event.java
*@FileTitle : SPP TRS 메인화면 Invoice Request Event 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;
import java.util.Arrays;
/**
 * Value Object<br>
 * - SPP TRS Equipment List Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class MultiInvoiceCreationDetailList {
	
	private String invNo = "";
	private String invDate = "";
	private String invCurrCd = "";
	private String exchangeRate = "";
	private String exchangeCalculationLogicType = "TM";
	private String officeCode = "";
	private String invBzcAmt = "";
	private String invVatAmt = "";
	private String invWhldTaxAmt = "";
	private String invTtlAmt = "";
	private String trspInvAudStsCd = "RC";
	private String ifUsrId = "SPP_IF";
	private String ifSysKndCd = "W";
	private String trspInvActStsCd = "O";
	private String workOrderNo[] = null;
	
	private String errWorkOrderNo[] = null;
	private String errInvoiceNo[] = null;
	
	/**
	 * @return Returns the exchangeCalculationLogicType.
	 */
	public String getExchangeCalculationLogicType() {
		return exchangeCalculationLogicType;
	}
	/**
	 * @param exchangeCalculationLogicType The exchangeCalculationLogicType to set.
	 */
	public void setExchangeCalculationLogicType(String exchangeCalculationLogicType) {
		this.exchangeCalculationLogicType = exchangeCalculationLogicType;
	}
	/**
	 * @return Returns the exchangeRate.
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * @param exchangeRate The exchangeRate to set.
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	/**
	 * @return Returns the inv_bzc_amt.
	 */
	public String getInv_bzc_amt() {
		return invBzcAmt;
	}
	/**
	 * @param inv_bzc_amt The inv_bzc_amt to set.
	 */
	public void setInv_bzc_amt(String inv_bzc_amt) {
		this.invBzcAmt = inv_bzc_amt;
	}
	/**
	 * @return Returns the inv_curr_cd.
	 */
	public String getInv_curr_cd() {
		return invCurrCd;
	}
	/**
	 * @param inv_curr_cd The inv_curr_cd to set.
	 */
	public void setInv_curr_cd(String inv_curr_cd) {
		this.invCurrCd = inv_curr_cd;
	}
	/**
	 * @return Returns the inv_date.
	 */
	public String getInv_date() {
		return invDate;
	}
	/**
	 * @param inv_date The inv_date to set.
	 */
	public void setInv_date(String inv_date) {
		this.invDate = inv_date;
	}
	/**
	 * @return Returns the inv_no.
	 */
	public String getInv_no() {
		return invNo;
	}
	/**
	 * @param inv_no The inv_no to set.
	 */
	public void setInv_no(String inv_no) {
		this.invNo = inv_no;
	}
	/**
	 * @return Returns the inv_ttl_amt.
	 */
	public String getInv_ttl_amt() {
		return invTtlAmt;
	}
	/**
	 * @param inv_ttl_amt The inv_ttl_amt to set.
	 */
	public void setInv_ttl_amt(String inv_ttl_amt) {
		this.invTtlAmt = inv_ttl_amt;
	}
	/**
	 * @return Returns the inv_vat_amt.
	 */
	public String getInv_vat_amt() {
		return invVatAmt;
	}
	/**
	 * @param inv_vat_amt The inv_vat_amt to set.
	 */
	public void setInv_vat_amt(String inv_vat_amt) {
		this.invVatAmt = inv_vat_amt;
	}
	/**
	 * @return Returns the inv_whld_tax_amt.
	 */
	public String getInv_whld_tax_amt() {
		return invWhldTaxAmt;
	}
	/**
	 * @param inv_whld_tax_amt The inv_whld_tax_amt to set.
	 */
	public void setInv_whld_tax_amt(String inv_whld_tax_amt) {
		this.invWhldTaxAmt = inv_whld_tax_amt;
	}
	/**
	 * @return Returns the officeCode.
	 */
	public String getOfficeCode() {
		return officeCode;
	}
	/**
	 * @param officeCode The officeCode to set.
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	/**
	 * @return Returns the errInvoiceNo.
	 */
	public String[] getErrInvoiceNo() {
		String[] rtnList = null;
		if(this.errInvoiceNo != null){
			rtnList = Arrays.copyOf(errInvoiceNo, errInvoiceNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errInvoiceNo The errInvoiceNo to set.
	 */
	public void setErrInvoiceNo(String[] errInvoiceNo) {
		if(errInvoiceNo != null){
			String[] tmpList = Arrays.copyOf(errInvoiceNo, errInvoiceNo.length);
			this.errInvoiceNo = tmpList;
		}
	}
	/**
	 * @return Returns the errWorkOrderNo.
	 */
	public String[] getErrWorkOrderNo() {
		String[] rtnList = null;
		if(this.errWorkOrderNo != null){
			rtnList = Arrays.copyOf(errWorkOrderNo, errWorkOrderNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errWorkOrderNo The errWorkOrderNo to set.
	 */
	public void setErrWorkOrderNo(String[] errWorkOrderNo) {
		if(errWorkOrderNo != null){
			String[] tmpList = Arrays.copyOf(errWorkOrderNo, errWorkOrderNo.length);
			this.errWorkOrderNo = tmpList;
		}
	}
	/**
	 * @return Returns the trsp_inv_aud_sts_cd.
	 */
	public String getTrsp_inv_aud_sts_cd() {
		return trspInvAudStsCd;
	}
	/**
	 * @param trsp_inv_aud_sts_cd The trsp_inv_aud_sts_cd to set.
	 */
	public void setTrsp_inv_aud_sts_cd(String trsp_inv_aud_sts_cd) {
		this.trspInvAudStsCd = trsp_inv_aud_sts_cd;
	}
	/**
	 * @return Returns the if_sys_knd_cd.
	 */
	public String getIf_sys_knd_cd() {
		return ifSysKndCd;
	}
	/**
	 * @param if_sys_knd_cd The if_sys_knd_cd to set.
	 */
	public void setIf_sys_knd_cd(String if_sys_knd_cd) {
		this.ifSysKndCd = if_sys_knd_cd;
	}
	/**
	 * @return Returns the if_usr_id.
	 */
	public String getIf_usr_id() {
		return ifUsrId;
	}
	/**
	 * @param if_usr_id The if_usr_id to set.
	 */
	public void setIf_usr_id(String if_usr_id) {
		this.ifUsrId = if_usr_id;
	}
	/**
	 * @return Returns the trsp_inv_act_sts_cd.
	 */
	public String getTrsp_inv_act_sts_cd() {
		return trspInvActStsCd;
	}
	/**
	 * @param trsp_inv_act_sts_cd The trsp_inv_act_sts_cd to set.
	 */
	public void setTrsp_inv_act_sts_cd(String trsp_inv_act_sts_cd) {
		this.trspInvActStsCd = trsp_inv_act_sts_cd;
	}
	/**
	 * @return Returns the workOrderNo.
	 */
	public String[] getWorkOrderNo() {
		String[] rtnList = null;
		if(this.workOrderNo != null){
			rtnList = Arrays.copyOf(workOrderNo, workOrderNo.length);
		}
		return rtnList;
	}
	/**
	 * @param workOrderNo The workOrderNo to set.
	 */
	public void setWorkOrderNo(String[] workOrderNo) {
		if(workOrderNo != null){
			String[] tmpList = Arrays.copyOf(workOrderNo, workOrderNo.length);
			this.workOrderNo = tmpList;
		}
	}

}
