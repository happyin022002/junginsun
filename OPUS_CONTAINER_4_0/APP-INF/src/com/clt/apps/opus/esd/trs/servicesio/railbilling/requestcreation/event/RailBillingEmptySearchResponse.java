/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingEmptySearchResponse
*@FileTitle : Rail Billing Request Empty Search Info Invoice
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
public class RailBillingEmptySearchResponse extends BasicResponse {
	/** (Header) */
	private String	id				= "RailBillingEmptySearchResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private LocationDetail[]  locationDetailList;
	private ContainerTypeSize[]  cntrTpSzList;
	private String  userFavFmNodCd;

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
	 * @return Returns the locationDetailList.
	 */
	public LocationDetail[] getLocationDetailList() {
		LocationDetail[] rtnList = null;
		if(this.locationDetailList != null){
			rtnList = Arrays.copyOf(locationDetailList, locationDetailList.length);
		}
		return rtnList;
	}

	/**
	 * @param locationDetailList The locationDetailList to set.
	 */
	public void setLocationDetailList(LocationDetail[] locationDetailList) {
		if(locationDetailList != null){
			LocationDetail[] tmpList = Arrays.copyOf(locationDetailList, locationDetailList.length);
			this.locationDetailList = tmpList;
		}
	}
	 
	/**
	 * @return Returns the cntrTpSzList.
	 */
	public ContainerTypeSize[] getCntrTpSzList() {
		ContainerTypeSize[] rtnList = null;
		if(this.cntrTpSzList != null){
			rtnList = Arrays.copyOf(cntrTpSzList, cntrTpSzList.length);
		}
		return rtnList;
	}

	/**
	 * @param cntrTpSzList The cntrTpSzList to set.
	 */
	public void setCntrTpSzList(ContainerTypeSize[] cntrTpSzList) {
		if(cntrTpSzList != null){
			ContainerTypeSize[] tmpList = Arrays.copyOf(cntrTpSzList, cntrTpSzList.length);
			this.cntrTpSzList = tmpList;
		}
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
	 * @return Returns the userFavFmNodCd.
	 */
	public String getUserFavFmNodCd() {
		return userFavFmNodCd;
	}

	/**
	 * @param userFavFmNodCd The userFavFmNodCd to set.
	 */
	public void setUserFavFmNodCd(String userFavFmNodCd) {
		this.userFavFmNodCd = userFavFmNodCd;
	}
	
	
	
}
