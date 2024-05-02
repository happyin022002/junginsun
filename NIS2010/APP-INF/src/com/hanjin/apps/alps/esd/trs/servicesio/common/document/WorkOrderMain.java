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
public class WorkOrderMain {
	/** (Param 객체) */

	private	String woKnt	= "";
	private String inKnt   = "";
	private String raKnt   = "";

	/**
	 * @return Returns the in_knt.
	 */
	public String getIn_knt() {
		return inKnt;
	}

	/**
	 * @param in_knt The in_knt to set.
	 */
	public void setIn_knt(String in_knt) {
		this.inKnt = in_knt;
	}

	/**
	 * @return Returns the ra_knt.
	 */
	public String getRa_knt() {
		return raKnt;
	}

	/**
	 * @param ra_knt The ra_knt to set.
	 */
	public void setRa_knt(String ra_knt) {
		this.raKnt = ra_knt;
	}

	/**
	 * @return wo_knt을 리턴합니다.
	 */
	public String getWo_knt() {
		return woKnt;
	}

	/**
	 * @param wo_knt 설정하려는 wo_knt입니다.
	 */
	public void setWo_knt(String wo_knt) {
		this.woKnt = wo_knt;
	}	         
																																							                                                            
}

