/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetList.java
*@FileTitle : WorkOrderSheetList 
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
public class WorkOrderSheetFormatType {
	/** (Param 객체) */

	private String workOrderFormatTypeCd	= "";
	private String workOrderFormatTypeNm	= "";
	

	/**
	 * @return workOrderFormatTypeCd을 리턴합니다.
	 */
	public String getWorkOrderFormatTypeCd() {
		return workOrderFormatTypeCd;
	}
	/**
	 * @param workOrderFormatTypeCd 설정하려는 workOrderFormatTypeCd입니다.
	 */
	public void setWorkOrderFormatTypeCd(String workOrderFormatTypeCd) {
		this.workOrderFormatTypeCd = workOrderFormatTypeCd;
	}
	/**
	 * @return workOrderFormatTypeNm을 리턴합니다.
	 */
	public String getWorkOrderFormatTypeNm() {
		return workOrderFormatTypeNm;
	}
	/**
	 * @param workOrderFormatTypeNm 설정하려는 workOrderFormatTypeNm입니다.
	 */
	public void setWorkOrderFormatTypeNm(String workOrderFormatTypeNm) {
		this.workOrderFormatTypeNm = workOrderFormatTypeNm;
	}
	

}
