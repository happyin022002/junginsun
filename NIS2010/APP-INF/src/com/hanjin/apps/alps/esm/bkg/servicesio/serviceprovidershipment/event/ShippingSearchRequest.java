/*Copyright(c) 2006 CyberLogitec
*@FileName : ShippingSearchRequest.java
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
 * ShippingSearchRequest에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author SEO MI JIN
 * @see SppBkg0003Event 참조
 * @since J2EE 1.4
 */
public class ShippingSearchRequest {
	
	private String userId			= null;
	private String status 		= null;
	
	private String bkgNo = null;
	private String cntrNo = null;
	private String vndrSeq = null;
	private String polCd = null;
	private String updDtFrom = null;
	private String updDtTo = null;	
	private String vrfyRslt = null;
		
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
	
	/**
	 * @return Returns the bkgNo.
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @param status The status to set.
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * @return Returns the cntrNo.
	 */
	public String getCntrNo() {
		return cntrNo;
	}
	/**
	 * @param cntrNo The cntrNo to set.
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * @return Returns the vndrSeq.
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}
	/**
	 * @param vndrSeq The vndrSeq to set.
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * @return Returns the polCd.
	 */
	public String getPolCd() {
		return polCd;
	}
	/**
	 * @param status The polCd to set.
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	
	/**
	 * @return Returns the updDtFrom.
	 */
	public String getUpdDtFrom() {
		return updDtFrom;
	}
	/**
	 * @param updDtFrom The updDtFrom to set.
	 */
	public void setUpdDtFrom(String updDtFrom) {
		this.updDtFrom = updDtFrom;
	}
	
	/**
	 * @return Returns the updDtTo.
	 */
	public String getUpdDtTo() {
		return updDtTo;
	}
	/**
	 * @param updDtTo The updDtTo to set.
	 */
	public void setUpdDtTo(String updDtTo) {
		this.updDtTo = updDtTo;
	}
}
