/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSNoticeIWSProxy.java
*@FileTitle : SPP TRS 메인화면 관련 웹서비스
*Open Issues :
*Change history :
* 2006-12-02 sunghwan cho : 신규 작성
* 2007-04-03 sunghwan cho : Deploy 수행여부를 확인하기 위한 체크로직 추가
* 2007-04-10 sunghwan cho : 모든 스키마에 parentVendorCode 추가로 인한 Event 생성자 변경 
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.3
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;
import org.apache.log4j.Logger;
import com.hanjin.apps.alps.esd.trs.servicesio.common.event.TRSNoticeRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.common.event.TRSNoticeResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.InvoiceNoticeRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.RailBillingCommonRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.WorkOrderMainRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0005Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0005EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * WebService<br>
 * - SPP TRS 메인화면 Notice Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.6
 */
@WebService(name="TRSNoticeIWSProxyPortType", serviceName="TRSNoticeIWSProxy",
        targetNamespace="http://www.smlines.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/TRSNoticeIWSProxy",
             portName="TRSNoticeIWSProxyPort")
public class TRSNoticeIWSProxy {
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
    /**
     * 
     * @param request
     * @return
     */
    @WebMethod()
    public TRSNoticeResponse getTRSNoticeInquiry(TRSNoticeRequest request){
		Event event = null;
		WorkOrderMainRSC workOrderRSC = new WorkOrderMainRSC();
		InvoiceNoticeRSC invoiceRSC = new InvoiceNoticeRSC();
		TRSNoticeResponse response = new TRSNoticeResponse();
		
		try {
			log.debug("[debug]=== InvoiceCreationIWSProxy Start! ===");
			
			String mainFlag = request.getMainFlag();
			log.debug("[debug]=== mainFlag ===" + mainFlag);
			
			FormCommand f = new FormCommand();
			
			ExpPap0005EventResponse workOrderResponse = null;
			SppTrsI10EventResponse invoiceResponse = null;
			
			if(mainFlag != null && !"".equals(mainFlag)){
				if("I".equals(mainFlag)){
					//EVENT 생성 시작 (Invoice Event)
					event = new SppTrsI10Event(request.getUserID(), 
												 request.getVendorCode(),
												 request.getParentVendorCode(),
												 request.getMainFlag());
					f.setCommand(FormCommand.SEARCH);
					event.setFormCommand(f);
					invoiceResponse = (SppTrsI10EventResponse)invoiceRSC.perform(event);

					//Invoice Notice List
					response.setNoticeData(invoiceResponse.getInvoiceNoticeData());
					if ( ((SppTrsI10Event)event).getUserID().equals("CHECK") ) {
						//Deploy 정상여부를 확인하기 위한 Deplay 요청일자 세팅
						response.setStatus("SUCCESS:2008-08-05 11:36");
					} else {
						response.setStatus("SUCCESS");
					}
				}else if("W".equals(mainFlag)){
					//EVENT 생성 시작 (Work Order Event)
					event = new ExpPap0005Event(request.getUserID(),
							 					 request.getVendorCode(),
							 					 request.getMainFlag(),
							 					 "",
							 					 "");
					
					f.setCommand(FormCommand.SEARCH);
					event.setFormCommand(f);
					
					// work order list/count 가져오는 메서드
					workOrderResponse = (ExpPap0005EventResponse)workOrderRSC.perform(event);
					
					//WorkOrder Notice List
					response.setWorkOrderData(workOrderResponse.getWorkOrderMainList());
					
					if ( ((ExpPap0005Event)event).getUserID().equals("CHECK") ) {
						response.setStatus("SUCCESS:2008-08-05 11:36"); //Deploy 정상여부를 확인하기 위한 Deplay 요청일자 세팅
					} else {
						response.setStatus("SUCCESS");
					}
				}else if("C".equals(mainFlag)){
					
					event = new ExpPap0005Event(request.getUserID(),
							 					 request.getVendorCode(),
							 					 request.getMainFlag(),
							 					 request.getGroupId(),
							 					 request.getParentVendorCode());
					
					f.setCommand(FormCommand.SEARCH);
					event.setFormCommand(f);
					workOrderResponse = (ExpPap0005EventResponse)workOrderRSC.perform(event);
					
					//Count 데이터 생성
					response.setNewWorkOrderCount(workOrderResponse.getNewWorkOrderCount());	    //New WorkOrder 건수
					response.setPendingInvoiceCount(workOrderResponse.getPendingInvoiceCount());	//Pending Invoice 건수
					response.setRailBilingAckCount(workOrderResponse.getAckCount());				//Rail Biling Ack 건수
					
					log.debug("[debug]=== TRSNoticeIWSProxy workOrderResponse.getNewWorkOrderCount COUNT =" + workOrderResponse.getNewWorkOrderCount() );
					log.debug("[debug]=== TRSNoticeIWSProxy invoiceResponse.getPendingInvoiceCount COUNT =" + workOrderResponse.getPendingInvoiceCount() );
					log.debug("[debug]=== TRSNoticeIWSProxy railBilingResponse.getAckCount COUNT =" + workOrderResponse.getAckCount() );
					
					/**
					 * Common 데이터 생성
					 */
					response.setCount(1);
					if ( ((ExpPap0005Event)event).getUserID().equals("CHECK") ) {
						//Deploy 정상여부를 확인하기 위한 Deplay 요청일자 세팅
						response.setStatus("SUCCESS:2007-04-13 11:36");
					} else {
						response.setStatus("SUCCESS");
					}
				}
			}
			log.debug("[debug]=== TRSNoticeIWSProxy End! ===");
		} catch (EventException e) {
			response.setStatus(e.getMessage());
			response.setCount(0);
			log.error("TRSNoticeIWSProxy EventException : " + e.getMessage(), e);
		} catch (Exception e){
			response.setStatus(e.getMessage());
			response.setCount(0);
			log.error("TRSNoticeIWSProxy Exception : " + e.getMessage(), e);
		}
		return response;
	}
}