/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailRSC.java
*@FileTitle : SPP TRS Invoice Detail EQ List 조회
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic.InvoiceCreationDetailBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic.InvoiceCreationDetailBCImpl;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Command<br>
 * - SPP TRS Invoice Creation Detail 화면<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDetailRSC extends ServiceCommandSupport {
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
        
        if (e.getEventName().equalsIgnoreCase("SppTrsI02Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceCreationDetailInquiry(e);
        	}
        }
        
        return eventResponse;
    }
    
    /**
     * searchInvoiceCreationDetailInquiry<BR>
     * 
     * @param e Event
     * @return eventResponse SppTrsI02EventResponse
     * @throws EventException
     */
    private EventResponse searchInvoiceCreationDetailInquiry(Event e) throws EventException {
    	SppTrsI02EventResponse eventResponse = null;
    	String inquiry_flag = "INQUIRY";	//조회 구분
        
        try {
        	log.debug("[debug]=== InvoiceCreationDetailRSC searchInvoiceCreationDetailInquiry Start!");
        	begin();
        	
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsI02Event event = (SppTrsI02Event)e;
        	
        	/**
        	 * 입력된 값 검증
        	 */
        	//벤더코드(필수)
            //2007-10-31 : master ID 추가 관련
        	String vndr_seq_temp[] = event.getVendorCode().split("-");
        	if(vndr_seq_temp.length != 2){
	        	if ( event.getVendorCode() == null || event.getVendorCode().equals("") ) {
	        		throw new EventException("System error : first input vendor code!");
	        	} else {
	       			for (int i=0; i < event.getVendorCode().length(); i++ ) {
	       				if ( "1234567890".indexOf(event.getVendorCode().substring(i, i+1)) < 0 ){
	       					throw new EventException("System error : invalid vendor code!");
	       				}
	       			}
	        	}
        	}
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
        	//Invoice Issue Date(필수)
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
        	
        	/**
        	 * Excel, Print 출력을 위한 Parameter<BR>
        	 * Portal화면에서 Invoice Creation Detail화면의 경우는 Array VO를 사용할 수 없어,<BR> 
        	 * 별도의 String Type으로 조회 조건을 받는다. <BR>
        	 */
        	//Extract WorkOrder
        	if ( event.getExtWorkOrderNo() == null || event.getExtWorkOrderNo().equals("") ) {
        		event.setExtWorkOrderNo("");
        	}
        	//Extract Service Order
        	if ( event.getExtServiceOrderNo() == null || event.getExtServiceOrderNo().equals("") ) {
        		event.setExtServiceOrderNo("");
        	}
        	//Extract Equipment
        	if ( event.getExtEquipmentNo() == null || event.getExtEquipmentNo().equals("") ) {
        		event.setExtEquipmentNo("");
        	}
        	
        	//조회조건이 아무것도 없는 경우는 에러처리
        	if ( event.getInvoiceNo().equals("") && event.getIssueDate().equals("") && event.getInvoiceCurrency().equals("") ) { 
       			throw new EventException("System error : invalid inquiry value for invoice creation detail!");
        	}
        	
        	//Excel, Print 조회시에는 Inquiry와는 다른 조건으로 조회
    		if ( !event.getExtWorkOrderNo().equals("") && !event.getExtServiceOrderNo().equals("") && !event.getExtEquipmentNo().equals("") ) {
    			inquiry_flag = "EXTRACT";	//조회구분
    		} else {
    			inquiry_flag = "INQUIRY";	//조회구분
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
        	 * Extract <BR>
        	 * - Excel, Print 추출시에는 InvoiceCreationData[] VO에 데이터가 안들어오므로,<BR>
        	 * - String 데이터로 생성한다.<BR>
        	 */
        	if ( inquiry_flag.equals("EXTRACT") ) {
        		event.setInvoiceCreationData(makeInvoiceCreationInData(event.getExtWorkOrderNo(), event.getExtServiceOrderNo(), event.getExtEquipmentNo()));
        	}

        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsI02EventResponse();
        	
        	//Basic Command 생성
        	InvoiceCreationDetailBC command = new InvoiceCreationDetailBCImpl();
        	
        	//Invoice Creation 가능 여부 체크
        	if ( !checkInputValidation(event) ) {
        		throw new EventException("input validation error!");
        	}

            eventResponse = new SppTrsI02EventResponse(command.searchInvoiceCreationDetailList(event));
            
            commit();
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * checkInputValidation<BR>
     * 
     * @param event Event
     * @return bResult boolean
     * @throws EventException
     */
    private boolean checkInputValidation(SppTrsI02Event event) throws EventException {
    	boolean bResult = false;
    	log.debug("[debug]=== InvoiceCreationDetailRSC checkInputValidation START!");

    	//Parent Vendor가 로그인한 경우만 Invoice 처리 가능 (신규 신청 및 수정, 취소)
//    	if ( !event.getVendorCode().equalsIgnoreCase(event.getParentVendorCode()) ) {
//    		throw new EventException("you are not authorised to process invoice!");
//    	}
    	
    	InvoiceCreationInquiry[] invoiceCreationData = event.getInvoiceCreationData();
    	
    	String sTempOfficeCode = "";
    	String sVendorCode = "";
    	if ( invoiceCreationData.length > 0 ) {
    		sTempOfficeCode = invoiceCreationData[0].getOfficeCode();
			sVendorCode = invoiceCreationData[0].getVendorCode();
    	}

    	//동일 Office여부 및 동일 Vendor Code 여부 체크 (Invoice 신청시는 동일한 조건만 가능)
    	for ( int i=0; i< invoiceCreationData.length; i++ ) {
    		log.debug("[debug]=== InvoiceCreationDetailRSC checkInputValidation IDX =" + i 
    				+ " getOfficeCode=" + invoiceCreationData[i].getOfficeCode() 
    				+ " getVendorCode=" + invoiceCreationData[i].getVendorCode() );
    		if ( !invoiceCreationData[i].getOfficeCode().equalsIgnoreCase(sTempOfficeCode) ) {
    			throw new EventException("Office Code is not same! Equipment No = " + invoiceCreationData[i].getEquipmentNo());
    		}
    		if ( !invoiceCreationData[i].getVendorCode().equalsIgnoreCase(sVendorCode) ) {
    			throw new EventException("Vendor Code is not same! Equipment No = " + invoiceCreationData[i].getEquipmentNo());
    		}
    	}
    	bResult = true;
    	log.debug("[debug]=== InvoiceCreationDetailRSC checkInputValidation END!" + bResult);
    	return bResult;
    }
    
    /**
     * makeInvoiceCreationInData<BR>
     * - Invoice Creation Detail 조회시 Input 데이터는 InvoiceCreationInquiry[] 인데,<BR>
     * - Excel, Print 출력시는 Input 데이터가 String으로 넘어오므로,<BR>
     * - String 데이터를 InvoiceCreationInquiry[] 로 데이터를 임의 변환<BR>
     * 
     * @param extWorkOrderNo
     * @param extServiceOrderNo
     * @param extEquipmentNo
     * @return invoiceCreationData InvoiceCreationInquiry[]
     * @throws EventException
     */
    private InvoiceCreationInquiry[] makeInvoiceCreationInData(String extWorkOrderNo, String extServiceOrderNo, String extEquipmentNo) throws EventException {
    	
    	InvoiceCreationInquiry[] invoiceCreationData = null;
    	
    	String[] workOrderNo = extWorkOrderNo.replaceAll(" ", "").split(",");	//Work Order
    	String[] serviceOrderNo = extServiceOrderNo.replaceAll(" ", "").split(",");	//Service Order
    	String[] equipmentNo = extEquipmentNo.replaceAll(" ", "").split(",");	//Equipment
    	
    	//extWorkOrderNo
    	if ( workOrderNo.length == 0 ) {
    		throw new EventException("System error : invalid extend workorder number!");
    	}
    	//extServiceOrderNo
    	if ( serviceOrderNo.length == 0 ) {
    		throw new EventException("System error : invalid extend serviceorder number!");
    	}
    	//extEquipmentNo
    	if ( equipmentNo.length == 0 ) {
    		throw new EventException("System error : invalid extend qeuipment number!");
    	}
    	//입력된 extWorkOrderNo, extServiceOrderNo, extEquipmentNo의 값은 페어가 되어야한다.
    	if ( (workOrderNo.length != serviceOrderNo.length) || (workOrderNo.length != equipmentNo.length) ) {
    		throw new EventException("System error : input data size is not equals");
    	}

    	ArrayList inquiryArray = new ArrayList();
        for ( int i = 0; i < workOrderNo.length; i++ ) {
        	InvoiceCreationInquiry invoiceCreationInquiry = new InvoiceCreationInquiry();
        	
        	invoiceCreationInquiry.setSeq(i+1);
        	invoiceCreationInquiry.setWorkOrderNo(workOrderNo[i]);
        	invoiceCreationInquiry.setEquipmentNo(equipmentNo[i]);
        	invoiceCreationInquiry.setServiceOrderNo(serviceOrderNo[i]);
        	
        	inquiryArray.add(invoiceCreationInquiry);
        }
    	invoiceCreationData = (InvoiceCreationInquiry[])inquiryArray.toArray(new InvoiceCreationInquiry[0]);
    	return invoiceCreationData;
    }
    
}
