/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetCargoAwkward.java
*@FileTitle : WorkOrderSheetCargoAwkward 
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
 * EXP_PAP_006Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_006EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see WorkOrderIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetCargoAwkward {
	/** (Param 객체) */

	private	String awkward					= "";	
	private	int awkwardSeq					= 0;	
	private	String awkwardEqNo			= "";	
	private	String awkwardLength			= "";	
	private	String awkwardWidth			= "";	
	private	String awkwardHeight			= "";	
	private	String awkwardVoid			= "";
	/**
	 * @return awkward을 리턴합니다.
	 */
	public String getAwkward() {
		return awkward;
	}
	/**
	 * @param awkward 설정하려는 awkward입니다.
	 */
	public void setAwkward(String awkward) {
		this.awkward = awkward;
	}
	/**
	 * @return awkwardEqNo을 리턴합니다.
	 */
	public String getAwkwardEqNo() {
		return awkwardEqNo;
	}
	/**
	 * @param awkwardEqNo 설정하려는 awkwardEqNo입니다.
	 */
	public void setAwkwardEqNo(String awkwardEqNo) {
		this.awkwardEqNo = awkwardEqNo;
	}
	/**
	 * @return awkwardLength을 리턴합니다.
	 */
	public String getAwkwardLength() {
		return awkwardLength;
	}
	/**
	 * @param awkwardLength 설정하려는 awkwardLength입니다.
	 */
	public void setAwkwardLength(String awkwardLength) {
		this.awkwardLength = awkwardLength;
	}
	/**
	 * @return awkwardSeq을 리턴합니다.
	 */
	public int getAwkwardSeq() {
		return awkwardSeq;
	}
	/**
	 * @param awkwardSeq 설정하려는 awkwardSeq입니다.
	 */
	public void setAwkwardSeq(int awkwardSeq) {
		this.awkwardSeq = awkwardSeq;
	}
	/**
	 * @return awkwardVoid을 리턴합니다.
	 */
	public String getAwkwardVoid() {
		return awkwardVoid;
	}
	/**
	 * @param awkwardVoid 설정하려는 awkwardVoid입니다.
	 */
	public void setAwkwardVoid(String awkwardVoid) {
		this.awkwardVoid = awkwardVoid;
	}
	/**
	 * @return awkwardWidth을 리턴합니다.
	 */
	public String getAwkwardWidth() {
		return awkwardWidth;
	}
	/**
	 * @param awkwardWidth 설정하려는 awkwardWidth입니다.
	 */
	public void setAwkwardWidth(String awkwardWidth) {
		this.awkwardWidth = awkwardWidth;
	}	
	
	/**
	 * @return awkwardWidth을 리턴합니다.
	 */
	public String getAwkwardHeight() {
		return awkwardHeight;
	}
	/**
	 * @param awkwardWidth 설정하려는 awkwardWidth입니다.
	 */
	public void setAwkwardHeight(String awkwardHeight) {
		this.awkwardHeight = awkwardHeight;
	}	


}
