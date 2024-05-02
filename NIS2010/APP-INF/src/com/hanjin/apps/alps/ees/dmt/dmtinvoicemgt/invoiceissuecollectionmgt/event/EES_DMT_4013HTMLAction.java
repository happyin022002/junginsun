/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4013HTMLAction.java
*@FileTitle : Invoice Creation - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceMgtSC로 실행요청<br>
 * - InvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Tae Kyun
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_4013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_4013HTMLAction 객체를 생성
	 */
	public EES_DMT_4013HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt4013Event event = new EesDmt4013Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSheetOptionVO((SheetOptionVO)getVO(request, SheetOptionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setIssuedInvoiceParamVO((IssuedInvoiceParamVO)getVO(request, IssuedInvoiceParamVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			//InvoiceGroupParamVO
			event.setInvoiceGroupParamVO((InvoiceGroupParamVO)getVO(request, InvoiceGroupParamVO.class));
			
			//ConfirmChargeListVO[]
			ConfirmChargeListVO confirmChargeListVO = new ConfirmChargeListVO();
			event.setConfirmChargeListVOs(confirmChargeListVO.fromRequestGrid(request));
		} 
		else if(command.isCommand(FormCommand.COMMAND02)) {	//BackEndJob
			event.setInvoiceGroupParamVO((InvoiceGroupParamVO)getVO(request, InvoiceGroupParamVO.class));
			ConfirmChargeListVO confirmChargeListVO = new ConfirmChargeListVO();
			event.setConfirmChargeListVOs(confirmChargeListVO.fromRequestGrid(request, "grid"));
		} 
		else if(command.isCommand(FormCommand.COMMAND03)) {	//BackEndJob
			event.setInvoiceGroupParamVO((InvoiceGroupParamVO)getVO(request, InvoiceGroupParamVO.class));
		}		
		else if(command.isCommand(FormCommand.COMMAND01)) {	//A/R-I/F
			//InvoiceGroupParamVO
			event.setInvoiceGroupParamVO((InvoiceGroupParamVO)getVO(request, InvoiceGroupParamVO.class));
			//ConfirmChargeListVO[]
			ConfirmChargeListVO confirmChargeListVO = new ConfirmChargeListVO();
			event.setConfirmChargeListVOs(confirmChargeListVO.fromRequestGrid(request, "grid"));
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