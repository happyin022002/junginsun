/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0121HTMLAction.java
*@FileTitle : MNR PFMC by Estimation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.08 민정호
* 1.0 Creation
* =======================================================
* 2013.05.30 조경완 [CHM-201324809-01] [MNR-자체개선] M&R > Guideline & PFMC > General Performance > PFMC by Estimate 수행시 ALPS OLTP Rule에 따라 Timeout SQL 발생 방지를 위한 BackEndJob 으로의 기능 전환
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.reportmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ReportManageSC로 실행요청<br>
 * - ReportManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Ho Min
 * @see ReportManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0121HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0121HTMLAction 객체를 생성
	 */
	public EES_MNR_0121HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ReportManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0121Event event = new EesMnr0121Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRepairPFMCByESTINVO((RepairPFMCByESTINVO)getVO(request, RepairPFMCByESTINVO .class));
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setRepairPFMCByESTINVO((RepairPFMCByESTINVO)getVO(request, RepairPFMCByESTINVO .class));
		}else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setRepairPFMCByESTINVO((RepairPFMCByESTINVO)getVO(request, RepairPFMCByESTINVO .class));
		}else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setRepairPFMCByESTINVO((RepairPFMCByESTINVO)getVO(request, RepairPFMCByESTINVO .class));
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