/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceSurchargeRSC.java
*@FileTitle : SPP TRS Invoice Surchage
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.basic.InvoiceSurchargeBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.basic.InvoiceSurchargeBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Command<br>
 * - SPP TRS Invoice Surcharge<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSurchargeRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * perform<BR>
     * 
     * @param e Event
     * @return eventResponse EventResponse
     * @throws EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        if (e.getEventName().equalsIgnoreCase("SppTrsI04Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceSurchargeInquiry(e);
        	}
        }
        
        return eventResponse;
    }
    
    /**
     * searchInvoiceSurchargeInquiry<BR>
     * 
     * @param e Event e
     * @return eventResponse SPP_TRS_I04EventResponse
     * @throws EventException
     */
    private EventResponse searchInvoiceSurchargeInquiry(Event e) throws EventException {
    	SppTrsI04EventResponse eventResponse = null;
        
        try {
        	log.debug("[debug]=== InvoiceSurchargeRSC searchInvoiceSurchargeInquiry Start!");
        	begin();
        	
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsI04Event event = (SppTrsI04Event)e;
        	
        	/**
        	 * 입력된 값 검증
        	 */
        	//벤더코드(필수)
        	if ( event.getVendorCode() == null || event.getVendorCode().equals("") ) {
        		throw new EventException("System error : first input vendor code!");
        	} else {
       			for (int i=0; i < event.getVendorCode().length(); i++ ) {
       				if ( "1234567890".indexOf(event.getVendorCode().substring(i, i+1)) < 0 ){
       					throw new EventException("System error : invalid vendor code!");
       				}
       			}
        	}
        	//User ID(필수)
        	if ( event.getUserID() == null || event.getUserID().equals("") ) {
        		throw new EventException("System error : first input user id!");
        	}
        	//Step Code(필수)
        	if ( event.getStep_cd() == null || event.getStep_cd().equals("") ) {
        		throw new EventException("System error : first input surcharge step code!");
        	} else {
        		if ( event.getStep_cd().length() != 2 ) {
        			throw new EventException("System error : invalid surcharge step Code!");
        		}
        	}
        	//Parent 벤더코드(필수)
        	if ( event.getParentVendorCode() == null || event.getParentVendorCode().equals("") ) {
        		throw new EventException("System error : first input parent vendor code!");
        	} else {
       			for (int i=0; i < event.getParentVendorCode().length(); i++ ) {
       				if ( "1234567890".indexOf(event.getParentVendorCode().substring(i, i+1)) < 0 ){
       					throw new EventException("System error : invalid parent vendor code!");
       				}
       			}
        	}
        	
        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsI04EventResponse();
        	
        	// Basic Command 생성
        	InvoiceSurchargeBC command = new InvoiceSurchargeBCImpl();

        	if ( event.getStep_cd().equalsIgnoreCase("WO") ) {
        		eventResponse = new SppTrsI04EventResponse(command.searchWorkOrderSurchargeInquiry(event));
        	} else if ( event.getStep_cd().equalsIgnoreCase("IV") ) {
        		eventResponse = new SppTrsI04EventResponse(command.searchInvoiceSurchargeInquiry(event));
        	} else {
        		throw new EventException("System error : invalid surcharge step Code!");
        	}
            
            commit();
            
            log.debug("[debug]=== InvoiceSurchargeRSC searchInvoiceSurchargeInquiry End!");
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	rollback();
        	log.error(ex);
            throw new EventException(ex.getMessage());
        }
        return eventResponse;
    }
    
}
