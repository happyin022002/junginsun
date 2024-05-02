/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WebGateIWSProxy.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.CntrMvmt;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.CntrMvmtRequest;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.CntrMvmtResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.Movement;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.MovementRequest;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.MovementResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001EventResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002EventResponse;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * WebGate 에 대한 WebService Proxy<br> 
 *
 * @author cho_gilhong
 * @see WebGateRSC 참조
 * @since J2EE 1.6
 */

@WebService(name="newwebgateIWSProxyPortType", serviceName="NewWebGateIWSProxy",
        targetNamespace="http://www.clt.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/NewWebGateIWSProxy",
             portName="newwebgateIWSProxyPort")

public class NewWebGateIWSProxy {
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
    	return "WebGate Web-Service : " + id + " >> Deployed Date is 2007.07.10";
    }
    
    /**
     * Truck Movement Input
     * 
     * @param docIn MovementRequest
     * @return MevementResponse String
     */
    
    @WebMethod()
    public MovementResponse createTruckMovement(MovementRequest docIn) {
    	Event event = null;
    	WebGateRSC rsc = new WebGateRSC();
    	MovementResponse docOut	= new MovementResponse();
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
            event = new SppSce0001Event(checkString(docIn.getMov_tp()), 
            			         checkString(docIn.getNod_cd()), 
            			         checkString(docIn.getDirection()), 
            			         checkString(docIn.getMoved_by()),  
            			         checkString(docIn.getOffice()), 
            			         checkString(docIn.getUser_id()),
            			         checkString(docIn.getVndr_seq()),
            			         (Movement[])docIn.getMov()
            			        );
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            SppSce0001EventResponse eventResponse = (SppSce0001EventResponse)rsc.perform(event);
            docOut.setMovement((Movement[])eventResponse.getMov());
            docOut.setSuccess_count(eventResponse.getSuccess_count());
            docOut.setFail_count(eventResponse.getFail_count());
            docOut.setStatus("SUCCESS");
    	}catch(EventException ee) {
            log.error("WebGateIWS Error : " + ee.toString(), ee);
            docOut.setMovement((Movement[])docIn.getMov());
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getMov().length);
            docOut.setStatus(ee.getMessage());
    	}catch(Exception e) {
            log.error("WebGateIWS Error : " + e.toString(), e);
            docOut.setMovement((Movement[])docIn.getMov());
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getMov().length);
            docOut.setStatus(e.getMessage());
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
    public MovementResponse createYardTerminalLoadedMovement(MovementRequest docIn) {
    	Event event = null;
    	WebGateRSC rsc = new WebGateRSC();
    	MovementResponse docOut	= new MovementResponse();
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
            event = new SppSce0001Event(checkString(docIn.getMov_tp()), 
            			         checkString(docIn.getNod_cd()), 
            			         checkString(docIn.getDirection()), 
            			         checkString(docIn.getMoved_by()),
            			         checkString(docIn.getOffice()),
            			         checkString(docIn.getUser_id()),
            			         checkString(docIn.getVndr_seq()),
            			         (Movement[])docIn.getMov()
            			        );
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            SppSce0001EventResponse eventResponse = (SppSce0001EventResponse)rsc.perform(event);
            docOut.setMovement((Movement[])eventResponse.getMov());
            docOut.setSuccess_count(eventResponse.getSuccess_count());
            docOut.setFail_count(eventResponse.getFail_count());
            docOut.setStatus("SUCCESS");
    	}catch(EventException ee) {
            log.error("WebGateIWS Error : " + ee.toString(), ee);
            docOut.setMovement((Movement[])docIn.getMov());
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getMov().length);
            docOut.setStatus(ee.getMessage());
    	}catch(Exception e) {
            log.error("WebGateIWS Error : " + e.toString(), e);
            docOut.setMovement((Movement[])docIn.getMov());
            docOut.setSuccess_count(0);
            docOut.setFail_count(docIn.getMov().length);
            docOut.setStatus(e.getMessage());
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
    public CntrMvmtResponse selectCntrMvmt(CntrMvmtRequest docIn) {
    	Event event = null;
    	WebGateRSC rsc = new WebGateRSC();
    	CntrMvmtResponse docOut	= new CntrMvmtResponse();
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
            event = new SppSce0002Event(checkString(docIn.getBkbl_no()), 
            			         checkString(docIn.getCntr_no())
            			        );
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            SppSce0002EventResponse eventResponse = (SppSce0002EventResponse)rsc.perform(event);
            docOut.setMovement((CntrMvmt[])eventResponse.getCntrMvmt());
            docOut.setStatus("SUCCESS");
    	}catch(EventException ee) {
            log.error("WebGateIWS Error : " + ee.toString(), ee);
            docOut.setStatus("FAIL");
    	}catch(Exception e) {
            log.error("WebGateIWS Error : " + e.toString(), e);
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