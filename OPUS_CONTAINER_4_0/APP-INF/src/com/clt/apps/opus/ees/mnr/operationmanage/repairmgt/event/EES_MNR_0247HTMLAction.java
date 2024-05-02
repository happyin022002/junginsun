/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0247HTMLAction.java
*@FileTitle : EDI Invoice Parking Lot
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2014.12.24 Jun Kato
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotDTLDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotHDRDataVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.management.opus.user.event.UserManagementEvent;

/**
 * HTTP Parser<br>
 * - NIS2010.APP-INF.src.com.clt.syscommon.nis2010.management.usermanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagementSC로 실행요청<br>
 * - UserManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KyungBum Kim
 * @see UserManagementEvent 참조
 * @since J2EE 1.4
 */

public class EES_MNR_0247HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UserHTMLAction 객체를 생성
	 */
	public EES_MNR_0247HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */ 
    	FormCommand command = FormCommand.fromRequest(request);

    	EesMnr0247Event event = new EesMnr0247Event();
				
    	if(command.isCommand(FormCommand.SEARCH)) {
        	event.setEDIInvoiceParkingLotHDRDataVO((EDIInvoiceParkingLotHDRDataVO)getVO(request,EDIInvoiceParkingLotHDRDataVO.class));
    	}else if(command.isCommand(FormCommand.SEARCH01)){
			event.setEDIInvoiceParkingLotDTLDataVO((EDIInvoiceParkingLotDTLDataVO)getVO(request,EDIInvoiceParkingLotDTLDataVO.class));
    	}else if(command.isCommand(FormCommand.MULTI)){
//			event.setCustomMnrOrdTmpHdrVOS((CustomMnrOrdTmpHdrVO[])getVOs(request,CustomMnrOrdTmpHdrVO.class));
			event.setCustomMnrOrdTmpHdrVOS((CustomMnrOrdTmpHdrVO[])getVOs(request, CustomMnrOrdTmpHdrVO.class,"HDR_"));
			event.setCustomMnrOrdTmpDtlVOS((CustomMnrOrdTmpDtlVO[])getVOs(request, CustomMnrOrdTmpDtlVO.class,"DTL_"));
    	}else if(command.isCommand(FormCommand.MULTI01)){
    		event.setCustomMnrOrdTmpHdrVOS((CustomMnrOrdTmpHdrVO[])getVOs(request, CustomMnrOrdTmpHdrVO.class,"HDR_"));
			event.setCustomMnrOrdTmpDtlVOS((CustomMnrOrdTmpDtlVO[])getVOs(request, CustomMnrOrdTmpDtlVO.class,"DTL_"));
			event.setEDIInvoiceParkingLotHDRDataVO((EDIInvoiceParkingLotHDRDataVO)getVO(request,EDIInvoiceParkingLotHDRDataVO.class, "HDR_"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setEDIInvoiceParkingLotHDRDataVO((EDIInvoiceParkingLotHDRDataVO)getVO(request,EDIInvoiceParkingLotHDRDataVO.class, "HDR_"));
    	}
    	
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}