/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetCargoReefer.java
*@FileTitle : WorkOrderSheetCargoReefer 
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
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetCargoReefer {
	/** (Param 객체) */
	
	private	String reefer						= "";	
	private	int reeferSeq					= 0;	
	private	String reeferEqNo				= "";	
	private	String reeferTemperatureC	= "";	
	private	String reeferTemperatureF	= "";	
	private	String reeferVentilation		= "";
	/**
	 * @return reefer을 리턴합니다.
	 */
	public String getReefer() {
		return reefer;
	}
	/**
	 * @param reefer 설정하려는 reefer입니다.
	 */
	public void setReefer(String reefer) {
		this.reefer = reefer;
	}
	/**
	 * @return reeferEqNo을 리턴합니다.
	 */
	public String getReeferEqNo() {
		return reeferEqNo;
	}
	/**
	 * @param reeferEqNo 설정하려는 reeferEqNo입니다.
	 */
	public void setReeferEqNo(String reeferEqNo) {
		this.reeferEqNo = reeferEqNo;
	}
	/**
	 * @return reeferSeq을 리턴합니다.
	 */
	public int getReeferSeq() {
		return reeferSeq;
	}
	/**
	 * @param reeferSeq 설정하려는 reeferSeq입니다.
	 */
	public void setReeferSeq(int reeferSeq) {
		this.reeferSeq = reeferSeq;
	}
	/**
	 * @return reeferTemperatureC을 리턴합니다.
	 */
	public String getReeferTemperatureC() {
		return reeferTemperatureC;
	}
	/**
	 * @param reeferTemperatureC 설정하려는 reeferTemperatureC입니다.
	 */
	public void setReeferTemperatureC(String reeferTemperatureC) {
		this.reeferTemperatureC = reeferTemperatureC;
	}
	/**
	 * @return reeferTemperatureF을 리턴합니다.
	 */
	public String getReeferTemperatureF() {
		return reeferTemperatureF;
	}
	/**
	 * @param reeferTemperatureF 설정하려는 reeferTemperatureF입니다.
	 */
	public void setReeferTemperatureF(String reeferTemperatureF) {
		this.reeferTemperatureF = reeferTemperatureF;
	}
	/**
	 * @return reeferVentilation을 리턴합니다.
	 */
	public String getReeferVentilation() {
		return reeferVentilation;
	}
	/**
	 * @param reeferVentilation 설정하려는 reeferVentilation입니다.
	 */
	public void setReeferVentilation(String reeferVentilation) {
		this.reeferVentilation = reeferVentilation;
	}	
	


}
