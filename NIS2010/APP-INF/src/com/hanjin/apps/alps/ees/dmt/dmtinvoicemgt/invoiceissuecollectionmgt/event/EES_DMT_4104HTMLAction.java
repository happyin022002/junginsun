/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4104HTMLAction.java
*@FileTitle : DEM/DET Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.16 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceMgtSC로 실행요청<br>
 * - InvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Tae Kyun
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_4104HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_4104HTMLAction 객체를 생성
	 */
	public EES_DMT_4104HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt4104Event event = new EesDmt4104Event();
        log.debug("\n ::CALL::> EES_DMT_4104HTMLAction - " + command.getCommand());
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST01) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST02) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST03) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST04) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST05) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.SEARCHLIST06) ) {
			event.setPayerInfoParamVO((PayerInfoParamVO)getVO(request, PayerInfoParamVO.class));
    	}else if (command.isCommand(FormCommand.MULTI) ) {
    		//DmtPayrInfoVO
    		event.setDmtPayrInfoVO((DmtPayrInfoVO)getVO(request, DmtPayrInfoVO.class));
    		//DmtPayrCntcPntVOs
    		DmtPayrCntcPntVO dmtPayrCntcPntVO = new DmtPayrCntcPntVO();
    		event.setDmtPayrCntcPntVOs(dmtPayrCntcPntVO.fromRequestGrid(request));
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