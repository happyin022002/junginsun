/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoResponse.java
*@FileTitle : FillInEquipmentNo 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;


import java.util.Arrays;


/**
 * EXP_PAP_003Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_003EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class FillInEquipmentNoResponse {
	/** (Header) */
	private String	id				= "FillInEquipmentNoResponse";
	private String	status			= "";
	private int		count			= 0;
	private FillInEquipmentNoList[]	fillInEquipmentNoList	= null;
	/**
	 * @return count을 리턴합니다.
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count 설정하려는 count입니다.
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return fillInEquipmentNoList을 리턴합니다.
	 */
	public FillInEquipmentNoList[] getFillInEquipmentNoList() {
		FillInEquipmentNoList[] rtnVOs = null;
		if (this.fillInEquipmentNoList != null) {
			rtnVOs = Arrays.copyOf(this.fillInEquipmentNoList, this.fillInEquipmentNoList.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * @param fillInEquipmentNoList 설정하려는 fillInEquipmentNoList입니다.
	 */
	public void setFillInEquipmentNoList(
			FillInEquipmentNoList[] fillInEquipmentNoList) {
		if (fillInEquipmentNoList != null) {
			FillInEquipmentNoList[] tmpVOs = Arrays.copyOf(fillInEquipmentNoList, fillInEquipmentNoList.length);
			this.fillInEquipmentNoList = tmpVOs;
		} // end if
	}
	/**
	 * @return id을 리턴합니다.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 설정하려는 id입니다.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return status을 리턴합니다.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status 설정하려는 status입니다.
	 */
	public void setStatus(String status) {
		this.status = status;
	}



}
