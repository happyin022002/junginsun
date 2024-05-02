/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_034HTMLAction.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.01 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @param <eqrAutoRunFcastParaVO>
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0034HTMLAction<eqrAutoRunFcastParaVO> extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_034HTMLAction 객체를 생성
	 */
	public EES_EQR_0034HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0034Event event = new EesEqr0034Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setsearchAutoRunParameter((SearchAutoRunParameterVO)getVO(request, SearchAutoRunParameterVO .class));
		}else if (command.isCommand(FormCommand.MULTI)){
			event.setEqrAutoRunFcastParaVO(new EqrAutoRunFcastParaVO().fromRequestGrid(request,""));
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
