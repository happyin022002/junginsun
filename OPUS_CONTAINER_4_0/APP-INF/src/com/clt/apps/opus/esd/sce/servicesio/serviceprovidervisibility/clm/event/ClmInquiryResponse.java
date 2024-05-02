/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryResponse.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event;

import java.util.Arrays;

/**
 * SPP_SCE_003Response 에 대한 WebService Document Object including Parameters<br>
 * - ServiceProvicerVisibilityIWSProxy의 Output Parameter<br>
 * - SPP_SCE_003EventResponse에서 변환하여 사용<br>
 *
 * @author yeon-jin Park
 * @see ServiceProvicerVisibilityIWSProxy 참조
 * @since J2EE 1.4
 */
public class ClmInquiryResponse {
	private String id = "CntrCLMResponse";
    private String status 	= "";
	private int		count	= 0 ;
    
    /** (Param 객체) */
    private ClmInquiry[] cntrClm = null;
    
    
    /**
     * get id
     * 
     * @return String id
     */
    public String getId() {
    	return this.id;
    }
    
    /**
     * set id
     * 
     * @param id String
     */
    public void setId(String id) {
    	this.id = id;
    }
    
    
    /**
     * get status
     * 
     * @return String status
     */
    public String getStatus() {
    	return this.status;
    }
    
    /**
     * set status
     * 
     * @param status String
     */
    public void setStatus(String status) {
    	this.status = status;
    }
    /**
     * get CLMInquiry
     * 
     * @return CLMInquiry[] cntrClm array
     */
    public ClmInquiry[] getCntrClm() {
    	ClmInquiry[] rtnVOs = null;
		if (this.cntrClm != null) {
			rtnVOs = Arrays.copyOf(cntrClm, cntrClm.length);
		}
		return rtnVOs;
    }
    
    /**
     * set CLMInquiry
     * 
     * @param cntrClm CLMInquiry array
     */
    public void setCntrClm(ClmInquiry[] cntrClm) {
		if(cntrClm != null){
			ClmInquiry[] tmpVOs = Arrays.copyOf(cntrClm, cntrClm.length);
			this.cntrClm = tmpVOs;
		}
    }
    

	/**
	 * @return
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * @param
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
