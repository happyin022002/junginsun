/*Copyright(c) 2006 CyberLogitec
*@FileName : ShippingInstructionListResponse.java
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

/**
 * ShippingInstructionListResponse에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author SEO MI JIN
 * @see SppBkg0002Event 참조
 * @since J2EE 1.4
 */
public class ShippingInstructionListResponse {	
	private String id			= "ShippingInstructionListResponse";
    private String status = null;
    private int successCount = 0;
    private int failCount = 0;
    
	
	private ShpRqst[] shpRqst;
	
	/**
	 * @return Returns the shpRqst.
	 */
	public ShpRqst[] getShpRqst(){
		return shpRqst;
	}
	
	/**
	 * @param shpRqst
	 */
	public void setShpRqst(ShpRqst[] shpRqst){
		this.shpRqst = shpRqst;
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
}
