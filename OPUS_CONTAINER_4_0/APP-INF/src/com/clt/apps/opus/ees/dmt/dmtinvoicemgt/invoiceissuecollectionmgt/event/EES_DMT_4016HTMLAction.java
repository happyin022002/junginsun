/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4016HTMLAction.java
*@FileTitle : Issued Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.22 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.dmt.dmtinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceMgtSC로 실행요청<br>
 * - InvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Tae Kyun
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_4016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_4016HTMLAction 객체를 생성
	 */
	public EES_DMT_4016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt4016Event event = new EesDmt4016Event();

		
		log.debug("Start HTMLAction ..............."+FormCommand.MULTI);
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
			
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
				
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
			
		} else if(command.isCommand(FormCommand.MULTI)) {//저장
			//event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
			//event.setInvoiceIssueVOs((InvoiceIssueVO[])getVOs(request, InvoiceIssueVO.class, ""));
			
			log.debug("Start MULTI HTMLAction ...............");
        	//Booking 정보
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
			
			//Charge 정보
			InvoiceIssueVO invoiceIssueVO = new InvoiceIssueVO();
			event.setInvoiceIssueVOs(invoiceIssueVO.fromRequestGrid(request, "subCharge"));

			//Rate Detail 정보
			ChrgDtlVO chrgDtlVO = new ChrgDtlVO();
			event.setChrgDtlVOs(chrgDtlVO.fromRequestGrid(request, "subRate"));			
			
			
		} else if(command.isCommand(FormCommand.MULTI01)) {//수정
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO.class));
			//event.setInvoiceIssueVOs((InvoiceIssueVO[])getVOs(request, InvoiceIssueVO.class, ""));
			
		} else if(command.isCommand(FormCommand.COMMAND01)) {	//A/R I/F
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