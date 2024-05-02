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
public class WorkOrderSheetSecondList {

	/** (Param 객체) */

	private	int seq									= 0;	          
	private	String equipmentNumber				= "";	          
	private	String typeSize							= "";	          
	private	String remark								= "";	          
	private	String quantity			= "";    //combined case II type3 : CY + CY MTY  
	private	String rate								= "";
	
	private String eqTpszCd			= "";
	/**
	 * @return equipmentNumber을 리턴합니다.
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	/**
	 * @param equipmentNumber 설정하려는 equipmentNumber입니다.
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	/**
	 * @return quantity을 리턴합니다.
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity 설정하려는 quantity입니다.
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return remark을 리턴합니다.
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark 설정하려는 remark입니다.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * @return typeSize을 리턴합니다.
	 */
	public String getTypeSize() {
		return typeSize;
	}
	/**
	 * @param typeSize 설정하려는 typeSize입니다.
	 */
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
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
	 * @return remark을 리턴합니다.
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param remark 설정하려는 remark입니다.
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * 
	 * @return eqTpszCd을 리턴합니다.
	 */
	public String getEqTpszCd() {
		return eqTpszCd;
	}
	/**
	 * 
	 * @param eqTpszCd 설정하려는 eqTpszCd입니다.
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
    

}
