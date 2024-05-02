/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTInvoiceMgtSC.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3007AEvent;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4003AEvent;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * ALPS-InvoiceMgt Business Logic ServiceCommand - ALPS-InvoiceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author CHOI SUNG HWAN
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */

public class DMTInvoiceMgtRDSC extends ServiceCommandSupport {
    // Login User Information

    /**
     * InvoiceMgt system 업무 시나리오 선행작업<br>
     * 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        log.debug("DMTInvoiceMgtRDSC 시작");
        try {
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    /**
     * InvoiceMgt system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("DMTInvoiceMgtRDSC 종료");
    }

    
	/**
	 * 업무 시나리오 수행<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.debug("\nDMTInvoiceMgtRDSC preform--------------------------------------");
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		 if (e.getEventName().equalsIgnoreCase("EesDmt3007AEvent")) { 
			 log.debug("BEFORE CALL =============================");
			 eventResponse = searchDemandNoteRD(e);
			 log.debug("AFTER CALL =============================");
		 }
		 else if(e.getEventName().equalsIgnoreCase("EesDmt4003AEvent")){
			 log.debug("BEFORE CALL =============================");
			 eventResponse = searchInvoiceIssueRD(e);
			 log.debug("AFTER CALL =============================");
		 }
		 
		
		return eventResponse;
	}
    
	/**
	 * EES_DMT_3007 : open<br>
	 * Demand Note RD 정보를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
    private EventResponse searchDemandNoteRD(Event e) throws EventException {
    	 DemandNoteSendBC command = new DemandNoteSendBCImpl();
         GeneralEventResponse eventResponse  = new GeneralEventResponse();
		try{
			EesDmt3007AEvent event = (EesDmt3007AEvent)e;
			
			
			String stringForRD = command.searchDemandNoteRD(event.getDemandNoteRDParmVOS());
			eventResponse.setCustomData("RD", stringForRD);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;

    }    
    
    /**
     * EES_DMT_4003 : open<br>
     * Invoice Issue RD 정보를 조회한다. <br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchInvoiceIssueRD(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
    	GeneralEventResponse eventResponse  = new GeneralEventResponse();
    	
    	try {
    		EesDmt4003AEvent event = (EesDmt4003AEvent)e;
    		
    		log.debug("jspno>>>>>"+event.getInvoiceIssueRDParamVO().getJspno());
    		log.debug("invoice_no>>>>>"+event.getInvoiceIssueRDParamVO().getInvoiceNo());
			
			String stringForRD = command.searchInvoiceIssueRD(event.getInvoiceIssueRDParamVO());
			eventResponse.setCustomData("RD", stringForRD);
    	}catch(EventException ex){
        	log.error("err " + ex.toString(), ex);
            throw ex;
        }catch(Exception ex){
        	log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    
    
       
}