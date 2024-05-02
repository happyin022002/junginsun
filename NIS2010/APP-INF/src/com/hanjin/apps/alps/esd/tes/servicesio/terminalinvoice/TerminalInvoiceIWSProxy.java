/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceIWSProxy.java
*@FileTitle : TerminalInvoice Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : doomi
*@LastVersion : 1.0
* 2007-01-18 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.TerminalInvoiceInquiryRSC;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalInvoiceDiscrepancyCntr;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.OffDockCYInvoiceDiscrepancyCntr;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalStorageInvoiceDiscrepancyCntr;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalInvoiceDiscrepancyCntrResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalStorageInvoiceDiscrepancyCntrResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.OffDockCYInvoiceDiscrepancyCntrResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006EventResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryRetrive;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceExcelPrint;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005EventResponse;


/**
 * TerminalInvoice 에 대한 WebService Proxy<br>
 * 
 * @author doomi
 * @see TerminalInvoice 참조 
 * @since J2EE 1.6
 */
@WebService(name="TerminalInvoiceIWSProxyPortType", serviceName="TerminalInvoiceIWSProxy",
        targetNamespace="http://www.hanjin.com/integration")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/TerminalInvoiceIWSProxy",
             portName="TerminalInvoiceIWSProxyPort")
             
