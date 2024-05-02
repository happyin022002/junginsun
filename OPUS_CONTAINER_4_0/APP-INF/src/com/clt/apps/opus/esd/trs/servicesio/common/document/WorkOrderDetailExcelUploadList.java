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
package com.clt.apps.opus.esd.trs.servicesio.common.document;


/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailExcelUploadList {
	/** (Param 객체) */

	
	private	String eqNo  = "";                 		//Equipment Number  
	private	String eqTpszCd  = "";         		//Type/Size   
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
	
	

}
