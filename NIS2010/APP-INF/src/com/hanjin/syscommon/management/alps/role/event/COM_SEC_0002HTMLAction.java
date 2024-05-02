/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_SEC_0002HTMLAction.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.syscommon.management.alps.userroleapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserRoleApprovalSC로 실행요청<br>
 * - UserRoleApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see UserRoleApprovalEvent 참조
 * @since J2EE 1.6
 */

public class COM_SEC_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * COM_SEC_0002HTMLAction 객체를 생성
	 */
	public COM_SEC_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserRoleApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		ComSec0002Event event = new ComSec0002Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMenuListVO((MenuListVO)getVO(request, MenuListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSubSysCd(JSPUtil.getParameter(request, "sub_sys_cd", ""));
			//event.setComUsrRoleConditionVO((ComUsrRoleConditionVO)getVO(request, ComUsrRoleConditionVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSubSysCd(JSPUtil.getParameter(request, "sub_sys_cd", ""));
			event.setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		}else 	if(command.isCommand(FormCommand.MULTI)) {
			event.setUserRoleAuthAproVOs((UserRoleAuthAproVO[])getVOs(request, UserRoleAuthAproVO.class, ""));
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