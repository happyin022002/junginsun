/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EtsSceLinkIWSProxy.java
*@FileTitle : EtsSceLinkIWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-16
*@LastModifier : 9009633
*@LastVersion : 1.0
* 2009-12-16 9009633 
* 1.0 최초 생성]
* 2010-12-01 김진승 [소스품질보완] 테스트 적용을 위한 1차 수정, Edi315Send 메서드 주석으로 삭제 처리. edi315Send 가 대신 기능함. 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.etsscelink;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.hanjin.apps.alps.esd.sce.servicesio.etsscelink.event.EtsSceLinkEvent;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * EtsLink 에 대한 WebService Proxy<br>
 *
 * @author cho_gilhong
 * @see EtsSceLinkRSC 참조
 * @since J2EE 1.6
 */

@WebService(name="etsscelinkIWSProxyPortType", serviceName="EtsSceLinkIWSProxy",
        targetNamespace="http://www.smlines.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/EtsSceLinkIWSProxy",
             portName="etsscelinkIWSProxyPort")

public class EtsSceLinkIWSProxy {
    /**
     * Log
     */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @param id String
     * @return String response
     */
    public String getServiceName(String id) {
    	return "EtsSceLink Web-Service : " + id + " >> Deployed Date is 2009.12.16";
    }
    
    /**
     * Edi Send Input
     * 
     * @param docIn Edi315SendVO
     * @return String
     */
    @WebMethod()
    public String edi315Send(Edi315SendVO docIn) { // 품질검토 결함 보봔 -> 소문자 method
		Event	 event	= null;
		EtsSceLinkRSC	rsc		= new EtsSceLinkRSC();
		String retVal = "";
    	try {
    		
			/**
			 * EVENT 생성 / 전송 
			 */
    		event = new EtsSceLinkEvent(docIn);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);

			event.setFormCommand(f);
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			GeneralEventResponse  eventResponse = (GeneralEventResponse) rsc.perform(event);
			retVal = eventResponse.getUserMessage();

			
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			//throw new EventException(e.getMessage());
		} catch (Exception de){
			log.error(de.getMessage(), de);
			//throw new EventException(de.getMessage());
		}
		
    	return retVal;
    }
    
    /**
     * Replan COP
     * 
     * @param docIn SingleTransportationVO
     * @return  boolean
     */
    @WebMethod()
    public boolean replanCop (SingleTransportationVO docIn) {
		Event	 event	= null;
		EtsSceLinkRSC	rsc		= new EtsSceLinkRSC();
		boolean returnFlag = false;
    	try {
    		
			/**
			 * EVENT 생성 / 전송 
			 */
    		event = new EtsSceLinkEvent(docIn);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI02);
			event.setFormCommand(f);
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			GeneralEventResponse  eventResponse = (GeneralEventResponse) rsc.perform(event);
//			String retVal = eventResponse.getUserMessage();
			List<ReplanResultVO> voList = eventResponse.getRsVoList();
			
//			returnFlag = "1".equals(retVal) ? true : false;
			if (voList != null && voList.size() > 0) {
				ReplanResultVO rplnVO = voList.get(0);
				if (rplnVO.getRplnRsltFlg() == null)
					returnFlag = false;
				else
					returnFlag = rplnVO.getRplnRsltFlg().equals("Y") ? true : false;	
			} else 
				returnFlag = false; 
			
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			//throw new EventException(e.getMessage());
		} catch (Exception de){
			log.error(de.getMessage(), de);
			//throw new EventException(de.getMessage());
		}
		
    	return returnFlag;
    }
 
    /**
     * Modify So List
     * 
     * @param docIn SingleTransportationVO
     * @return  boolean
     */
    
    @WebMethod()
    public boolean modifySoList (SingleTransportationVO docIn) {
		Event	 event	= null;
		EtsSceLinkRSC	rsc		= new EtsSceLinkRSC();
		boolean returnFlag = false;
    	try {
    		
			/**
			 * EVENT 생성 / 전송 
			 */
    		event = new EtsSceLinkEvent(docIn);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI03);
			event.setFormCommand(f);
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			GeneralEventResponse  eventResponse = (GeneralEventResponse) rsc.perform(event);
			String retVal = eventResponse.getUserMessage();
			returnFlag = "1".equals(retVal) ? true : false;
			
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			//throw new EventException(e.getMessage());
		} catch (Exception de){
			log.error(de.getMessage(), de);
			//throw new EventException(de.getMessage());
		}
		
    	return returnFlag;
    }
     
}
