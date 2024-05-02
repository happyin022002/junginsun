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
package com.clt.apps.opus.esd.trs.servicesio.common.document;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiry;


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
		if (availabilitylist != null) {
			AvailabilityList[] tmpVOs = Arrays.copyOf(availabilitylist, availabilitylist.length);
			this.availabilitylist = tmpVOs;
		} // end if
	}


	/**
	 * @return
	 */
	public AvailabilityList[] getAvailabilityList() {
		AvailabilityList[] rtnVOs = null;
		if (this.availabilitylist != null) {
			rtnVOs = Arrays.copyOf(this.availabilitylist, this.availabilitylist.length);
		} // end if
		return rtnVOs;
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
    	ClmInquiry[] rtnVOs = null;
		if (this.cntrClm != null) {
			rtnVOs = Arrays.copyOf(this.cntrClm, this.cntrClm.length);
		} // end if
		return rtnVOs;
    }
    
    /**
     * set ClmInquiry
     * 
     * @param cntrClm ClmInquiry array
     */
    public void setCntrClm(ClmInquiry[] cntrClm) {
		if (cntrClm != null) {
			ClmInquiry[] tmpVOs = Arrays.copyOf(cntrClm, cntrClm.length);
			this.cntrClm = tmpVOs;
		} // end if
    }

}