public class TerminalInvoiceIWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @return response String
     */
    
    public String getServiceName() {
    	return "TerminalInvoice Web-Service";
    }



    /**
     * TerminalInvoice <br>
     * 
     * @param docIn
     * @return responseTerminalInvoiceResponse
     * @exception EventException
     */
    
    @WebMethod()
	public TerminalInvoiceInquiryResponse searchTerminalInvoiceList(TerminalInvoiceInquiryRetrive docIn) { 
		
		Event	 event	= null;
    	TerminalInvoiceInquiryRSC	rsc		= new TerminalInvoiceInquiryRSC();
    	TerminalInvoiceInquiryResponse	docOut	= new TerminalInvoiceInquiryResponse();
    	
    	
    	try {
			/*		EVENT 생성 / 전송		*/
    		event = new SppTes0005Event(
    				docIn.getVendorCode(),
					docIn.getDateGubun(),			
    				docIn.getFromDt(),				
					docIn.getToDt(),					
					docIn.getInvoiceStatus(),						
					docIn.getInvoiceNo(),
					// 2008-04-17 by KJJ
					docIn.getIss_dt(),
					docIn.getRcv_dt(),
					docIn.getTml_inv_sts_cd(),
					docIn.getTml_so_ofc_cty_cd(),
					docIn.getTml_so_seq());				

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			/*	EventResponse로 부터 전송 객체의 생성		*/
			SppTes0005EventResponse eventResponse = (SppTes0005EventResponse)rsc.perform(event);
			
			docOut.setTerminalInvoiceInquiryList(eventResponse.getTerminalInvoiceInquiryList()); 
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
     * TerminalInvoice <br>
     * 
     * @param docIn
     * @return responseTerminalInvoiceResponse
     * @exception EventException
     */
    
    @WebMethod()
	public TerminalInvoiceInquiryResponse searchTerminalInvoiceExcelPrint(TerminalInvoiceExcelPrint docIn) { 
		
		Event	 event	= null;
    	TerminalInvoiceInquiryRSC	rsc		= new TerminalInvoiceInquiryRSC();
    	TerminalInvoiceInquiryResponse	docOut	= new TerminalInvoiceInquiryResponse();
    	
    	try {
			/* 	EVENT 생성 / 전송 	*/
    		event = new SppTes0005Event(docIn.getServiceOrderNo());			

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH02);
			event.setFormCommand(f);
			
			/*	EventResponse로 부터 전송 객체의 생성		*/
			SppTes0005EventResponse eventResponse = (SppTes0005EventResponse)rsc.perform(event);
			
			docOut.setTerminalInvoiceInquiryList(eventResponse.getTerminalInvoiceInquiryList()); 
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
	 * 
	 * @param docIn
	 * @return
	 */
    
    @WebMethod()
	public MarineTerminalInvoiceDiscrepancyCntrResponse searchMarineTerminalInvoiceDiscrepancyCntrList(MarineTerminalInvoiceDiscrepancyCntr docIn){
		Event	 event	= null;
    	TerminalInvoiceInquiryRSC	rsc		= new TerminalInvoiceInquiryRSC();
    	MarineTerminalInvoiceDiscrepancyCntrResponse	docOut	= new MarineTerminalInvoiceDiscrepancyCntrResponse();
    	
    	try {

			/* 	EVENT 생성 / 전송 	*/ 
    		event = new SppTes0006Event(
					docIn.getTml_so_ofc_cty_cd(),
					docIn.getTml_so_seq(),
					docIn.getSeq(),
					docIn.getVsl_cd(),
					docIn.getSkd_voy_no(),
					docIn.getSkd_dir_cd(),
					docIn.getIo_bnd_cd());			

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			/*	EventResponse로 부터 전송 객체의 생성	 */
			SppTes0006EventResponse eventResponse = (SppTes0006EventResponse)rsc.perform(event);
			
			docOut.setMarineTerminalInvoiceDiscrepancyCntrList(eventResponse.getMarineTerminalInvoiceDiscrepancyCntrList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
		}
		
    	return docOut;    	
	}
	
	/**
	 * 
	 * @param docIn
	 * @return
	 */
    
    @WebMethod()
	public OffDockCYInvoiceDiscrepancyCntrResponse searchOffDockCYInvoiceDiscrepancyCntrList(OffDockCYInvoiceDiscrepancyCntr docIn){
		Event	 event	= null;
    	TerminalInvoiceInquiryRSC	rsc		= new TerminalInvoiceInquiryRSC();
    	OffDockCYInvoiceDiscrepancyCntrResponse	docOut	= new OffDockCYInvoiceDiscrepancyCntrResponse();
    	
    	try {

			/* 	EVENT 생성 / 전송 	*/ 
    		event = new SppTes0006Event(
					docIn.getTml_so_ofc_cty_cd(),
					docIn.getTml_so_seq());			

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH02);
			event.setFormCommand(f);
			
			/*	EventResponse로 부터 전송 객체의 생성	 */
			SppTes0006EventResponse eventResponse = (SppTes0006EventResponse)rsc.perform(event);
			
			docOut.setOffDockCYInvoiceDiscrepancyCntrList(eventResponse.getOffDockCYInvoiceDiscrepancyCntrList()); 
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
		}
		
    	return docOut;     	
	}
	
	/**
	 * 
	 * @param docIn
	 * @return
	 */
    
    @WebMethod()
	public MarineTerminalStorageInvoiceDiscrepancyCntrResponse searchMarineTerminalStorageInvoiceDiscrepancyCntr(MarineTerminalStorageInvoiceDiscrepancyCntr docIn){
		Event	 event	= null;
    	TerminalInvoiceInquiryRSC	rsc		= new TerminalInvoiceInquiryRSC();
    	MarineTerminalStorageInvoiceDiscrepancyCntrResponse	docOut	= new MarineTerminalStorageInvoiceDiscrepancyCntrResponse();
    	
    	try {

			/* 	EVENT 생성 / 전송 	*/ 
    		event = new SppTes0006Event(
					docIn.getTml_so_ofc_cty_cd(),
					docIn.getTml_so_seq());			

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH03);
			event.setFormCommand(f);
			
			/*	EventResponse로 부터 전송 객체의 생성	 */
			SppTes0006EventResponse eventResponse = (SppTes0006EventResponse)rsc.perform(event);
			
			docOut.setMarineTerminalStorageInvoiceDiscrepancyCntrList(eventResponse.getMarineTerminalStorageInvoiceDiscrepancyCntrList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
		}
    	return docOut;     	
	}
}
