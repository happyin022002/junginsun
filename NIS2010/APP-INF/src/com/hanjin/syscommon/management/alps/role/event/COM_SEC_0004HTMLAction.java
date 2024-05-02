/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_SEC_0004HTMLAction.java
*@FileTitle : ALPS Role Authority Approval Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 김병국
*@LastVersion : 1.0
* 2015.11.17 김병국
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;


import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;


/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JobCodeManagementSC로 실행요청<br>
 * - JobCodeManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see AdmSys0021Event 참조
 * @since J2EE 1.6
 */
public class COM_SEC_0004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	* ADM_SYS_0021HTMLAction 객체를 생성
	*/
	public COM_SEC_0004HTMLAction() {}

	/**
	* HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	* HttpRequst의 정보를 AdmSys0021Event로 파싱하여 request에 셋팅<br>
	* @param request HttpServletRequest HttpRequest
	* @return Event Event interface를 구현한 객체
	* @exception HTMLActionException
	*/
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		ComSec0004Event event = new ComSec0004Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setAuthorityVO((AuthorityVO)getVO(request, AuthorityVO.class));
			event.setParam("date_fm", request.getParameter("date_fm"));
			event.setParam("date_to", request.getParameter("date_to"));
			event.setParam("rqst_ofc_cd", request.getParameter("rqst_ofc_cd"));
			event.setParam("rqst_usr_id", request.getParameter("rqst_usr_id"));
			event.setParam("usr_role_cd", request.getParameter("usr_role_cd"));
			event.setParam("apsts_cd", request.getParameter("apsts_cd"));
			event.setParam("role_module", request.getParameter("subSys").replaceAll(",", "','"));
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