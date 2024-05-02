/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0122HTMLAction.java
*@FileTitle : Marking "Reverse Charge" by I/F No 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.10 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0122HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0122HTMLAction 객체를 생성
	 */
	public FNS_INV_0122HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0122Event event = new FnsInv0122Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMarkingReverseChargeVOs((MarkingReverseChargeVO[])getVOs(request, MarkingReverseChargeVO .class,"sheet1_"));	
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setBlSrcNo(request.getParameter("bl_src_no").trim());
			event.setArOfcCd(request.getParameter("ofc_cd").trim());
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