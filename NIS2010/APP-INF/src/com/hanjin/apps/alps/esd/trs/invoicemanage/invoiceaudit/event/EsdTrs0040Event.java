/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_040Event.java
*@FileTitle : Service Porvider로 부터 접수한 Refund Invoice 를 Audit 하고 수정하여 Confirm 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : chkong
*@LastVersion : 1.0 
* 2007-01-18 chkong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event;

import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.TrsTrspRfndInvVO;


/**
 * ESD_TRS_040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chkong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0040Event extends EventSupport {

	/** trs_trsp_rfnd_inv Table  Value Object */
	private TrsTrspRfndInvVO trsTrspRfndInvVO = null;
	private TrsTrspRfndInvVO[]trsTrspRfndInvVOs = null;
	private String comboSvcProvider = null;
	private String invCurrCd = null;
	private String invWhldTaxAmt = null;
	private String insflag = null;
	private String invNo = null;
	private String paymtSpCd = null;
	private String usrId = null;
	private String ofcCd  = null;
	private String invRcvDt = null;
	private String invIssDt = null;
	private String invBzcAmt = null;
	private String invVatAmt = null;
	private String invTtlAmt = null;

	
	public EsdTrs0040Event(){}

	/**
	 * @param trsTrspRfndInvVO
	 */
	public EsdTrs0040Event(TrsTrspRfndInvVO trsTrspRfndInvVO) {
		this.setTrsTrspRfndInvVO(trsTrspRfndInvVO);
    }

	public void setTrsTrspRfndInvVO(TrsTrspRfndInvVO trsTrspRfndInvVO) {
		this.trsTrspRfndInvVO = trsTrspRfndInvVO;
	}

	public TrsTrspRfndInvVO getTrsTrspRfndInvVO() {
		return trsTrspRfndInvVO;
	}

	public void setTrsTrspRfndInvVOs(TrsTrspRfndInvVO[] trsTrspRfndInvVOs) {
		this.trsTrspRfndInvVOs = trsTrspRfndInvVOs;
	}

	public TrsTrspRfndInvVO[] getTrsTrspRfndInvVOs() {
		return trsTrspRfndInvVOs;
	}
	
	public String getEventName() {
		return "EsdTrs0040Event";
	}

	public String toString() {
		return "EsdTrs0040Event";
	}

	public void setCombo_svc_provider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getCombo_svc_provider() {
		return comboSvcProvider;
	}

	public void setInv_curr_cd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}

	public String getInv_curr_cd() {
		return invCurrCd;
	}

	public void setInv_whld_tax_amt(String invWhldTaxAmt) {
		this.invWhldTaxAmt = invWhldTaxAmt;
	}

	public String getInv_whld_tax_amt() {
		return invWhldTaxAmt;
	}

	public void setInsflag(String insflag) {
		this.insflag = insflag;
	}

	public String getInsflag() {
		return insflag;
	}

	public void setInv_no(String invNo) {
		this.invNo = invNo;
	}

	public String getInv_no() {
		return invNo;
	}

	public void setPaymt_sp_cd(String paymtSpCd) {
		this.paymtSpCd = paymtSpCd;
	}

	public String getPaymt_sp_cd() {
		return paymtSpCd;
	}

	public void setUsr_id(String usrId) {
		this.usrId = usrId;
	}

	public String getUsr_id() {
		return usrId;
	}

	public void setOfc_cd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfc_cd() {
		return ofcCd;
	}

	public void setInv_rcv_dt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
	}

	public String getInv_rcv_dt() {
		return invRcvDt;
	}

	public void setInv_iss_dt(String invIssDt) {
		this.invIssDt = invIssDt;
	}

	public String getInv_iss_dt() {
		return invIssDt;
	}

	public void setInv_bzc_amt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
	}

	public String getInv_bzc_amt() {
		return invBzcAmt;
	}

	public void setInv_vat_amt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}

	public String getInv_vat_amt() {
		return invVatAmt;
	}

	public void setInv_ttl_amt(String invTtlAmt) {
		this.invTtlAmt = invTtlAmt;
	}

	public String getInv_ttl_amt() {
		return invTtlAmt;
	}

}
