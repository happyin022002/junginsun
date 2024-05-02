/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4004HTMLAction.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.30 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceMgtSC로 실행요청<br>
 * - InvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Sung Hoon
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_4004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_4004HTMLAction 객체를 생성
	 */
	public EES_DMT_4004HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt4004Event event = new EesDmt4004Event();

        //1.Retrieve 시 수행하는 Action.
        if (command.isCommand(FormCommand.SEARCH)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }
        //2.Data Display 버튼 클릭시 Booking 정보와 Charge 정보를 조회하기 위한 Action.
        else if (command.isCommand(FormCommand.SEARCH01)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }
        //3.Charge Grid 에서 Charge No. 입력시 정확한 Charge No. 인지를 체크하기 위한 Action.(조회결과 CNTR Type/Size 정보 반환)
        else if (command.isCommand(FormCommand.SEARCH02)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }
        //4.VVD CD와 Calling Port 체크 Action
        else if (command.isCommand(FormCommand.SEARCH03)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }
        //5.Ex. Rate 조회
        else if (command.isCommand(FormCommand.SEARCH04)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }  
        //6.VVD CD 유효성 체크
        else if (command.isCommand(FormCommand.SEARCH05)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }     
        //7.Local Currency + Rate Currency 를 조회
        else if (command.isCommand(FormCommand.SEARCH07)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
        }          
        //8.Save 버튼 클릭시 [Invoice Issue 전]
        else if (command.isCommand(FormCommand.MULTI)) {

        	//Booking 정보
			event.setDmtInvMnVO((DmtInvMnVO)getVO(request, DmtInvMnVO .class));
			
			//Charge 정보
			DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
			event.setDmtInvDtlVOS(dmtInvDtlVO.fromRequestGrid(request, "subCharge"));

			//Rate Detail 정보
			DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
			event.setDmtInvRtVOS(dmtInvRtVO.fromRequestGrid(request, "subRate"));			
        } 
        //9.Save 버튼 클릭시 [Invoice Issue 후]
        else if (command.isCommand(FormCommand.MULTI01)) {
        	
        	//Booking 정보
			event.setDmtInvMnVO((DmtInvMnVO)getVO(request, DmtInvMnVO .class));

			//Charge 정보
			DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
			event.setDmtInvDtlVOS(dmtInvDtlVO.fromRequestGrid(request, "subCharge"));

			//Rate Detail 정보
			DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
			event.setDmtInvRtVOS(dmtInvRtVO.fromRequestGrid(request, "subRate"));		       	
        }         
        //10.AR/IF 버튼 클릭시
        else if (command.isCommand(FormCommand.COMMAND01)) {
        	//Booking 정보
			event.setDmtInvMnVO((DmtInvMnVO)getVO(request, DmtInvMnVO .class));
        }
        //11.페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
        else if (command.isCommand(FormCommand.COMMAND02)) {
        	event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
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
