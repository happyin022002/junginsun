/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppBkg0001Event.java
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
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP_BKG_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceProviderShipmentWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ServiceProviderShipmentWSProxy 참조
 * @since J2EE 1.4
 */
public class SppBkg0001Event extends EventSupport {
	
	private String bkgNo = null;
	private String cntrNo = null;
	private String vndrSeq = null;
	private String polCd = null;
	private String vrfyRslt = null;
	
	private ShpRqst[] shpRqst = null;
	
	/**
	 * default constructor
	 */
	
	public SppBkg0001Event() {}

    /**
     * constructor for SPP_BKG_0001Event
     * @param shpRqst ShpRqst[]
     */
	public SppBkg0001Event(ShpRqst[] shpRqst){
		this.shpRqst = shpRqst;
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
}
	
