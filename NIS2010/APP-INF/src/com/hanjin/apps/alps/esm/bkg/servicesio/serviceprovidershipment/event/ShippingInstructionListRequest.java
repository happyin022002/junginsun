/*Copyright(c) 2006 CyberLogitec
*@FileName : ShippingInstructionListRequest.java
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
 * ShippingInstructionListRequest에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author SEO MI JIN
 * @see SppBkg0003Event 참조
 * @since J2EE 1.4
 */
public class ShippingInstructionListRequest {
	
	private String userId			= null;
	private String status 		= null;
		
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
	 * @return Returns the user_id.
	 */
	public String getUser_id() {
		return userId;
	}
	/**
	 * @param user_id The user_id to set.
	 */
	public void setUser_id(String user_id) {
		this.userId = user_id;
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
