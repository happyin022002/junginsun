/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ACCESSHISTORYHTMLAction.java
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.superuser.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.superuser.vo.SuperUserVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.syscommon.management.accesshistory.accesshistory 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccessHistorySC로 실행요청<br>
 * - AccessHistorySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kyungbum kim
 * @see AccessHistoryEvent 참조
 * @since J2EE 1.6
 */

public class SuperUserHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ACCESSHISTORYHTMLAction 객체를 생성
	 */
	public SuperUserHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccessHistoryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);

		SuperUserEvent event = new SuperUserEvent();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setVos((SuperUserVO[])getVOs(request, SuperUserVO.class,""));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setParam("opt", request.getParameter("opt"));
			event.setParam("usr_id", request.getParameter("usrId"));
			event.setParam("usr_nm", request.getParameter("usrNm"));
			event.setParam("module", request.getParameter("subSys").replaceAll(",", "','"));
			event.setParam("admin", request.getParameter("admin"));
			event.setParam("rhq", request.getParameter("rhq"));
			event.setParam("ofc_cd", request.getParameter("ofcCd"));
			event.setParam("pgm_no", request.getParameter("pgmNo"));
			event.setParam("pgm_nm", request.getParameter("pgmNm"));
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