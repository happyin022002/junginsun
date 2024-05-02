/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0106HTMLAction.java
*@FileTitle : TPBHandling
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.08.18 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.tpb.InvoiceManagemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageManageSC로 실행요청<br>
 * - InvoiceManageManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see InvoiceManageManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0106HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0106HTMLAction 객체를 생성
	 */
	public ESD_TPB_0106HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceManageManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0106Event event = new EsdTpb0106Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchTPBHandlingVOS((SearchTPBHandlingVO[])getVOs(request, SearchTPBHandlingVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchTPBHandlingVO((SearchTPBHandlingVO)getVO(request, SearchTPBHandlingVO .class));
		}
		else if(command.isCommand(FormCommand.ADD)) {
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			String  ofc_cd = request.getParameter("ofc_cd");			
			event.setAttribute("ofcCd",	 ofc_cd);
			String  user_id = request.getParameter("user_id");			
			event.setAttribute("userId", user_id);
			String n3pty_no = request.getParameter("n3pty_no");
			event.setAttribute("n3ptyNo", n3pty_no);			
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