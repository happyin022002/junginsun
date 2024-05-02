/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0106HTMLAction.java
*@FileTitle : Approval Opinion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.22 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0106] Approval Opinion
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.cps.gem.gemplanningperformance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMPlanningPerformanceSC로 실행요청<br>
 * - GEMPlanningPerformanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Changjune
 * @see CpsGem0106Event 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0106HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0106HTMLAction 객체를 생성
	 */
	public CPS_GEM_0106HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsGem0106Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0106Event event = new CpsGem0106Event();		
		
		//[Retrieve]
		if(command.isCommand(FormCommand.SEARCH)) {	
			
			String gen_expn_rqst_no = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
			String gen_expn_cd = JSPUtil.getParameter(request, "gen_expn_cd" , "");
			String gen_expn_itm_no = JSPUtil.getParameter(request, "gen_expn_itm_no" , "");
			
			event.setGenExpnRqstNo(gen_expn_rqst_no);
			event.setGenExpnCd(gen_expn_cd);
			event.setGenExpnItmNo(gen_expn_itm_no);
			
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