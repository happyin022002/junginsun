/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityIWSProxy.java
*@FileTitle : Availability Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-22 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability;

import org.apache.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.ClmInquiryRSC;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiryRequest;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003Event;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.AvailabilityResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.AvailabilityRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.AvailabilityRetrive2;

import com.hanjin.apps.alps.esd.trs.servicesio.availability.AvailabilityRSC;

import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiryRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiryResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.ExpPap0004Event;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.ExpPap0004EventResponse;


/**
 * Availability 에 대한 WebService Proxy<br>
 * 
 * @author doomi
 * @see Availability 참조 
 * @since J2EE 1.6
 */
@WebService(name="AvailabilityIWSProxyPortType", serviceName="AvailabilityIWSProxy",
        targetNamespace="http://www.smlines.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/AvailabilityIWSProxy",
             portName="AvailabilityIWSProxyPort")
public class AvailabilityIWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @return response String
     */
    @WebMethod()
    public String getServiceName() {
    	return "Availability Web-Service";
    }



   /**
     * W/O 조회(발행일자 별 조회)<br>
     * 
     * @param docIn AvailabilityRetrive
     * @return response AvailabilityResponse
     * @exception EventException
     */
    @WebMethod()
	public AvailabilityResponse searchAvailabilityPeriod(AvailabilityRetrive docIn) {  
		
		Event	 event	= null;
    	AvailabilityRSC	rsc		= new AvailabilityRSC();
    	AvailabilityResponse	docOut	= new AvailabilityResponse();
    	
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
    		event = new ExpPap0004Event(
    				docIn.getVendorCode(),
    				docIn.getPeriod_flg(),						 
    				docIn.getFrom_dt(),						 
    				docIn.getTo_dt(),							 		 
    				docIn.getFreight_collect_flg(),            
    				docIn.getOriginal_bl_flg(),     
    				docIn.getCustoms_flg(), 
    				docIn.getCntr_pkup_no_flg(),
    				docIn.getAvailable_sts_flg()

			);				

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0004EventResponse eventResponse = (ExpPap0004EventResponse)rsc.perform(event);
			
			docOut.setAvailabilityList(eventResponse.getAvailabilityList()); 
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		
    	return docOut;
    }
    
	
	
	   /**
     * W/O 조회(WO 별 조회)<br>
     * 
     * @param docIn AvailabilityRetrive2
     * @return response AvailabilityResponse
     * @exception EventException
     */
    @WebMethod()
	public AvailabilityResponse searchAvailabilityNo(AvailabilityRetrive2 docIn) { 
    	
		Event	 event	= null;
    	AvailabilityRSC	rsc		= new AvailabilityRSC();
    	AvailabilityResponse	docOut	= new AvailabilityResponse();
    	
                                                                                                                                    
    	try {

    		event = new ExpPap0004Event(
    				docIn.getVendorCode(),
    				docIn.getTrsp_wo_no(),
    				docIn.getEq_no(),
    				docIn.getBkg_no(),
    				docIn.getBl_no()			
			);				

    		
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH02);
			event.setFormCommand(f);
			
			
			ExpPap0004EventResponse eventResponse = (ExpPap0004EventResponse)rsc.perform(event);
			
			docOut.setAvailabilityList(eventResponse.getAvailabilityList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		
    	return docOut;
    }
 
    /**
     * Yard/Terminal >> Loaded(Full) Movement Input
     * 
     * @param docIn MovementRequest
     * @return MevementResponse String
     */
    @WebMethod()
    public AvailabilityResponse getCntrClmInquiry(ClmInquiryRequest docIn) {
    	Event event = null;
    	ClmInquiryRSC rsc = new ClmInquiryRSC();
    	AvailabilityResponse docOut	= new AvailabilityResponse();
    	log.debug("ServiceProvicerVisibilityIWSProxy getCntrClmInquiry");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
            event = new SppSce0003Event(checkString(docIn.getBkg_no()), 
            			         checkString(docIn.getCntr_no()),
            			         checkString(docIn.getCop_no())
            			        );
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            SppSce0003EventResponse eventResponse = (SppSce0003EventResponse)rsc.perform(event);
            docOut.setCntrClm(eventResponse.getCntrClm());
            docOut.setCount(eventResponse.getTotalCount());
            docOut.setStatus("SUCCESS");
            
            log.debug("docOut.getCount()  "+docOut.getCount());
            log.debug("docOut.getStatus()  "+docOut.getStatus());
           // log.debug("docOut.getCntrClm()  "+docOut.getCntrClm().length);
            
    	}catch(EventException ee) {
            log.error("ServiceProviderVisibilityIWSProxy Error : " + ee.toString(), ee);
            docOut.setStatus("FAIL");
    	}catch(Exception e) {
            log.error("ServiceProviderVisibilityIWSProxy Error : " + e.toString(), e);
            docOut.setStatus("FAIL");
    	}
    	
    	return docOut;
    }
    
    /**
     * searchEmptyAvailabilityList<br>
     * 
     * @param docIn AvailabilityRetrive
     * @return response AvailabilityResponse
     * @exception EventException
     */
    @WebMethod()
	public EmptyAvailabilityInquiryResponse searchEmptyAvailabilityList(EmptyAvailabilityInquiryRequest docIn) {  
		
		Event	 event	= null;
    	AvailabilityRSC	rsc		= new AvailabilityRSC();
    	EmptyAvailabilityInquiryResponse	docOut	= new EmptyAvailabilityInquiryResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
    		event = new ExpPap0004Event(
    				docIn
			);				

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH03);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0004EventResponse eventResponse = (ExpPap0004EventResponse)rsc.perform(event);
			
			docOut.setEmptyAvailabilityInquiry(eventResponse.getEmptyAvailabilityInquiry()); 
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		
    	return docOut;
    }
    
    private String checkString(String strArg) {
    	if(strArg == null) {
    	    return "";
    	}else {
    	    return strArg.trim();
    	}
    }
 
}
