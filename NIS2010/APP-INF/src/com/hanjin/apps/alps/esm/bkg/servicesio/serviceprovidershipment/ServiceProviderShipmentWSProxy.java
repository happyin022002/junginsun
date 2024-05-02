/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ServiceProviserShipmentWSProxy.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.WebGateRSC;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShippingInstructionListResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShippingInstructionVerifyResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShippingSearchRequest;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShippingSearchResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShpRqst;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0001Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0001EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * WebGate 에 대한 WebService Proxy<br>
 *
 * @author cho_gilhong
 * @see WebGateRSC 참조
 * @since J2EE 1.6
 */
@WebService(name="ServiceProviderShipmentPortType", serviceName="ServiceProviderShipment", targetNamespace="http://www.hanjin.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/ServiceProviderShipment", portName="ServiceProviderShipmentPort")
public class ServiceProviderShipmentWSProxy {
	
	/*
	 * Log
	 */
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * Truck Movement Input
     * 
     * @param docIn ShippingInstructionVerify
     * @return ShippingInstructionVerifyResponse String
     */
	
	public ShippingInstructionVerifyResponse verifyShippingInstruction(ShippingInstructionVerifyResponse docIn) {
		Event event	=	null;
		ShipmentSC shp	= new ShipmentSC();
		ShippingInstructionVerifyResponse docOut = new ShippingInstructionVerifyResponse();
		
		try{			
			event = new SppBkg0001Event(docIn.getShpRqst());

			FormCommand cmd = new FormCommand();
			cmd.setCommand(FormCommand.SEARCH);
			event.setFormCommand(cmd);
			
			SppBkg0001EventResponse eventResponse = (SppBkg0001EventResponse)shp.perform(event);
			docOut.setShpRqst(eventResponse.getShpRqst());
			docOut.setStatus("SUCCESS");
		}catch(EventException e1){
			log.error("ShippingInstructionVerifyReponse : " + e1.getMessage());
			docOut.setStatus("FAIL");
		}
		
		return docOut;
	}
	
	/**
     * ShippingInstructionListResponse Input
     * 
     * @param docIn ShippingInstructionListResponse
     * @return ShippingInstructionListResponse String
     */
	
	public ShippingInstructionListResponse manageShippingRequest(ShippingInstructionListResponse docIn) {
		Event event	=	null;
		ShipmentSC shp	= new ShipmentSC();
		ShippingInstructionListResponse docOut = new ShippingInstructionListResponse();
		
		try{
			event = new SppBkg0002Event(docIn.getShpRqst());
			
			FormCommand cmd = new FormCommand();
			cmd.setCommand(FormCommand.MULTI);
			event.setFormCommand(cmd);
			
			SppBkg0002EventResponse eventResponse = (SppBkg0002EventResponse)shp.perform(event);
			docOut.setShpRqst((ShpRqst[])eventResponse.getShpRqst());
	        docOut.setSuccess_count(eventResponse.getSuccess_count());
	        docOut.setFail_count(eventResponse.getFail_count());
	        docOut.setStatus(eventResponse.getSuccessFlag());			
		}catch(EventException ee) {
            log.error("ShippingInstructionListResponse Error : " + ee.toString(), ee);
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getFail_count());
            docOut.setStatus(ee.getMessage());
    	}catch(Exception e) {
            log.error("ShippingInstructionListResponse Error : " + e.toString(), e);
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getFail_count());
            docOut.setStatus(e.getMessage());
    	}
		return docOut;
	}
	
	/**
     * ShippingInstructionListResponse Input
     * 
     * @param docIn ShippingInstructionListResponse
     * @return ShippingInstructionListResponse String
     */
	public ShippingSearchResponse searchShippingRequest(ShippingSearchRequest docIn) {
    	Event event = null;
    	ShipmentSC shp = new ShipmentSC();
    	ShippingSearchResponse docOut	= new ShippingSearchResponse();
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
            event = new SppBkg0003Event(docIn.getBkgNo(),docIn.getCntrNo(),docIn.getVndrSeq(),docIn.getPolCd(),docIn.getUpdDtFrom(), docIn.getUpdDtTo());
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            SppBkg0003EventResponse eventResponse = (SppBkg0003EventResponse)shp.perform(event);
            docOut.setShpRqst((ShpRqst[])eventResponse.getShpRqst());
            docOut.setStatus("SUCCESS");
    	}catch(EventException ee) {
            log.error("SearchShippingRequest Error : " + ee.toString(), ee);
            docOut.setStatus("FAIL");
    	}catch(Exception e) {
            log.error("SearchShippingRequest Error : " + e.toString(), e);
            docOut.setStatus("FAIL");
    	}   	
    	return docOut;
    }	
	
}
