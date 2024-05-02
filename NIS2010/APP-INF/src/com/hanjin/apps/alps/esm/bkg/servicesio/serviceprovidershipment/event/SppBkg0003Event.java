/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppBkg0002Event.java
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

import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.ServiceProviderShipmentWSProxy;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * SPP_BKG_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceProviderShipmentWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ServiceProviderShipmentWSProxy 참조
 * @since J2EE 1.4
 */
public class SppBkg0003Event extends EventSupport {

	
	private String bkgNo = null;
	private String cntrNo = null;
	private String vndrSeq = null;
	private String polCd = null;
	private String updDtFrom = null;
	private String updDtTo = null;	
	private String vrfyRslt = null;	
	private ShpRqst[] shpRqst = null;
	
	/**
	 * default constructor
	 */
	
	public SppBkg0003Event() {}
	
    /**
     * constructor for SPP_BKG_0003Event
     * @param String bkgNo
     * @param String cntrNo
     * @param String vndrSeq
     * @param String polCd
     * @param String updDtFrom
     * @param String updDtTo  
     */
	public SppBkg0003Event(String bkgNo, String cntrNo, String vndrSeq, String polCd, String updDtFrom, String updDtTo){
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.polCd = polCd;
		this.updDtFrom = updDtFrom;
		this.updDtTo = updDtTo;
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
     * get ShippingRequest[]
     * 
     * @return move ShippingRequest[]
     */
    public ShpRqst[] getShpRqst() {
    	return shpRqst;
    }
    /**
     * set ShippingRequest[]
     * 
     * @param mov ShippingRequest[]
     */
    public void setShpRqst(ShpRqst[] shpRqst) {
    	this.shpRqst = shpRqst;
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
