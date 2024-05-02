/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationRSC.java
*@FileTitle : SPP TRS Invoice Creation
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================
History
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.20 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가건 추가수정(1건)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.basic.InvoiceCreationBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.basic.InvoiceCreationBCImpl;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Command<br>
 * - SPP TRS Invoice Creation<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;

	/**
     * perform
     * @param e Event
     * @return eventResponse EventResponse
     */
	public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        if (e.getEventName().equalsIgnoreCase("SppTrsI01Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceCreationInquiry(e);
        	}
        }
        return eventResponse;
    }
    
    /**
     * searchInvoiceCreationInquiry
     * @param e Event
     * @return eventResponse EventResponse
     * @throws EventException
     */
    private EventResponse searchInvoiceCreationInquiry(Event e) throws EventException {
    	SppTrsI01EventResponse eventResponse = null;
        
        try {
        	log.debug("[debug]=== InvoiceCreationRSC searchInvoiceCreationInquiry Start!");
        	begin();
        	
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsI01Event event = (SppTrsI01Event)e;
        	
        	/**
        	 * 입력된 값 검증
        	 */
        	//벤더코드(필수)
			String venter_cd_temp[] = event.getVendorCode().split("-");
			if(venter_cd_temp.length > 0 && !"M".equals(venter_cd_temp[0])){
				String vendor_code = "";
				if("S".equals(venter_cd_temp[0])){
					vendor_code = venter_cd_temp[1];
				}else{
					vendor_code = venter_cd_temp[0];
				}
	        	if ( vendor_code == null || vendor_code.equals("") ) {
	        		throw new EventException("System error : first input vendor code!");
	        	} 
	        	//else {
	       		//	for (int i=0; i < vendor_code.length(); i++ ) {
	       		//		if ( "1234567890".indexOf(vendor_code.substring(i, i+1)) < 0 ){
	       		//			throw new EventException("System error : invalid vendor code!");
	       		//		}
	       		//	}
	        	//}
        	}
        	//User ID(필수)
        	if ( event.getUserID() == null || event.getUserID().equals("") ) {
        		throw new EventException("System error : first input user id!");
        	}
        	//WorkOrder번호(옵션)
        	if ( event.getWorkOrderNo() == null || event.getWorkOrderNo().equals("") ) {
        		event.setWorkOrderNo("");
        	} else {
        		if ( event.getWorkOrderNo().length() < 4 ) {
        			throw new EventException("System error : invalid workorder number!");
        		}
        	}
        	//Equipment번호(옵션)
        	if ( event.getEquipmentNo() == null || event.getEquipmentNo().equals("") ) {
        		event.setEquipmentNo("");
        	} else {
        		//Equipment Type
        		if ( event.getEquipmentNoType() == null || event.getEquipmentNoType().equals("") ) {
        			throw new EventException("System error : first input equipment type!");
        		}
           		if ( event.getEquipmentNo().length() < 4 ) {
             			throw new EventException("System error : invalid equipment number!");
           		}
        	}
        	//Booking번호(옵션)
        	if ( event.getBookingNo() == null || event.getBookingNo().equals("") ) {
        		event.setBookingNo("");
        	} else {
        		if ( event.getBookingNo().length() < 4 ) {
        			throw new EventException("System error : invalid equipment number!");
        		}
        	}
        	//BL번호(옵션)
        	if ( event.getBillOfLadingNo() == null || event.getBillOfLadingNo().equals("") ) {
        		event.setBillOfLadingNo("");
        	} else {
        		if ( event.getBillOfLadingNo().length() < 4 ) {
        			throw new EventException("System error : invalid billing number!");
        		}
        	}
        	//ServiceOrder번호(옵션)
        	if ( event.getServiceOrderNo() == null || event.getServiceOrderNo().equals("") ) {
        		event.setServiceOrderNo("");
        	} else {
        		if ( event.getServiceOrderNo().length() < 4 ) {
        			throw new EventException("System error : invalid serviceorder number!");
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
        	//조회조건이 아무것도 없는 경우는 에러처리
        	if(venter_cd_temp.length == 2 && !"M".equals(venter_cd_temp[0])){
	        	if ( event.getWorkOrderNo().equals("") && event.getEquipmentNo().equals("") && event.getBookingNo().equals("") && event.getBillOfLadingNo().equals("") && event.getServiceOrderNo().equals("") ) {
	        		throw new EventException("System error : invalid inquiry value for invoice creation!");
	        	}
        	}
        	
        	if ( event.getWorkOrderNo() != null && !event.getWorkOrderNo().equals("") ) {
        		//Work Order Number 존재여부 체크
            	checkExistWorkOrderNo(event);
        	}
        	
        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsI01EventResponse();
        	
        	// Basic Command 생성
        	InvoiceCreationBC command = new InvoiceCreationBCImpl();

        	/**
        	 * 데이터 추출
        	 */
           	eventResponse = new SppTrsI01EventResponse(command.searchInvoiceCreationList(event));        		
            
            commit();
            
            log.debug("[debug]=== InvoiceCreationRSC searchInvoiceCreationInquiry End!");
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * checkExistWorkOrderNo<BR>
     * 
     * @param e Event
     * @return void
     * @throws EventException
     */
    private void checkExistWorkOrderNo(Event e) throws EventException {
    	
    	try{
    		// Basic Command 생성
        	InvoiceCreationBCImpl command = new InvoiceCreationBCImpl();
    		command.checkExistWorkOrderNo(e);
    	}catch (EventException de){
    		log.error(de);
    		throw new EventException(de.getMessage());
    	}  	
    }
}
