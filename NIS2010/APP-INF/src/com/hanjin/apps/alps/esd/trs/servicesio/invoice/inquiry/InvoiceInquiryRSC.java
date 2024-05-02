/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryRSC.java
*@FileTitle : SPP TRS Invoice Inquiry
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
* 2007-05-15 sunghwan cho : Excel 추출시에는 별도 로직으로 분리
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.3
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.basic.InvoiceInquiryBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.basic.InvoiceInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Component<br>
 * - SPP TRS Invoice Inquiry<br>
 * 
 * @author sunghwan cho
 * @see Event
 * @since J2EE 1.4
 */
public class InvoiceInquiryRSC extends ServiceCommandSupport {
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
        
        if (e.getEventName().equalsIgnoreCase("SppTrsI05Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceInquiry(e);
        	}
        }
        
        return eventResponse;
    }
    
    /**
     * searchInvoiceInquiry<BR>
     * - Invoice 내역을 조회한다.<BR>
     * 
     * @param e Event
     * @return eventResponse EventResponse
     * @throws EventException
     */
    private EventResponse searchInvoiceInquiry(Event e) throws EventException {
    	SppTrsI05EventResponse eventResponse = null;
    	String inquiry_flag = "INQUIRY";	//조회 구분
        
        try {
        	log.debug("[debug]=== InvoiceInquiryRSC searchInvoiceInquiry Start!");
        	begin();
        	
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsI05Event event = (SppTrsI05Event)e;
        	
        	/**
        	 * 입력된 값 검증
        	 */
        	//벤더코드(필수)
        	String masterSPP = event.getMasterSPP();
        	
        	log.debug("[debug] masterSPP >> " + masterSPP);        	
        	log.debug("[debug] event.getVendorCode() >> " + event.getVendorCode());
        	
        	if(!"M".equals(masterSPP)){
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
        	}

        	//User ID(필수)
        	if ( event.getUserID() == null || event.getUserID().equals("") ) {
        		throw new EventException("System error : first input user id!");
        	}
        	//Period Type(옵션)
        	if ( event.getPeriodType() == null || event.getPeriodType().equals("") ) {
        		event.setPeriodType("");
        	} else {
//        		if ( event.getPeriodType().equals("ID") || event.getPeriodType().equals("SD") ) {
//	        	} else {
//	        		throw new EventException("System error : invalid date type!");
//	        	}
        		if ( !event.getPeriodType().equals("ID") && !event.getPeriodType().equals("SD") ) {
        			throw new EventException("System error : invalid date type!");
        		}
        	}
        	//Period Start Date(옵션)
        	if ( event.getPeriodStartDate() == null || event.getPeriodStartDate().equals("") ) {
        		event.setPeriodStartDate("");
        	} else {
        		if ( event.getPeriodStartDate().length() != 8 ) {
        			throw new EventException("System error : invalid start date!");
        		}
        	}
        	//Period Ended Date(옵션)
        	if ( event.getPeriodEndDate() == null || event.getPeriodEndDate().equals("") ) {
        		event.setPeriodEndDate("");
        	} else {
        		if ( event.getPeriodEndDate().length() != 8 ) {
        			throw new EventException("System error : invalid end date!");
        		}
        	}
        	//Period Type과 Date 입력확인 
        	if ( !event.getPeriodType().equals("") && !event.getPeriodStartDate().equals("") && !event.getPeriodEndDate().equals("") ) {
        		if ( Integer.parseInt(event.getPeriodStartDate()) > Integer.parseInt(event.getPeriodEndDate()) ) {
        			throw new EventException("System error : invalid date value!");
        		}
        	}
        	//Status(옵션)
        	if ( event.getStatus() == null || event.getStatus().equals("") ) {
        		event.setStatus("");
        	} else {
        		if ( event.getStatus().length() < 2 ) {
        			throw new EventException("System error : invalid status!");
        		}
        	}
        	//Invoice번호(옵션)
        	if ( event.getInvoiceNo() == null || event.getInvoiceNo().equals("") ) {
        		event.setInvoiceNo("");
        	} else {
        		if ( event.getInvoiceNo().length() < 4 ) {
        			throw new EventException("System error : invalid invoice number!");
        		}
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
         			throw new EventException("System error : invalid equipment type!");
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

        	//Excel, Print 조회시에는 Inquiry와는 다른 조건으로 조회
    		if ( !event.getExtInvoiceNo().equals("")  ) {
    			inquiry_flag = "EXTRACT";	//조회구분
    			//조회조건이 아무것도 없는 경우는 에러처리
            	if ( event.getExtInvoiceNo().equals("") ) {
            		throw new EventException("System error : first input extract invoice number!");
            	}
    		} else {
    			inquiry_flag = "INQUIRY";	//조회구분
            	//조회조건이 아무것도 없는 경우는 에러처리
            	if ( event.getPeriodType().equals("") && event.getPeriodStartDate().equals("") && 
            		 event.getPeriodEndDate().equals("") && event.getStatus().equals("") &&
            		 event.getInvoiceNo().equals("") && event.getWorkOrderNo().equals("") && 
            		event.getEquipmentNo().equals("") ) {
            		throw new EventException("System error : first input inquiry value!");
            	}
    		}

        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsI05EventResponse();
        	
        	// BasicCommand 생성
        	InvoiceInquiryBC command = new InvoiceInquiryBCImpl();

        	/**
        	 * Excel, Print 추출시에는 Inquiry와는 다른 쿼리를 수행한다.
        	 */
        	if ( inquiry_flag.equals("EXTRACT") ) {
        		//Invoice Inquiry Excel  추출
        		eventResponse = new SppTrsI05EventResponse(command.searchInvoiceInquiryExcelHeader(event),command.searchInvoiceInquiryExcelExtract(event),"SUCCESS");
        		//eventResponse = searchInvoiceInquiryExcelExtract2(e);	
        	} else {
        		//Invoice Inquiry List 추출
        		eventResponse = new SppTrsI05EventResponse(command.searchInvoiceInquiryList(event));
        	}
        	
            commit();
            
            log.debug("[debug]=== InvoiceInquiryRSC searchInvoiceInquiry End!");
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
    
    /**
     * searchInvoiceEquipmentList<BR>
     * - Invoice의 Equipment List를 조회한다.<BR>
     * 
     * @param vendorCode String
     * @param invoiceNo String
     * @return eventResponse EventResponse
     * @throws EventException
     */
    public InvoiceCreationInquiry[] searchInvoiceEquipmentList(String vendorCode, String invoiceNo) throws EventException {
    	InvoiceCreationInquiry[] invoiceCreationData = null;
        
        try {
        	log.debug("[debug]=== InvoiceInquiryRSC searchInvoiceEquipmentList Start!");
        	begin();
        	
        	// BasicCommand 생성
        	InvoiceInquiryBC command = new InvoiceInquiryBCImpl();

        	// Invoice Creation List 추출
        	invoiceCreationData = command.searchInvoiceEquipmentList(vendorCode, invoiceNo);
            
            commit();
            
            log.debug("[debug]=== InvoiceInquiryRSC searchInvoiceEquipmentList End!");
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	rollback();
        	log.error(ex);
            throw new EventException(ex.getMessage());
        }
        return invoiceCreationData;
    }
 

}
