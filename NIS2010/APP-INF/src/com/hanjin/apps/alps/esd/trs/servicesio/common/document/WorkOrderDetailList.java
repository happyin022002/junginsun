/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailList.java
*@FileTitle : WorkOrderDetailList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailList {
	
	/** (Param 객체) */
	private int seq 				= 0 ;
	private	String trspSoNo 		= "";
	private	String validity  		= ""; //Validity
	private	String eqNo  			= ""; //Equipment Number  
	private	String eqTpszCd  		= ""; //Type/Size   
	private	String eqTpszNm  		= ""; //Type/Size Name  
	private	String isoCd  			= ""; //ISO Code        
	private	String isoNm  			= ""; //ISO Name        
	private	String apntDt  			= ""; //Appointmnet Time    
	private	String deliDt   		= ""; //Delivery Time          
	private	String rejectRsn   		= ""; //Reject Reason
	private	String bkgNo   			= ""; //bkg_no
	private String orgBkgNo         = "";
	private String dorNodCd			= ""; 
	private String trspBndCcd		= "";
	
	//2007.12.26 by KJJ
	//Door SVC type이 'Drop & Pick'인 경우, 
	//Empty/Full Container#를 SO Table에 I/F 시키기 위한 Param 추가
	private String actStsMapgCd  = "";	// Actual Status Mapping Code
	private String dorPkupCntrNo = "";	// Door Pickup Container Number
	private double woAmt		 = 0 ;	// WO Amount 
	private String woCreDt 		 = "";	// WO Creation Date
	
	//2014.04.30
	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
	private String loclCopCreDt  = "";
	
	//2015.09.02
	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
	private String cnmvVdstsDt  = "";
	
	//2015.10.07
	// W/O Detail 에 Bid No 컬럼 추가
	private String spotBidNo = "";
	
	private String trspCostDtlModNm = "";
	
	/**
	 * @return spot_bid_no 리턴합니다.
	 */
	public String getSpot_bid_no() {
		return spotBidNo;
	}
	/**
	 * @param spot_bid_no 설정하려는 spot_bid_no.
	 */
	public void setSpot_bid_no(String spot_bid_no) {
		this.spotBidNo = spot_bid_no;
	}
	
	/**
	 * @return cnmv_vdsts_dt 리턴합니다.
	 */
	public String getCnmv_vdsts_dt() {
		return cnmvVdstsDt;
	}
	/**
	 * @param cnmv_vdsts_dt 설정하려는 cnmv_vdsts_dt을.
	 */
	public void setCnmv_vdsts_dt(String cnmv_vdsts_dt) {
		this.cnmvVdstsDt = cnmv_vdsts_dt;
	}
	/**
	 * @return locl_cop_cre_dt을 리턴합니다.
	 */
	public String getLocl_cop_cre_dt() {
		return loclCopCreDt;
	}
	/**
	 * @param locl_cop_cre_dt을 설정하려는 locl_cop_cre_dt을.
	 */
	public void setLocl_cop_cre_dt(String locl_cop_cre_dt) {
		this.loclCopCreDt = locl_cop_cre_dt;
	}
	
	/**
	 * @return wo_cre_dt을 리턴합니다.
	 */
	public String getWo_cre_dt() {
		return woCreDt;
	}
	/**
	 * @param wo_cre_dt 설정하려는 wo_cre_dt입니다.
	 */
	public void setWo_cre_dt(String wo_cre_dt) {
		this.woCreDt = wo_cre_dt;
	}

	/**
	 * @return Returns the wo_amt.
	 */
	public double getWo_amt() {
		return woAmt;
	}

	/**
	 * @param wo_amt The wo_amt to set.
	 */
	public void setWo_amt(double wo_amt) {
		this.woAmt = wo_amt;
	}

	/**
	 * 
	 * @return act_sts_mapg_cd을 리턴합니다.
	 */
	public String getAct_sts_mapg_cd() {
		return actStsMapgCd;
	}
	
	/**
	 * 
	 * @param act_sts_mapg_cd 설정하려는 act_sts_mapg_cd입니다.
	 */
	public void setAct_sts_mapg_cd(String act_sts_mapg_cd) {
		this.actStsMapgCd = act_sts_mapg_cd;
	}
	
	/**
	 * 
	 * @return dor_pkup_cntr_no을 리턴합니다.
	 */
	public String getDor_pkup_cntr_no() {
		return dorPkupCntrNo;
	}
	
	/**
	 * 
	 * @param dor_pkup_cntr_no 설정하려는 dor_pkup_cntr_no입니다.
	 */
	public void setDor_pkup_cntr_no(String dor_pkup_cntr_no) {
		this.dorPkupCntrNo = dor_pkup_cntr_no;
	}
	
	/**
	 * @return apnt_dt을 리턴합니다.
	 */
	public String getApnt_dt() {
		return apntDt;
	}
	/**
	 * @param apnt_dt 설정하려는 apnt_dt입니다.
	 */
	public void setApnt_dt(String apnt_dt) {
		this.apntDt = apnt_dt;
	}
	/**
	 * @return bkg_no을 리턴합니다.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no 설정하려는 bkg_no입니다.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return org_bkg_no을 리턴합니다.
	 */
	public String getOrg_bkg_no() {
		return orgBkgNo;
	}
	/**
	 * @param org_bkg_no 설정하려는 org_bkg_no입니다.
	 */
	public void setOrg_bkg_no(String org_bkg_no) {
		this.orgBkgNo = org_bkg_no;
	}
	/**
	 * @return deli_dt을 리턴합니다.
	 */
	public String getDeli_dt() {
		return deliDt;
	}
	/**
	 * @param deli_dt 설정하려는 deli_dt입니다.
	 */
	public void setDeli_dt(String deli_dt) {
		this.deliDt = deli_dt;
	}
	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getEq_no() {
		return eqNo;
	}
	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}
	/**
	 * @return eq_tpsz_cd을 리턴합니다.
	 */
	public String getEq_tpsz_cd() {
		return eqTpszCd;
	}
	/**
	 * @param eq_tpsz_cd 설정하려는 eq_tpsz_cd입니다.
	 */
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eqTpszCd = eq_tpsz_cd;
	}
	/**
	 * @return eq_tpsz_nm을 리턴합니다.
	 */
	public String getEq_tpsz_nm() {
		return eqTpszNm;
	}
	/**
	 * @param eq_tpsz_nm 설정하려는 eq_tpsz_nm입니다.
	 */
	public void setEq_tpsz_nm(String eq_tpsz_nm) {
		this.eqTpszNm = eq_tpsz_nm;
	}
	/**
	 * @return iso_cd을 리턴합니다.
	 */
	public String getIso_cd() {
		return isoCd;
	}
	/**
	 * @param iso_cd 설정하려는 iso_cd입니다.
	 */
	public void setIso_cd(String iso_cd) {
		this.isoCd = iso_cd;
	}
	/**
	 * @return iso_nm을 리턴합니다.
	 */
	public String getIso_nm() {
		isoNm = StringEscapeUtils.escapeXml(isoNm);
		return isoNm;
	}
	/**
	 * @param iso_nm 설정하려는 iso_nm입니다.
	 */
	public void setIso_nm(String iso_nm) {
		this.isoNm = StringEscapeUtils.escapeXml(iso_nm);
	}
	/**
	 * @return reject_rsn을 리턴합니다.
	 */
	public String getReject_rsn() {
		rejectRsn = StringEscapeUtils.escapeXml(rejectRsn);
		return rejectRsn;
	}
	/**
	 * @param reject_rsn 설정하려는 reject_rsn입니다.
	 */
	public void setReject_rsn(String reject_rsn) {
		this.rejectRsn = StringEscapeUtils.escapeXml(reject_rsn);
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
	 * @return trsp_so_no을 리턴합니다.
	 */
	public String getTrsp_so_no() {
		return trspSoNo;
	}
	/**
	 * @param trsp_so_no 설정하려는 trsp_so_no입니다.
	 */
	public void setTrsp_so_no(String trsp_so_no) {
		this.trspSoNo = trsp_so_no;
	}
	/**
	 * @return validity을 리턴합니다.
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * @param validity 설정하려는 validity입니다.
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	/**
	 * @return Returns the dor_nod_cd.
	 */
	public String getDor_nod_cd() {
		return dorNodCd;
	}
	/**
	 * @param dor_nod_cd The dor_nod_cd to set.
	 */
	public void setDor_nod_cd(String dor_nod_cd) {
		this.dorNodCd = dor_nod_cd;
	}
	/**
	 * @return Returns the trsp_bnd_cd.
	 */
	public String getTrsp_bnd_cd() {
		return trspBndCcd;
	}
	/**
	 * @param trsp_bnd_cd The trsp_bnd_cd to set.
	 */
	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trspBndCcd = trsp_bnd_cd;
	}
	
	
	/**
	 * @return Returns the trsp_cost_dtl_mod_nm.
	 */
	public String getTrsp_cost_dtl_mod_nm() {
		return trspCostDtlModNm;
	}
	/**
	 * @param trsp_cost_dtl_mod_nm The trsp_cost_dtl_mod_nm to set.
	 */
	public void setTrsp_cost_dtl_mod_nm(String trsp_cost_dtl_mod_nm) {
		this.trspCostDtlModNm = trsp_cost_dtl_mod_nm;
	}
}
