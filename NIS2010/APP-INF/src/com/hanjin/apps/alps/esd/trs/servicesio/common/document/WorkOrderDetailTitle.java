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

/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailTitle {
	/** (Param 객체) */

	private	String issueTypeNm		= "";	//Issue Type                                 
	private	String trspWoNo			= "";	//W/O No
	private	String trspKindNm		= "";	//Transportation Kind                     
	private	String trspModeNm		= "";	//Transportation Mode                   
	private	String trspTypeNm		= "";	//Transportation Type
	private	String dispDt			= "";	//Dispatched Time    
	private String doorSvcTypeCd 	= "";	//Door SVC Type
	private String trspCreOfcCd  	= "";	//W/O Creation Office Code
	private String trspCreUsrEml 	= "";   //W/O Issuer Email Address
	
	/**
	 * @return cre_ofc_cd을 리턴합니다.
	 */
	public String getTrsp_cre_ofc_cd() {
		return trspCreOfcCd;
	}
	/**
	 * @param cre_ofc_cd 설정하려는 cre_ofc_cd입니다.
	 */
	public void setTrsp_cre_ofc_cd(String trsp_cre_ofc_cd) {
		this.trspCreOfcCd = trsp_cre_ofc_cd;
	}
	/**
	 * @return cre_usr_eml을 리턴합니다.
	 */
	public String getTrsp_cre_usr_eml() {
		return trspCreUsrEml;
	}
	/**
	 * @param cre_usr_eml 설정하려는 cre_usr_eml입니다.
	 */
	public void setTrsp_cre_usr_eml(String trsp_cre_usr_eml) {
		this.trspCreUsrEml = trsp_cre_usr_eml;
	}
	/**
	 * @return disp_dt을 리턴합니다.
	 */
	public String getDisp_dt() {
		return dispDt;
	}
	/**
	 * @param disp_dt 설정하려는 disp_dt입니다.
	 */
	public void setDisp_dt(String disp_dt) {
		this.dispDt = disp_dt;
	}
	/**
	 * @return issue_type_nm을 리턴합니다.
	 */
	public String getIssue_type_nm() {
		return issueTypeNm;
	}
	/**
	 * @param issue_type_nm 설정하려는 issue_type_nm입니다.
	 */
	public void setIssue_type_nm(String issue_type_nm) {
		this.issueTypeNm = issue_type_nm;
	}
	/**
	 * @return trsp_kind_nm을 리턴합니다.
	 */
	public String getTrsp_kind_nm() {
		return trspKindNm;
	}
	/**
	 * @param trsp_kind_nm 설정하려는 trsp_kind_nm입니다.
	 */
	public void setTrsp_kind_nm(String trsp_kind_nm) {
		this.trspKindNm = trsp_kind_nm;
	}
	/**
	 * @return trsp_mode_nm을 리턴합니다.
	 */
	public String getTrsp_mode_nm() {
		return trspModeNm;
	}
	/**
	 * @param trsp_mode_nm 설정하려는 trsp_mode_nm입니다.
	 */
	public void setTrsp_mode_nm(String trsp_mode_nm) {
		this.trspModeNm = trsp_mode_nm;
	}
	/**
	 * @return trsp_type_nm을 리턴합니다.
	 */
	public String getTrsp_type_nm() {
		return trspTypeNm;
	}
	/**
	 * @param trsp_type_nm 설정하려는 trsp_type_nm입니다.
	 */
	public void setTrsp_type_nm(String trsp_type_nm) {
		this.trspTypeNm = trsp_type_nm;
	}
	/**
	 * @return trsp_wo_no을 리턴합니다.
	 */
	public String getTrsp_wo_no() {
		return trspWoNo;
	}
	/**
	 * @param trsp_wo_no 설정하려는 trsp_wo_no입니다.
	 */
	public void setTrsp_wo_no(String trsp_wo_no) {
		this.trspWoNo = trsp_wo_no;
	}
	public String getDoor_svc_type_cd() {
		return doorSvcTypeCd;
	}
	public void setDoor_svc_type_cd(String door_svc_type_cd) {
		this.doorSvcTypeCd = door_svc_type_cd;
	}
	

	

}
