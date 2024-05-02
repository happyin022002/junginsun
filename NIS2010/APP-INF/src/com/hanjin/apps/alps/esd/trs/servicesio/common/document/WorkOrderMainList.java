/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderMainList.java
*@FileTitle : WorkOrderMainList 
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
 * EXP_PAP_005Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_005EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderMainList {
	/** (Param 객체) */

	private	String creDt					= "";	//Dispatched Time                         
	private	String trspWoNo				= "";	//W/O No
	private	String woIssStsCd			= "";	//Issue Type                                 
	private	String woIssStsNm			= "";	//Issue Type                                 
	/**
	 * @return cre_dt을 리턴합니다.
	 */
	public String getCre_dt() {
		return creDt;
	}
	/**
	 * @param cre_dt 설정하려는 cre_dt입니다.
	 */
	public void setCre_dt(String cre_dt) {
		this.creDt = cre_dt;
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
	/**
	 * @return wo_iss_sts_cd을 리턴합니다.
	 */
	public String getWo_iss_sts_cd() {
		return woIssStsCd;
	}
	/**
	 * @param wo_iss_sts_cd 설정하려는 wo_iss_sts_cd입니다.
	 */
	public void setWo_iss_sts_cd(String wo_iss_sts_cd) {
		this.woIssStsCd = wo_iss_sts_cd;
	}
	/**
	 * @return wo_iss_sts_nm을 리턴합니다.
	 */
	public String getWo_iss_sts_nm() {
		return woIssStsNm;
	}
	/**
	 * @param wo_iss_sts_nm 설정하려는 wo_iss_sts_nm입니다.
	 */
	public void setWo_iss_sts_nm(String wo_iss_sts_nm) {
		this.woIssStsNm = wo_iss_sts_nm;
	}
                            
																																								                                                            

}
