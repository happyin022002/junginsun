/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppBkg0003EventResponse.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - SPP_BKG_0003 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author taekyoung.kim
 * @see ShipmentSC 참조
 * @since J2EE 1.4
 */

public class SppBkg0003EventResponse extends EventResponseSupport {

	// shpRqst array
	private ShpRqst[] shpRqst = null;
	private String vrfyRslt = "";
	
	// Success Flag
	private String successFlag = null;
	
	// info
	private int successCount = 0;
	private int failCount = 0;
	
    /**
     * SPP_BKG_0003 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 SCE_CUP_008EventResponse 객체를 생성
     * @param ShpRqst[] shpRqst
     * @param successFlag
     */
    public SppBkg0003EventResponse(ShpRqst[] shpRqst, String successFlag) {
    	this.shpRqst = shpRqst;
        this.successFlag=successFlag;
    }
	
	
	/**
     * get fail count
     * 
     * @return int fail count
     */
    public int getFail_count() {
    	return failCount;
    }
    /**
     * set fail count
     * 
     * @param fail_count int
     */
    public void setFail_count(int fail_count) {
    	this.failCount = fail_count;
    }
	
    /**
     * get shpRqst
     * 
     * @return ShpRqst[] shpRqst array
     */
    public ShpRqst[] getShpRqst() {
    	return shpRqst;
    }
    /**
     * set shpRqst
     * 
     * @param shpRqst ShpRqst array
     */
    public void setShpRqst(ShpRqst[] shpRqst) {
    	this.shpRqst = shpRqst;
    }
    
    /**
     * get success count
     * 
     * @return int success count
     */
    public int getSuccess_count() {
    	return successCount;
    }
    /**
     * set success count
     * 
     * @param success_count int
     */
    public void setSuccess_count(int success_count) {
    	this.successCount = success_count;
    }
    
    /**
     * get successFlag
     * 
     * @return String successFlag
     */
    public String getSuccessFlag() {
    	return successFlag;
    }
    /**
     * set successFlag
     * 
     * @param successFlag String
     */
    public void setSuccessFlag(String successFlag) {
    	this.successFlag = successFlag;
    }
    

	/**
	 * @return Returns the vrfyRslt.
	 */
	public String getVrfyRslt() {
		return vrfyRslt;
	}
	/**
	 * @param vrfyRslt The vrfyRslt to set.
	 */
	public void setVrfyRslt(String vrfyRslt) {
		this.vrfyRslt = vrfyRslt;
	}


}
