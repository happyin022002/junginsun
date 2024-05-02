/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4002HTMLAction.java
*@FileTitle : Invoice Creation & Issue - Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
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
 * @author Kim Tae Kyun
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_4002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_4002HTMLAction 객체를 생성
	 */
	public EES_DMT_4002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt4002Event event = new EesDmt4002Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
		}
        //===============================================================
    	// 변경일자 : 2017.07.27 
    	// 변경요건 : 인도 TAX 변경에 따른 수정
        // 변경내용 : Invoice Creation & Issue - Booking 초기정보 조회
       //===============================================================  		
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}		
        //===============================================================
    	// 변경일자 : 2017.07.27 
    	// 변경요건 : 인도 TAX 변경에 따른 수정
        // 변경내용 : 인도 TAX Ratio 조회 ( Payer 정보가 필요함 )		
		//===============================================================
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setIdaGstRtoCondVO((IdaGstRtoCondVO)getVO(request, IdaGstRtoCondVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			//ChargeBookingInvoiceVO
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
			
			//InvoiceIssueVO
			InvoiceIssueVO invoiceIssueVO = new InvoiceIssueVO();
			event.setInvoiceIssueVOs(invoiceIssueVO.fromRequestGrid(request));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			//ChargeBookingInvoiceVO
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
			
			//InvoiceIssueVO
			InvoiceIssueVO invoiceIssueVO = new InvoiceIssueVO();
			event.setInvoiceIssueVOs(invoiceIssueVO.fromRequestGrid(request));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setfAXEmailByPayerVO((FAXEmailByPayerVO)getVO(request, FAXEmailByPayerVO.class));
		}
		// Virtual Invoice 의 Cancel
		else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		// BKG No., Tariff Type 에 갖는 Virtual Invoice 존재여부 조회
		else if(command.isCommand(FormCommand.COMMAND04)) {
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
		}		
		
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