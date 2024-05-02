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
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;


import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoList;
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
		FillInEquipmentNoList[] rtnList = null;
		if(this.fillInEquipmentNoList != null){
			rtnList = Arrays.copyOf(fillInEquipmentNoList, fillInEquipmentNoList.length);
		}
		return rtnList;
	}
	/**
	 * @param fillInEquipmentNoList 설정하려는 fillInEquipmentNoList입니다.
	 */
	public void setFillInEquipmentNoList(FillInEquipmentNoList[] fillInEquipmentNoList) {
		if(fillInEquipmentNoList != null){
			FillInEquipmentNoList[] tmpList = Arrays.copyOf(fillInEquipmentNoList, fillInEquipmentNoList.length);
			this.fillInEquipmentNoList = tmpList;
		}
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
