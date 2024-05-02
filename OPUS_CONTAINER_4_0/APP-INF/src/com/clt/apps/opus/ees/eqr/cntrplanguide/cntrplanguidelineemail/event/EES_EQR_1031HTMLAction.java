/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1031HTMLAction.java
*@FileTitle : Guideline Mailing
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * @author YONGCHAN SHIN
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1031HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1031HTMLAction 객체를 생성 
	 */
	public EES_EQR_1031HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1031Event event = new EesEqr1031Event();		
		
		EesEqr1031ConditionVO eesEqr1031ConditionVO = new EesEqr1031ConditionVO(); 		
		eesEqr1031ConditionVO = (EesEqr1031ConditionVO)getVO(request, EesEqr1031ConditionVO .class);
		
		event.setEesEqr1031ConditionVO(eesEqr1031ConditionVO);
		
		if(command.isCommand(FormCommand.SEARCH01)) { // USER ID 입력값 검증 및 정보 조회
			String usr_id  = request.getParameter("usr_id");		
			event.setAttribute("usr_id", usr_id);
			
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