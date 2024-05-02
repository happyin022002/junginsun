/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingEmptyInsertResponse
*@FileTitle : Rail Billing Request Empty Creation Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.BasicResponse;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingEmptyInsertResponse extends BasicResponse {
	/** (Header) */
	private String	id				= "RailBillingEmptyInsertResponse";
	private String	status			= null;
	
	
	private EmptyContainer[] emptyContainerList;
	
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return Returns the emptyContainerList.
	 */
	public EmptyContainer[] getEmptyContainerList() {
		EmptyContainer[] rtnList = null;
		if(this.emptyContainerList != null){
			rtnList = Arrays.copyOf(emptyContainerList, emptyContainerList.length);
		}
		return rtnList;
	}
	/**
	 * @param emptyContainerList The emptyContainerList to set.
	 */
	public void setEmptyContainerList(EmptyContainer[] emptyContainerList) {
		if(emptyContainerList != null){
			EmptyContainer[] tmpList = Arrays.copyOf(emptyContainerList, emptyContainerList.length);
			this.emptyContainerList = tmpList;
		}
	}
	
	/** (Param 객체) */
	
	

}
