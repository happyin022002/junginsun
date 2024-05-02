/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationIWSProxy.java
*@FileTitle : TRS Invoice 웹서비스
*Open Issues :
*Change history :
* 2006-12-02 sunghwan cho : 신규 작성
* 2007-02-07 sunghwan cho : SppTrsI02Event 생성자에 serviceOrderNo 추가
* 2007-02-22 sunghwan cho : Invoice Cancel을 PI제공 모듈로 변경
* 2007-03-28 sunghwan cho : Invoice Creation을 PI제공 모듈로 변경
* 2007-04-03 sunghwan cho : Deploy 수행여부를 확인하기 위한 체크로직 추가
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-10 sunghwan cho : 모든 스키마에 parentVendorCode 추가로 인한 Event 생성자 변경
* 2007-05-15 sunghwan cho : extInvoiceNo 추가 (Excel 추출을 위해 별도 Parameter로 추가) 
*@LastModifyDate : 2007-05-15
*@LastModifier : sunghwan cho
*@LastVersion : 1.7
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;
import org.apache.log4j.Logger;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

//Invoice Creation
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.InvoiceCreationRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiryRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiryResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01EventResponse;
//Invoice Save Equipment List
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.InvoiceSaveEquipmentRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.InvoiceSaveEquipmentRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.InvoiceSaveEquipmentResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03EventResponse;
//Invoice Creation Detail
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.InvoiceCreationDetailRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.InvoiceCreationDetailInquiryRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.InvoiceCreationDetailInquiryResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02EventResponse;
//Invoice Creation Detail Submit (Invoice & Surcharge)
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.InvoiceCreationDetailSubmitRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.InvoiceCreationDetailSubmitResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailSubmitRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailSubmitResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02EventResponse;
//Surcharge Inquiry (Inquiry Only)
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.InvoiceSurchargeRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiryRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiryResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04EventResponse;
//Inquiry
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.InvoiceInquiryRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiryRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiryResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05EventResponse;
//Inquiry Cancel Submit
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquirySubmitRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquirySubmitResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.SPPComplementSC;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event.InvoiceCancelEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;
//Invoice Creation Submit (2007-03-28)
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.InvoiceCreationSubmitToHanjinRSC;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * WebService Proxy<br>
 * - TRS Invoice 웹서비스<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.6
 */
@WebService(name="InvoiceCreationIWSProxyPortType", serviceName="InvoiceCreationIWSProxy",
        targetNamespace="http://www.smlines.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/InvoiceCreationIWSProxy",
             portName="InvoiceCreationIWSProxyPort")

public class InvoiceCreationIWSProxy {

    protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
    /**
     * 
     * @param userID
     * @return
     */
    @WebMethod()
    public String getServiceName(String userID) {
    	String svcName = "InvoiceCreationIWSProxy Web-Service:[2007-08-17 17:30]-" + userID;
    	return svcName;
    }
	/**
	 * getInvoiceCreationInquiry<BR>
     * - 다양한 조건으로 Invoice 미발행된 S/O의 Equipment List를 조회<BR>
     * 
     * @param request InvoiceCreationInquiryRequest
     * @return response InvoiceCreationInquiryResponse
     */
    @WebMethod()
	public InvoiceCreationInquiryResponse getInvoiceCreationInquiry(InvoiceCreationInquiryRequest request)
	{
		Event event = null;
		InvoiceCreationRSC rsc = new InvoiceCreationRSC();
		InvoiceCreationInquiryResponse response = new InvoiceCreationInquiryResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationIWSProxy getInvoiceCreationInquiry Start!");

			/**
			 * EVENT 생성
			 */
			event = new SppTrsI01Event(request.getUserID().trim(),
										 request.getVendorCode().trim(),
										 request.getWorkOrderNo().trim(), 
										 request.getEquipmentNoType().trim(), 
										 request.getEquipmentNo().trim(), 
										 request.getBookingNo().trim(), 
										 request.getBillOfLadingNo().trim(),
										 request.getServiceOrderNo().trim(),
										 request.getParentVendorCode().trim() );
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI01EventResponse eventResponse = (SppTrsI01EventResponse)rsc.perform(event);

			/**
			 * 전송 데이터 생성
			 */
			response.setInvoiceData(eventResponse.getInvoiceData());
			response.setCount(eventResponse.getInvoiceData().length);
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== vendorCode >> "+request.getVendorCode().trim());
			log.debug("[debug]=== InvoiceCreationIWSProxy getInvoiceCreationInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
    /**
     * saveInvoiceEquipment<BR>
     * - Vendor가 발행한 Invoice번호의 중복여부 체크<BR>
     * 
     * @param request InvoiceSaveEquipmentRequest
     * @return response InvoiceSaveEquipmentResponse
     */
    @WebMethod()
	public InvoiceSaveEquipmentResponse saveInvoiceEquipment(InvoiceSaveEquipmentRequest request)
	{
		Event event = null;
		InvoiceSaveEquipmentRSC rsc = new InvoiceSaveEquipmentRSC();
		InvoiceSaveEquipmentResponse response = new InvoiceSaveEquipmentResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationIWSProxy saveInvoiceEquipment Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsI03Event(request.getUserID(),
										 request.getVendorCode(),
										 request.getInvoiceNo(), 
										 request.getIssueDate(),
										 request.getInvoiceCurrency(),
										 request.getParentVendorCode() );
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI03EventResponse eventResponse = (SppTrsI03EventResponse)rsc.perform(event);

			/**
			 * 전송 데이터 생성
			 */
			response.setCount(eventResponse.getCount());
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationIWSProxy saveInvoiceEquipment End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * getInvoiceCreationDetailInquiry<BR>
	 * - Invoice Creation을 위한 상세정보<BR>
	 * 
	 * @param request InvoiceCreationDetailInquiryRequest
	 * @return response InvoiceCreationDetailInquiryResponse
	 */
    @WebMethod()
	public InvoiceCreationDetailInquiryResponse getInvoiceCreationDetailInquiry(InvoiceCreationDetailInquiryRequest request)
	{
		Event event = null;
		InvoiceCreationDetailRSC rsc = new InvoiceCreationDetailRSC();
		InvoiceCreationDetailInquiryResponse response = new InvoiceCreationDetailInquiryResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getInvoiceCreationDetailInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsI02Event(request.getUserID(),
										 request.getVendorCode(), 
										 request.getInvoiceNo(), 
										 request.getIssueDate(),
										 request.getInvoiceCurrency(),
										 request.getExtWorkOrderNo(),
										 request.getExtServiceOrderNo(),
										 request.getExtEquipmentNo(),
										 request.getInvoiceCreationData(),
										 request.getParentVendorCode() ); 
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			log.debug("[debug]getUserID >> "+request.getUserID());
			log.debug("[debug]getVendorCode >> "+request.getVendorCode());
			log.debug("[debug]getInvoiceNo >> "+request.getInvoiceNo());
			log.debug("[debug]getIssueDate >> "+request.getIssueDate());
			log.debug("[debug]getInvoiceCurrency >> "+request.getInvoiceCurrency());
			log.debug("[debug]getExtWorkOrderNo >> "+request.getExtWorkOrderNo());
			log.debug("[debug]getExtServiceOrderNo >> "+request.getExtServiceOrderNo());
			log.debug("[debug]getExtEquipmentNo >> "+request.getExtEquipmentNo());
			log.debug("[debug]getInvoiceCreationData >> "+request.getInvoiceCreationData());
			log.debug("[debug]getParentVendorCode >> "+request.getParentVendorCode());
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI02EventResponse eventResponse = (SppTrsI02EventResponse)rsc.perform(event);

			/**
			 * 전송 데이터 생성
			 */
			response.setInvoiceCreationData(eventResponse.getInvoiceCreationData());
			response.setCount(eventResponse.getInvoiceCreationData().length);
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getInvoiceCreationDetailInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}

	/**
	 * saveInvoiceCreationDetailInquiry<BR>
	 * - Invoice 신청 및 Surcharge 등록<BR>
	 * 
	 * @param request InvoiceCreationDetailSubmitRequest
	 * @return response InvoiceCreationDetailSubmitResponse
	 */
    @WebMethod()
	public InvoiceCreationDetailSubmitResponse saveInvoiceCreationDetailInquiry(InvoiceCreationDetailSubmitRequest request)
	{
		Event event = null;
		InvoiceCreationSubmitToHanjinRSC rsc = new InvoiceCreationSubmitToHanjinRSC();
		InvoiceCreationDetailSubmitResponse response = new InvoiceCreationDetailSubmitResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsU02Event(request.getUserID(), 
										 request.getVendorCode(),
										 request.getVendorPhoneNo(),
										 request.getInvoiceNo(), 
										 request.getIssueDate(),
										 request.getInvoiceCurrency(),
										 request.getInvoiceCreationData(),
										 request.getInvoiceSurchargeData(),
										 request.getTotalWorkOrder(),
										 request.getTotalEquipment(),
										 request.getInvoiceBasicAmountTotal(),
										 request.getSurchargeTotal(),
										 request.getGrandTotal(),
										 request.getParentVendorCode(),
										 request.getVatAmt());
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 * Invoice Creation Submit
			 */
			SppTrsU02EventResponse eventResponse = (SppTrsU02EventResponse)rsc.perform(event);
			
			/**
			 * 전송 데이터 생성
			 */
			response.setCount(eventResponse.getCount());
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	/**
	 * saveInvoiceCreationDetailInquiry<BR>
	 * - Invoice 신청 및 Surcharge 등록<BR>
	 * 
	 * @param request InvoiceCreationDetailSubmitRequest[]
	 * @return response InvoiceCreationDetailSubmitResponse[]
	 */
    @WebMethod()
	public MultiInvoiceCreationDetailSubmitResponse checkMultiInvoiceCreation(MultiInvoiceCreationDetailSubmitRequest request)
	{
		Event event = null;
		InvoiceCreationSubmitToHanjinRSC rsc = new InvoiceCreationSubmitToHanjinRSC();
		MultiInvoiceCreationDetailSubmitResponse response = new MultiInvoiceCreationDetailSubmitResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsU02Event(request.getUserID(), 
										 request.getVendorCode(),
										 request.getVendorPhoneNo(),
										 request.getParentVendorCode(),
										 request.getMultiInvoiceCreationDetailList(),
										 request.getInvCode());
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 * Invoice Creation Submit
			 */
			SppTrsU02EventResponse eventResponse = (SppTrsU02EventResponse)rsc.perform(event);
			
			/**
			 * 전송 데이터 생성
			 */
			response.setCount(eventResponse.getCount());
			response.setErrInvNo(eventResponse.getErrInvoiceNo());
			response.setErrWoNo(eventResponse.getErrWorkOrderNo());
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * saveInvoiceCreationDetailInquiry<BR>
	 * - Invoice 신청 및 Surcharge 등록<BR>
	 * 
	 * @param request InvoiceCreationDetailSubmitRequest[]
	 * @return response InvoiceCreationDetailSubmitResponse[]
	 */
    @WebMethod()
	public MultiInvoiceCreationDetailSubmitResponse saveMultiInvoiceCreation(MultiInvoiceCreationDetailSubmitRequest request)
	{
		Event event = null;
		InvoiceCreationSubmitToHanjinRSC rsc = new InvoiceCreationSubmitToHanjinRSC();
		MultiInvoiceCreationDetailSubmitResponse response = new MultiInvoiceCreationDetailSubmitResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsU02Event(request.getUserID(), 
										 request.getVendorCode(),
										 request.getVendorPhoneNo(),
										 request.getParentVendorCode(),
										 request.getMultiInvoiceCreationDetailList(),
										 request.getInvCode());
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 * Invoice Creation Submit
			 */
			SppTrsU02EventResponse eventResponse = (SppTrsU02EventResponse)rsc.perform(event);
			
			/**
			 * 전송 데이터 생성
			 */
			response.setCount(eventResponse.getCount());
			response.setErrInvNo(eventResponse.getErrInvoiceNo());
			response.setErrWoNo(eventResponse.getErrWorkOrderNo());
			response.setStatus("SUCCESS");
			response.setDlngDvsn("S");
			
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy saveInvoiceCreationDetailInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * getSurchageInquiry<BR>
	 * - Surchaege 정보 조회<BR>
	 * - Surchaege는 W/O Surchaege는와 Invoice Surchaege가 있으며,<BR>
	 * - W/O Surchaege는 W/O발행시 등록되어 조회만 가능하며,<BR>
	 * - Invoice Surchaege는 Invoice Creation Detail 화면에서 등록/수정/조회 가능하다.<BR>
	 * 
	 * @param request InvoiceSurchargeInquiryRequest
	 * @return response InvoiceSurchargeInquiryResponse
	 */
    @WebMethod()
	public InvoiceSurchargeInquiryResponse getSurchageInquiry(InvoiceSurchargeInquiryRequest request)
	{
		Event event = null;
		InvoiceSurchargeRSC rsc = new InvoiceSurchargeRSC();
		InvoiceSurchargeInquiryResponse response = new InvoiceSurchargeInquiryResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getSurchageInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsI04Event(request.getUserID(), 
										 request.getVendorCode(), 
					 					 request.getServiceNo(), 
										 request.getWorkOrderNo(), 
										 request.getEquipmentNoType(), 
										 request.getEquipmentNo(), 
										 request.getBookingNo(),
										 request.getInvoiceNo(),
										 request.getIssueDate(),
										 request.getStep_cd(),
										 request.getParentVendorCode() );
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI04EventResponse eventResponse = (SppTrsI04EventResponse)rsc.perform(event);

			/**
			 * 전송 데이터 생성
			 */
			response.setInvoiceData(eventResponse.getSurchargeData());
			response.setCount(eventResponse.getSurchargeData().length);
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getSurchageInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * getInquiry<BR>
	 * - Invoice 신청 내역 조회<BR>
	 * 
	 * @param request InvoiceInquiryRequest
	 * @return response InvoiceInquiryResponse
	 */
    @WebMethod()
	public InvoiceInquiryResponse getInquiry(InvoiceInquiryRequest request)
	{
		Event event = null;
		InvoiceInquiryRSC rsc = new InvoiceInquiryRSC();
		InvoiceInquiryResponse response = new InvoiceInquiryResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getInquiry Start!");

			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsI05Event(request.getUserID(),
					 					 request.getVendorCode(),
					 					 request.getPeriodType(), 
										 request.getPeriodStartDate(), 
										 request.getPeriodEndDate(), 
										 request.getStatus(), 
										 request.getInvoiceNo(),
										 request.getWorkOrderNo(),
										 request.getEquipmentNoType(),
										 request.getEquipmentNo(),
										 request.getParentVendorCode(),
										 request.getExtInvoiceNo() );
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			 
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI05EventResponse eventResponse = (SppTrsI05EventResponse)rsc.perform(event);

			/**
			 * 전송 데이터 생성
			 */
			response.setInquiryData(eventResponse.getInvoiceData());
			response.setInvoiceHeaderData(eventResponse.getInvoiceHeaderData());
			response.setCount(eventResponse.getInvoiceData().length);
			if ( ((SppTrsI05Event)event).getUserID().equals("CHECK") ) {
				//Deploy 정상여부를 확인하기 위한 Deplay 요청일자 세팅
				response.setStatus("SUCCESS:2007-06-14 01:33");
			} else {
				response.setStatus("SUCCESS");
			}
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy getInquiry End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * cancelInvoiceCreation
	 * - Invoice Cancel Submit<BR>
	 * 
	 * @param request InvoiceInquirySubmitRequest
	 * @return response InvoiceInquirySubmitResponse
	 */
    @WebMethod()
	public InvoiceInquirySubmitResponse cancelInvoiceCreation(InvoiceInquirySubmitRequest request)
	{
		Event event = null;
		SPPComplementSC sc = new SPPComplementSC();
		InvoiceInquirySubmitResponse response = new InvoiceInquirySubmitResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy cancelInvoiceCreation Start!");
			
			/**
			 * EVENT 생성 시작 
			 */
			event = new InvoiceCancelEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy cancelInvoiceCreation SC EVENT = " + event.getEventName());
			
			/**
			 * Request 에서 전송된 데이터를 InvoiceCancelEvent 에 맞게 변형하여 세트한다.  
			 */
			((InvoiceCancelEvent)event).setUserID(request.getUserID());
			
			InvoiceInquiry[] invoiceData = request.getInvoiceData();
			String[] invoiceNo = new String[invoiceData.length];	//Invoice No
			String[] invoiceVendor = new String[invoiceData.length];	//Invoice Vendor Seq
			for ( int i=0; i< invoiceData.length; i++ ) {
				invoiceNo[i] = invoiceData[i].getInvoiceNo();
				//2007-11-02 by KJJ: wo_vndr_seq --> inv_vndr_seq
				//invoiceVendor[i] = request.getVendorCode();
				invoiceVendor[i] = invoiceData[i].getInvoiceVendorCode().replaceAll("M-","").replaceAll("S-","");
				log.debug("[debug]getVendorCode >> Vendor["+i+"] == "+request.getVendorCode());
				log.debug("[debug]getInvoiceVendorCode >> invoiceVendor["+i+"] == "+invoiceVendor[i]);
			}
			((InvoiceCancelEvent)event).setInv_no(invoiceNo);
			((InvoiceCancelEvent)event).setInv_vndr_seq(invoiceVendor);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			GeneralEventResponse eventResponse = (GeneralEventResponse)sc.perform(event);
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy cancelInvoiceCreation SC RESULT = " + eventResponse.getFlowFlag());

			/**
			 * 전송 데이터 생성
			 */
			if ( eventResponse.getFlowFlag().equals("true") ) {
				response.setCount(1);
				response.setStatus("SUCCESS");
			} else {
				response.setCount(0);
				response.setStatus("SUCCESS");
			}
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy cancelInvoiceCreation End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
	/**
	 * modifyInvoiceCreation<BR>
	 * - Invoice Modify를 위해 Invoice Inquiry Creation을 위한 상세정보<BR>
	 * - Invoice Inquiry에서 Modify버튼 클릭시 Invoice Creation Detail화면으로 이동하는데,<BR>
	 * - Invoice Creation Detail 조회를 위해 Request를 생성한후 호출한다.<BR>
	 *
	 * @param request InvoiceCreationDetailInquiryRequest
	 * @return response InvoiceCreationDetailInquiryResponse
	 */
    @WebMethod()
	public InvoiceCreationDetailInquiryResponse modifyInvoiceCreation(InvoiceSaveEquipmentRequest request)
	{
		Event event = null;
		InvoiceInquiryRSC rscInvoice = new InvoiceInquiryRSC();
		InvoiceCreationDetailRSC rsc = new InvoiceCreationDetailRSC();
		InvoiceCreationDetailInquiryResponse response = new InvoiceCreationDetailInquiryResponse();
		
		//Invoice Creation Detail을 위해 생성하는 InvoiceCreationInquiry VO
		InvoiceCreationInquiry[] invoiceCreationData = null;
		
		try {
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy modifyInvoiceCreation Start!");
			/**
			 * Invoice Modify는 Invoice Creation Detail 화면으로 이동하여 조회하는데, 
			 * Invoice Creation Detail 조회에 필요한 Inquiry Data를 조회하여 호출한다.
			 */
			invoiceCreationData = rscInvoice.searchInvoiceEquipmentList(request.getVendorCode(), request.getInvoiceNo());
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy modifyInvoiceCreation COUNT = " + invoiceCreationData.length);
			if ( invoiceCreationData.length == 0 ) {
				response.setStatus("this invoice can not modify");
				response.setCount(0);
				return null;
			}
			/**
			 * EVENT 생성 시작 
			 */
			event = new SppTrsI02Event(request.getUserID(),
										 request.getVendorCode(), 
										 request.getInvoiceNo(), 
										 request.getIssueDate(),
										 request.getInvoiceCurrency(),
										 "",
										 "",
										 "",
										 invoiceCreationData,
										 request.getParentVendorCode() );
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SppTrsI02EventResponse eventResponse = (SppTrsI02EventResponse)rsc.perform(event);
			
			/**
			 * 전송 데이터 생성
			 */
			response.setInvoiceCreationData(eventResponse.getInvoiceCreationData());
			response.setCount(eventResponse.getInvoiceCreationData().length);
			response.setStatus("SUCCESS");
			
			log.debug("[debug]=== InvoiceCreationDetailIWSProxy modifyInvoiceCreation End!");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(e.getMessage());
			response.setCount(0);
		}
		return response;
	}
	
}
