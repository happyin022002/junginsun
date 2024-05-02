/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ServiceProvicerVisibilityIWSProxy.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility;

import org.apache.log4j.Logger;


import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.ClmInquiryRSC;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiryRequest;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiryResponse;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003Event;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003EventResponse;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * ServiceProvicerVisibility 에 대한 WebService Proxy<br>
 *
 * @author 2007607
 * @see 
 * @since J2EE 1.4
 */
public class ServiceProviderVisibilityIWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @param id String
     * @return response String
     */
    public String getServiceName(String id) {
    	return "ServiceProviderVisibilityIWSProxy Web-Service : " + id + " >> Deployed Date is 2008.07.02";
    }
    
    /**
     * Yard/Terminal >> Loaded(Full) Movement Input
     * 
     * @param docIn MovementRequest
     * @return MevementResponse String
     */
    
    public ClmInquiryResponse getCntrClmInquiry(ClmInquiryRequest docIn) {
    	Event event = null;
    	ClmInquiryRSC rsc = new ClmInquiryRSC();
    	ClmInquiryResponse docOut	= new ClmInquiryResponse();
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
    
    private String checkString(String strArg) {
    	if(strArg == null) {
    	    return "";
    	}else {
    	    return strArg.trim();
    	}
    }
 
}
