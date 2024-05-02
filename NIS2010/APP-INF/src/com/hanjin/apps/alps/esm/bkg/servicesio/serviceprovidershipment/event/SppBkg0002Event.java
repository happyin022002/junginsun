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
 * SPP_BKG_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceProviderShipmentWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ServiceProviderShipmentWSProxy 참조
 * @since J2EE 1.4
 */
public class SppBkg0002Event extends EventSupport {

	private ShpRqst[] shpRqst = null;
	
	/**
	 * default constructor
	 */
	
	public SppBkg0002Event() {}
	
	/**
     * constructor for SPP_SCE_001Event
     * @param shpRqst ShpRqst[]
     */
	public SppBkg0002Event(ShpRqst[] shpRqst){
		this.shpRqst = shpRqst;
		
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
