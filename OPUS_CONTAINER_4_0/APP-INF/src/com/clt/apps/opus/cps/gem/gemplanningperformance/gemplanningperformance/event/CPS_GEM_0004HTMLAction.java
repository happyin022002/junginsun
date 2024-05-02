/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0004HTMLAction.java
*@FileTitle : Actual Results for Subsidiaries
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.05.26 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0004] Actual Results for Subsidiaries
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.cps.gem.gemplanningperformance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMPlanningPerformanceSC로 실행요청<br>
 * - GEMPlanningPerformanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Changjune
 * @see CpsGem0004Event 참조
 * @since J2EE 1.4
 */
 
public class CPS_GEM_0004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0004HTMLAction 객체를 생성
	 */
	public CPS_GEM_0004HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsGem0004Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0004Event event = new CpsGem0004Event();		
		// 조회년월 

		String pln_yr = JSPUtil.getParameter(request, "pln_yr" , "");
		String pln_mon = JSPUtil.getParameter(request, "pln_mon" , "");
		
		String rsltYrmon = pln_yr+pln_mon;
		
		event.setRsltYrmon(rsltYrmon);
		
		// 조직코드 
		String ofcCd = JSPUtil.getParameter(request, "ofc_lvl3" , "");
		event.setOfcCd(ofcCd);
		// kor,eng 
		String langDiv = JSPUtil.getParameter(request, "lang_div" , "");
		event.setLangDiv(langDiv);
		
		//[Retrieve]
		if(command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCHLIST01)) {	
			
			ActRsltSubsPerfVO dto = (ActRsltSubsPerfVO)getVO(request, ActRsltSubsPerfVO .class);
			event.setActRsltSubsPerfVO(dto);
			
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setSubsPerfVOs((SubsPerfVO[])getVOs(request, SubsPerfVO .class,""));
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