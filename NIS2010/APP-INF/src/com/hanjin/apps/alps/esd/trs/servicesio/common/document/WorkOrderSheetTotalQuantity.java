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
public class WorkOrderSheetTotalQuantity {
	/** (Param 객체) */

	private	String totalQuantity20	= "";	                  
	private	String totalQuantity40	= "";	                  
	private	String totalAmount		= "";
	private	String totalQuantity	= "";
	private String currencyCode		= "";
	
	private String totalAmtUsd		= "";
	/**
	 * @return currencyCode를 리턴합니다.
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * @param currencyCode 설정하려는 currencyCode입니다..
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	/**
	 * @return totalAmount을 리턴합니다.
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount 설정하려는 totalAmount입니다.
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return totalQuantity20을 리턴합니다.
	 */
	public String getTotalQuantity20() {
		return totalQuantity20;
	}
	/**
	 * @param totalQuantity20 설정하려는 totalQuantity20입니다.
	 */
	public void setTotalQuantity20(String totalQuantity20) {
		this.totalQuantity20 = totalQuantity20;
	}
	/**
	 * @return totalQuantity40을 리턴합니다.
	 */
	public String getTotalQuantity40() {
		return totalQuantity40;
	}
	/**
	 * @param totalQuantity40 설정하려는 totalQuantity40입니다.
	 */
	public void setTotalQuantity40(String totalQuantity40) {
		this.totalQuantity40 = totalQuantity40;
	}	              
	/**
	 * @return totalQuantity을 리턴합니다.
	 */
	public String getTotalQuantity() {
		return totalQuantity;
	}
	/**
	 * @param totalQuantity 설정하려는 totalQuantity입니다.
	 */
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	/**
	 * 
	 * @return totalAmtUsd을 리턴합니다.
	 */
	public String getTotalAmtUsd() {
		return totalAmtUsd;
	}
	/**
	 * 
	 * @param totalAmtUsd 설정하려는 totalAmtUsd입니다.
	 */
	public void setTotalAmtUsd(String totalAmtUsd) {
		this.totalAmtUsd = totalAmtUsd;
	}	              

}
