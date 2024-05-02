/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingAckCountSearchResponse.java
*@FileTitle : Rail Billing AckCount Search Response
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.BasicResponse;

/**
 * EXP_PAP_012Response 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EXP_PAP_012EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingAckCountSearchResponse extends BasicResponse {
	/** (Header) */
	private String	id				= "RailBillingAckCountSearchResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private int ackCount;

	/**
	 * @return Returns the ackCount.
	 */
	public int getAckCount() {
		return ackCount;
	}

	/**
	 * @param ackCount The ackCount to set.
	 */
	public void setAckCount(int ackCount) {
		this.ackCount = ackCount;
	}

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
	
	
	
	
	

}
