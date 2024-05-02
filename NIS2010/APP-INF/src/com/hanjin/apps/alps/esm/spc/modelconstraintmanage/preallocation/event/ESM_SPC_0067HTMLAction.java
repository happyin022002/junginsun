/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0067HTMLAction.java
*@FileTitle : Pre-Allocation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqPreAlocVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.modelconstraintmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ModelConstraintManageSC로 실행요청<br>
 * - ModelConstraintManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ju Sun Young
 * @see ModelConstraintManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0067HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0067HTMLAction 객체를 생성
	 */
	public ESM_SPC_0067HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ModelConstraintManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command          = FormCommand.fromRequest(request);
		EsmSpc0067Event event        = new EsmSpc0067Event();
		
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSaqPreAlocVOS((SaqPreAlocVO[])getVOs(request, SaqPreAlocVO.class,""));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO.class));
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