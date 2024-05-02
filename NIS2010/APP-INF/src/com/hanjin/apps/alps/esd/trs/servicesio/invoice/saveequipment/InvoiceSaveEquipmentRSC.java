/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBCImpl.java
*@FileTitle : SPP TRS Invoice Creation Save Equipment List
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.basic.InvoiceSaveEquipmentBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.basic.InvoiceSaveEquipmentBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Command<br>
 * - SPP TRS Invoice Creation Save Equipment List<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSaveEquipmentRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * perform
	 * @param e Event
	 * @return eventResponse EventResponse
	 */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        if (e.getEventName().equalsIgnoreCase("SppTrsI03Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = checkInvoiceNumber(e);
        	}
        }
        return eventResponse;
    }
    
    /**
     * checkInvoiceNumber<BR>
     * - Vendor가 발행한 invoice번호의 중복 여부를 체크한다.<BR>
     * 
     * @param e Event
     * @return eventResponse EventResponse
     * @throws EventException
     */
    private EventResponse checkInvoiceNumber(Event e) throws EventException {
    	SppTrsI03EventResponse eventResponse = null;
        
        try {
        	log.debug("[debug]=== InvoiceSaveEquipmentRSC checkInvoiceNumber Start!");
        	begin();
        	
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsI03Event event = (SppTrsI03Event)e;
        	
        	/**
        	 * 입력된 값 검증
        	 */
        	//벤더코드(필수)
        	if ( event.getVendorCode() == null || event.getVendorCode().equals("") ) {
        		throw new EventException("System error : first input vendor code!");
        	} 
        	//else {
       		//	for (int i=0; i < event.getVendorCode().length(); i++ ) {
       		//		if ( "1234567890".indexOf(event.getVendorCode().substring(i, i+1)) < 0 ){
       		//			throw new EventException("System error : invalid vendor code!");
       		//		}
       		//	}
        	//}
        	//User ID(필수)
        	if ( event.getUserID() == null || event.getUserID().equals("") ) {
        		throw new EventException("System error : first input user id!");
        	}
        	//Invoice번호(필수)
        	if ( event.getInvoiceNo() == null || event.getInvoiceNo().equals("") ) {
        		throw new EventException("System error : first input invoice number!");
        	} else {
        		if ( event.getInvoiceNo().length() < 4 ) {
        			throw new EventException("System error : invalid invoice number!");
        		}
        	}
        	//Issue Date(필수)
        	if ( event.getIssueDate() == null || event.getIssueDate().equals("") ) {
        		throw new EventException("System error : first input invoice issue date!");
        	} else {
        		if ( event.getIssueDate().length() != 8 ) {
        			throw new EventException("System error : invalid invoice issue date!");
        		}
        	}
        	//Invoice Currency(필수)
        	if ( event.getInvoiceCurrency() == null || event.getInvoiceCurrency().equals("") ) {
        		throw new EventException("System error : first input invoice currency!");
        	} else {
        		if ( event.getInvoiceCurrency().length() != 3 ) {
        			throw new EventException("System error : invalid invoice currency!");
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
        	eventResponse = new SppTrsI03EventResponse();
        	
        	// Basic Command 생성
        	InvoiceSaveEquipmentBC command = new InvoiceSaveEquipmentBCImpl();

        	// 입력된 Invoic번호의 중복여부 체크
           	int iResult = command.checkInvoiceNumber(event);
           	
           	if ( iResult > 0 ) {
           		throw new EventException("already issued invoice Number!");
           	}

           	eventResponse.setCount(iResult);
           	
           	commit();
            
            log.debug("[debug]=== InvoiceCreationRSC checkInvoiceNumber End!");
        } catch (EventException de) {
            rollback();
            log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
}
