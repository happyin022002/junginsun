/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0019HTMLAction.java
*@FileTitle : Detail_Yearly Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMCommonSC로 실행요청<br>
 * - GEMCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0019HTMLAction 객체를 생성
	 */
	public CPS_GEM_0019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0019Event event = new CpsGem0019Event();
		
		if(command.isCommand(FormCommand.SEARCH)
			|| command.isCommand(FormCommand.SEARCHLIST01)
			|| command.isCommand(FormCommand.SEARCHLIST02)
			|| command.isCommand(FormCommand.SEARCHLIST03)
			|| command.isCommand(FormCommand.SEARCHLIST04)
			|| command.isCommand(FormCommand.SEARCHLIST05)
			|| command.isCommand(FormCommand.SEARCHLIST06)
			|| command.isCommand(FormCommand.SEARCHLIST07)) {
			
			SearchYearlyExpenseVO dto = (SearchYearlyExpenseVO)getVO(request, SearchYearlyExpenseVO .class);
			event.setSearchYearlyExpenseVO(dto);
		} else if(command.isCommand(FormCommand.SEARCHLIST08)) {
			// Office Auth Check
			String strPopup = request.getParameter("popup");
			String strPopYear = request.getParameter("popYear");
			String strPopLang = request.getParameter("popLang");
			String strPopBuCd = request.getParameter("popBuCd");
			String strPopOfcCd = request.getParameter("popOfcCd");
			String strPopExpnCd = request.getParameter("popExpnCd");
			
			event.setPopup(strPopup);
			event.setPopYear(strPopYear);
			event.setPopLang(strPopLang);
			event.setPopBuCd(strPopBuCd);
			event.setPopOfcCd(strPopOfcCd);
			event.setPopExpnCd(strPopExpnCd);
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