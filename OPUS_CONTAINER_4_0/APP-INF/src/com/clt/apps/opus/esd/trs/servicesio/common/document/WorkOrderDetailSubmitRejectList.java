/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailSubmitList.java
*@FileTitle : WorkOrderDetailSubmitList
*Open Issues :
*Change history :
* 2007-08-13 Jung-Jae Kim : TRS 요청에 의해 bkg_no, bkg_no_split 추가.
*@LastModifyDate : 2007-08-13
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;


/**
 * EXP_PAP_002Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_002EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class WorkOrderDetailSubmitRejectList {

	/** (Param 객체) */
	private	String soNo  = ""; 
	private	String eqNo  = "";
	private	int woIssKnt  = 0;
	private	String appointmentTime  = "";
	private	String deliveryTime   = "";
	private	String rejectReason   = "";
	//TRS 요청에 의한 추가.
	private String bkgNo = "";
	private String bkgNoSplit = "";
	
	// 2007-09-04: 신희정 과장 요청에 의한 추가
	private String dorNodCd		= "";
	private String trspBndCd		= "";
	private String eqTpszCd		= "";
	
	//2007-12-26 by KJJ
	//Door SVC type이 'Drop & Pick'인 경우, 
	//Empty/Full Container#를 SO Table에 I/F 시키기 위한 Parma 추가
	private String dorPkupCntrNo = "";
	
	/**
	 * 
	 * @return
	 */
	public String getDor_pkup_cntr_no() {
		return dorPkupCntrNo;
	}
	
	/**
	 * 
	 * @param dor_pkup_cntr_no
	 */
	public void setDor_pkup_cntr_no(String dor_pkup_cntr_no) {
		this.dorPkupCntrNo = dor_pkup_cntr_no;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEq_tpsz_cd() {
		return eqTpszCd;
	}
	
	/**
	 * 
	 * @param eq_tpsz_cd
	 */
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eqTpszCd = eq_tpsz_cd;
	}
	/**
	 * @return Returns the bkg_no.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return Returns the bkg_no_split.
	 */
	public String getBkg_no_split() {
		return bkgNoSplit;
	}
	/**
	 * @param bkg_no_split The bkg_no_split to set.
	 */
	public void setBkg_no_split(String bkg_no_split) {
		this.bkgNoSplit = bkg_no_split;
	}
	/**
	 * @return appointmentTime을 리턴합니다.
	 */
	public String getAppointmentTime() {
		return appointmentTime;
	}
	/**
	 * @param appointmentTime 설정하려는 appointmentTime입니다.
	 */
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	/**
	 * @return deliveryTime을 리턴합니다.
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * @param deliveryTime 설정하려는 deliveryTime입니다.
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
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
	 * @return rejectReason을 리턴합니다.
	 */
	public String getRejectReason() {
		return rejectReason;
	}
	/**
	 * @param rejectReason 설정하려는 rejectReason입니다.
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	/**
	 * @return so_no을 리턴합니다.
	 */
	public String getSo_no() {
		return soNo;
	}
	/**
	 * @param so_no 설정하려는 so_no입니다.
	 */
	public void setSo_no(String so_no) {
		this.soNo = so_no;
	}
	/**
	 * @return wo_iss_knt을 리턴합니다.
	 */
	public int getWo_iss_knt() {
		return woIssKnt;
	}
	/**
	 * @param wo_iss_knt 설정하려는 wo_iss_knt입니다.
	 */
	public void setWo_iss_knt(int wo_iss_knt) {
		this.woIssKnt = wo_iss_knt;
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
		return trspBndCd;
	}
	/**
	 * @param trsp_bnd_cd The trsp_bnd_cd to set.
	 */
	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trspBndCd = trsp_bnd_cd;
	}
	

}


