/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserHTMLAction.java
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.user.event.UserManagementEvent;


/**
 * HTTP Parser<br>
 * - ALPS.APP-INF.src.com.hanjin.syscommon.alps.management.usermanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagementSC로 실행요청<br>
 * - UserManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KyungBum Kim
 * @see UserManagementEvent 참조
 * @since J2EE 1.6
 */
public class ADM_SYS_0015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UserHTMLAction 객체를 생성
	 */
	public ADM_SYS_0015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */
    	FormCommand command = FormCommand.fromRequest(request);

		AdmSys0015Event event = new AdmSys0015Event();
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAdjustmentVO((AdjustmentVO)getVO(request, AdjustmentVO.class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setAdjustmentVOs((AdjustmentVO[])getVOs(request, AdjustmentVO.class, ""));
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