/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingIWSProxy.java
*@FileTitle : RailBilling Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : egobird
*@LastVersion : 1.0
* 2006-12-22 egobird
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.EventParamToStringBuilder;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.RailBillingInquiryRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0013Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0013EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingCancelResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingCancelRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquiryExcelResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquiryExcelRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquirySearchResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquirySearchRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.RailBillingCommonRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.RailBillingAckCountSearchResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.RailBillingAckCountSearchRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0014Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0014EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0016Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0016EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0017Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0017EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptyInsertResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptyInsertRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptySearchResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptySearchRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptyVerifyResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingEmptyVerifyRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullExcelResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullExcelRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullInsertResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullInsertRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullSearchResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullSearchRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullVerifyResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.RailBillingFullVerifyRetrive;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * RailBilling WebService Proxy<br>
 *
 * @author egobird
 * @see RailBilling 
 * @since J2EE 1.6 
 */
@WebService(name="RailBillingIWSProxyPortType", serviceName="RailBillingIWSProxy",
        targetNamespace="http://www.smlines.com/integration")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/RailBillingIWSProxy",
             portName="RailBillingIWSProxyPort")
public class RailBillingIWSProxy {
	/**
	 * Log
	 */ 
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
     
    /**
     * 
     * @param userID
     * @return
     */
    @WebMethod()
    public String getServiceName(String userID) {
    	String svcName = "RailBilling Web-Service:[2008-02-12 10:00]-" + userID;
    	return svcName;
    }
    
