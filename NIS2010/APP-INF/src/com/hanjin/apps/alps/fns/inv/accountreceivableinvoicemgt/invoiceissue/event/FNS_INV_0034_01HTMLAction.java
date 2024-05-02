/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0034_01HTMLAction.java
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
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
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0034_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0034_01HTMLAction 객체를 생성
	 */
	public FNS_INV_0034_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv003401Event event = new FnsInv003401Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			//event.setInvArStupOfcVO((InvArStupOfcVO)getVO(request, InvArStupOfcVO .class));
			String pageType = request.getParameter("pagetype");
			String ofcCd = request.getParameter("ar_ofc_cd2");
			event.setPageType(pageType);
			event.setOfcCd(ofcCd);
		} else if(command.isCommand(FormCommand.SEARCH02)) {		
		
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
		
		} else if(command.isCommand(FormCommand.SEARCH03)) {		
			
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
		
		}else if(command.isCommand(FormCommand.MULTI)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		} else if(command.isCommand(FormCommand.MULTI02)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		} else if(command.isCommand(FormCommand.SEARCH04)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		}else if(command.isCommand(FormCommand.SEARCH05)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		}else if(command.isCommand(FormCommand.SEARCH06)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
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