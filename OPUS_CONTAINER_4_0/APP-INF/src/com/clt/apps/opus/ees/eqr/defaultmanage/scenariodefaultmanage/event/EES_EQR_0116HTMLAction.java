/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_116HTMLAction.java
*@FileTitle : Link 정보 조회/수정
*Open Issues :
*@LastModifyDate : 2009-07-02
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-02 chung eun ho
* 1.0 최초 생성
*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.EqrEccLnkVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Eun ho Chung
 * @see EesEqr0116Event 참조
 *  @since J2EE 1.6
 */
public class EES_EQR_0116HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_116HTMLAction 객체를 생성
	 */
	public EES_EQR_0116HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesEqr116Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesEqr0116Event event = new EesEqr0116Event();
		
		
		if(command.isCommand(FormCommand.MODIFY)) {
			event.setEqrEccLnkVOS((EqrEccLnkVO[])getVOs(request, EqrEccLnkVO .class,"")); // 변경 될 DTD setting
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setEqrEccLnkVO((EqrEccLnkVO)getVO(request, EqrEccLnkVO .class));
			event.setConditionVO((EesEqr0116ConditionVO)getVO(request, EesEqr0116ConditionVO.class)); // 조건 DTD setting
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