    /**
     * RailBillingRequestCreation Search (Full)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingFullSearchResponse selectRailBillingReqCreateFull(RailBillingFullSearchRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingFullSearchResponse docOut	= new RailBillingFullSearchResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
 			event = new ExpPap0010Event(
							docIn.getUser_id(),
							docIn.getVender_cd(),
							docIn.getBkg_no()
						);
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
		
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0010EventResponse eventResponse = (ExpPap0010EventResponse)rsc.perform(event);

			docOut.setBkg_vrfy_rst_cd(eventResponse.getBkgVrfyRstCd());
			docOut.setBkg_vrfy_err_cd(eventResponse.getBkgVrfyErrCd());
			docOut.setBkg_vrfy_err_lang_tp_cd(eventResponse.getBkgVrfyErrLangTpCd());
			docOut.setBkg_vrfy_err_msg(eventResponse.getBkgVrfyErrMsg());
			docOut.setBookingSummary(eventResponse.getBookingSummary());
			docOut.setBookingDetailList(eventResponse.getBookingDetailList());
			docOut.setRailRampLocationInfo(eventResponse.getRailRampLocationInfo());
			docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingReqCreateFull] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());    		
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingReqCreateFull] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());		
    	}
		
    	return docOut;
    }
    
    /**
     * RailBillingRequestCreation Search Excel (Full)<br>
     * @param docIn
     * @return response RailBillingFullExcelResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingFullExcelResponse selectRailBillingReqCreateExcelFull(RailBillingFullExcelRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingFullExcelResponse docOut	= new RailBillingFullExcelResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0020Event(
    				docIn.getUser_id(),
    				docIn.getVender_cd(),
    				docIn.getTrsRailOrderKeyList()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.SEARCH);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0020EventResponse eventResponse = (ExpPap0020EventResponse)rsc.perform(event);
    		docOut.setBookingDetailList(eventResponse.getBookingDetailList());
    		docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingReqCreateExcelFull] : " + e1.getMessage());
    		docOut.setStatus(e1.getMessage());
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingReqCreateExcelFull] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());  
    	}
    	
    	return docOut;
    }
    
    /**
     * RailBillingRequestCreation Verify (Full)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingFullVerifyResponse verifyRailBillingReqCreateFull(RailBillingFullVerifyRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingFullVerifyResponse docOut	= new RailBillingFullVerifyResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0014Event(
					docIn.getUser_id(),
					docIn.getVender_cd(),
    				docIn.getBkg_no(),
    				docIn.getBkg_vrfy_rst_cd(),
    				docIn.getBkg_vrfy_err_cd(),
    				docIn.getBkg_vrfy_err_lang_tp_cd(),
    				docIn.getOrg_yd_cd(),
    				docIn.getDest_yd_cd(),
    				docIn.getBookingDetailList()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.SEARCH);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0014EventResponse eventResponse = (ExpPap0014EventResponse)rsc.perform(event);
    		docOut.setBookingDetailList(eventResponse.getBookingDetailList());
    		docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[verifyRailBillingReqCreateFull] : " + e1.getMessage());
    		docOut.setBookingDetailList(docIn.getBookingDetailList());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[verifyRailBillingReqCreateFull] : " + e2.getMessage());
    		docOut.setBookingDetailList(docIn.getBookingDetailList());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());  
    	}
    	
    	return docOut;
    }
    
    /**
     * RailBillingRequestCreation Insert (Full)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingFullInsertResponse insertRailBillingReqCreateFull(RailBillingFullInsertRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingFullInsertResponse docOut	= new RailBillingFullInsertResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0015Event(
    				docIn.getUser_id(),
					docIn.getVender_cd(),
    				docIn.getBkg_no(),
    				docIn.getBkg_vrfy_rst_cd(),
    				docIn.getBkg_vrfy_err_cd(),
    				docIn.getBkg_vrfy_err_lang_tp_cd(),
    				docIn.getVndrUserDetailInfo(),
    				docIn.getBookingSummary(),
    				docIn.getBookingDetailList(),
    				docIn.getRailRampLocationInfo()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.MULTI);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0015EventResponse eventResponse = (ExpPap0015EventResponse)rsc.perform(event);
    		docOut.setStatus(eventResponse.getSuccessFlag());
    	} catch(EventException e1) {
    		log.error("RailBilling Error[insertRailBillingReqCreateFull] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[insertRailBillingReqCreateFull] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
    	
    	return docOut;
    }
 
    /**
     * RailBillingRequestCreation Search (Full)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingEmptySearchResponse selectRailBillingReqCreateEmpty(RailBillingEmptySearchRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingEmptySearchResponse docOut	= new RailBillingEmptySearchResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
			event = new ExpPap0016Event(
							docIn.getUser_id(),
							docIn.getVender_cd()
						);
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0016EventResponse eventResponse = (ExpPap0016EventResponse)rsc.perform(event);
			docOut.setLocationDetailList(eventResponse.getLocationDetailList());
			docOut.setCntrTpSzList(eventResponse.getCntrTpSzList());
			docOut.setUserFavFmNodCd(eventResponse.getUserFavFmNodCd());
			docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingReqCreateEmpty] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingReqCreateEmpty] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
		
    	return docOut;
    }
    
    /**
     * RailBillingRequestCreation Verify (Empty)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingEmptyVerifyResponse verifyRailBillingReqCreateEmpty(RailBillingEmptyVerifyRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingEmptyVerifyResponse docOut	= new RailBillingEmptyVerifyResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0017Event(
    				docIn.getUser_id(),
					docIn.getVender_cd(),
    				docIn.getLoc_cd(),
    				docIn.getYd_cd(),
    				docIn.getEmptyContainerList()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.SEARCH);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0017EventResponse eventResponse = (ExpPap0017EventResponse)rsc.perform(event);
    		docOut.setEmptyContainerList(eventResponse.getEmptyContainerList());
    		docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[verifyRailBillingReqCreateEmpty] : " + e1.getMessage());
    		docOut.setEmptyContainerList(docIn.getEmptyContainerList());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[verifyRailBillingReqCreateEmpty] : " + e2.getMessage());
    		docOut.setEmptyContainerList(docIn.getEmptyContainerList());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
    	
    	return docOut;
    }   

    /**
     * RailBillingRequestCreation Insert (Empty)<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingEmptyInsertResponse insertRailBillingReqCreateEmpty(RailBillingEmptyInsertRetrive docIn) {
    	Event				    event	= null;
    	RailBillingReqCreateRSC	rsc		= new RailBillingReqCreateRSC();
    	RailBillingEmptyInsertResponse docOut	= new RailBillingEmptyInsertResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0018Event(
    				docIn.getUser_id(),
					docIn.getVender_cd(),
    				docIn.getLoc_cd(),
    				docIn.getYd_cd(),
    				docIn.getVndrUserDetailInfo(),
    				docIn.getEmptyContainerList()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.MULTI);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0018EventResponse eventResponse = (ExpPap0018EventResponse)rsc.perform(event);
    		docOut.setEmptyContainerList(docIn.getEmptyContainerList());
    		docOut.setStatus(eventResponse.getSuccessFlag());
    	} catch(EventException e1) {
    		log.error("RailBilling Error[insertRailBillingReqCreateEmpty] : " + e1.getMessage());
    		docOut.setEmptyContainerList(docIn.getEmptyContainerList());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[insertRailBillingReqCreateEmpty] : " + e2.getMessage());
    		docOut.setEmptyContainerList(docIn.getEmptyContainerList());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
    	
    	return docOut;
    }
    
    /**
     * RailBilling Inquiry Search <br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingInquirySearchResponse selectRailBillingInquiry(RailBillingInquirySearchRetrive docIn) {
    	Event				    event	= null;
    	RailBillingInquiryRSC	rsc		= new RailBillingInquiryRSC();
    	RailBillingInquirySearchResponse docOut	= new RailBillingInquirySearchResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
			event = new ExpPap0012Event(
							docIn.getUser_id(),
							docIn.getVender_cd(),
							docIn.getUser_role_cd(),
							docIn.getRailBillingInquiryCond()
						);
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0012EventResponse eventResponse = (ExpPap0012EventResponse)rsc.perform(event);
			docOut.setRailBillingInquiryList(eventResponse.getRailBillingInquiryList());
			docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingInquiry] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingInquiry] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
		
    	return docOut;
    }
    
    /**
     * RailBilling Inquiry Search Excel<br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingInquiryExcelResponse selectRailBillingInquiryExcel(RailBillingInquiryExcelRetrive docIn) {
    	Event				    event	= null;
    	RailBillingInquiryRSC	rsc		= new RailBillingInquiryRSC();
    	RailBillingInquiryExcelResponse docOut	= new RailBillingInquiryExcelResponse();
    	
    	try {
    		/**
    		 * EVENT 생성 / 전송 
    		 */
    		event = new ExpPap0021Event(
    				docIn.getUser_id(),
    				docIn.getVender_cd(),
    				docIn.getUser_role_cd(),
    				docIn.getTrsRailOrderKeyList()
    		);
    		FormCommand f = new FormCommand();
    		f.setCommand(FormCommand.SEARCH);
    		event.setFormCommand(f);
    		
