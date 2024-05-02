/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityResponse.java
*@FileTitle : Availability 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;

import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.AvailabilityList;
import java.util.Arrays;

/**
 * EXP_PAP_004Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_004EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class AvailabilityResponse {
	/** (Header) */
	private String	a1Flag		= "fake flag";
	private String	id				= "AvailabilityResponse";
	private String	status			= "";
	private int		count			= 0;
	
	
	/** (Param 객체) */
	private AvailabilityList[]	availabilitylist	= null;
	private ClmInquiry[] cntrClm = null;
	
	/**
	 * @return
	 */
	public String getA1Flag() {
		return a1Flag;
	}

	/**
	 * @param
	 */
	public void setA1Flag(String flag) {
		this.a1Flag = flag;
	}


	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param
	 */
	public void setAvailabilityList(AvailabilityList[] availabilitylist) {
		if(availabilitylist != null){
			AvailabilityList[] tmpList = Arrays.copyOf(availabilitylist, availabilitylist.length);
			this.availabilitylist = tmpList;
		}
	}


	/**
	 * @return
	 */
	public AvailabilityList[] getAvailabilityList() {
		AvailabilityList[] rtnList = null;
		if(this.availabilitylist != null){
			rtnList = Arrays.copyOf(availabilitylist, availabilitylist.length);
		}
		return rtnList;
	}



	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	
    /**
     * get ClmInquiry
     * 
     * @return ClmInquiry[] cntrClm array
     */
    public ClmInquiry[] getCntrClm() {
    	ClmInquiry[] rtnList = null;
		if(this.cntrClm != null){
			rtnList = Arrays.copyOf(cntrClm, cntrClm.length);
		}
		return rtnList;
    }
    
    /**
     * set ClmInquiry
     * 
     * @param cntrClm ClmInquiry array
     */
    public void setCntrClm(ClmInquiry[] cntrClm) {
    	if(cntrClm != null){
    		ClmInquiry[] tmpList = Arrays.copyOf(cntrClm, cntrClm.length);
			this.cntrClm = tmpList;
		}
    }

}
