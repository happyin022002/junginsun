/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSNoticeIWSProxy.java
*@FileTitle : SPP TRS Related to the main screen, Web Services
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;
import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.trs.servicesio.common.event.TRSNoticeRequest;
import com.clt.apps.opus.esd.trs.servicesio.common.event.TRSNoticeResponse;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * WebService<br>
 * - SPP TRS main screen Notice Value Object<br>
 * 
 * @author 
 * @see 
 * @since 
 */
@WebService(name="TRSNoticeIWSProxyPortType", serviceName="TRSNoticeIWSProxy",
        targetNamespace="http://www.clt.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/TRSNoticeIWSProxy",
             portName="TRSNoticeIWSProxyPort")
public class TRSNoticeIWSProxy {
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
    /**
     * 
     * @param request
     * @return
     */
    @WebMethod()
    public TRSNoticeResponse getTRSNoticeInquiry(TRSNoticeRequest request){

		TRSNoticeResponse response = new TRSNoticeResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationIWSProxy Start! ===");
			
			String mainFlag = request.getMainFlag();
			log.debug("[debug]=== mainFlag ===" + mainFlag);
			
			log.debug("[debug]=== TRSNoticeIWSProxy End! ===");

		} catch (Exception e){
			response.setStatus(e.getMessage());
			response.setCount(0);
			log.error("TRSNoticeIWSProxy Exception : " + e.getMessage(), e);
		}
		return response;
	}
}