    		/**
    		 * EventResponse로 부터 전송 객체의 생성 
    		 */
    		ExpPap0021EventResponse eventResponse = (ExpPap0021EventResponse)rsc.perform(event);
    		docOut.setRailBillingInquiryList(eventResponse.getRailBillingInquiryList());
    		docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingInquiryExcel] : " + e1.getMessage());
    		docOut.setStatus(e1.getMessage());
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingInquiryExcel] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
    	
    	return docOut;
    }
    
    /**
     * RailBilling Inquiry Confirm <br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
   public RailBillingCancelResponse cancelRailBillingList(RailBillingCancelRetrive docIn) {
    	Event				    event	= null;
    	RailBillingInquiryRSC	rsc		= new RailBillingInquiryRSC();
    	RailBillingCancelResponse docOut	= new RailBillingCancelResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
			event = new ExpPap0013Event(
							docIn.getUser_id(),
							docIn.getVender_cd(),
							docIn.getRailBillingInquiryList()
						);
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0013EventResponse eventResponse = (ExpPap0013EventResponse)rsc.perform(event);
			docOut.setA1Flag(eventResponse.getSuccessFlag());
			docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[cancelRailBillingList] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[cancelRailBillingList] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
		
    	return docOut;
    }
    
    /**
     * RailBilling Inquiry Confirm <br>
     * 
     * @param docIn ContainerRetrive
     * @return response ContainerResponse
     * @exception EventException
     */
    @WebMethod()
    public RailBillingAckCountSearchResponse selectRailBillingAckCount(RailBillingAckCountSearchRetrive docIn) {
    	Event				    event	= null;
    	RailBillingCommonRSC	rsc		= new RailBillingCommonRSC();
    	RailBillingAckCountSearchResponse docOut	= new RailBillingAckCountSearchResponse();
    	
    	try {
			/**
			 * EVENT 생성 / 전송 
			 */
			event = new ExpPap0019Event(
							docIn.getUser_id(),
							docIn.getVender_cd(),
							docIn.getMainFlag()
						);
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			ExpPap0019EventResponse eventResponse = (ExpPap0019EventResponse)rsc.perform(event);
			docOut.setAckCount(eventResponse.getAckCount());
			docOut.setStatus("SUCCESS");
    	} catch(EventException e1) {
    		log.error("RailBilling Error[selectRailBillingAckCount] : " + e1.getMessage());
			docOut.setStatus(e1.getMessage());
			log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	} catch(Exception e2) {
    		log.error("RailBilling Error[selectRailBillingAckCount] : " + e2.getMessage());
    		docOut.setStatus(Constants.UNHANDLED_EXPT_MSG);
    		log.error(new EventParamToStringBuilder(event, new StringBuffer()).objectToString());
    	}
		
    	return docOut;
    }
}
