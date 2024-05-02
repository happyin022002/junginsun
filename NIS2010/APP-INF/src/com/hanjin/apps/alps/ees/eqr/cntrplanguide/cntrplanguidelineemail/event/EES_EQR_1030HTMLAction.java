/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1030HTMLAction.java
*@FileTitle : Guideline Email
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * @author YONGCHAN SHIN
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1030HTMLAction 객체를 생성 
	 */
	public EES_EQR_1030HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1030Event event = new EesEqr1030Event();		
		
		EesEqr1030ConditionVO eesEqr1030ConditionVO = new EesEqr1030ConditionVO(); 		
		eesEqr1030ConditionVO = (EesEqr1030ConditionVO)getVO(request, EesEqr1030ConditionVO .class);
		
		EesEqr1030MultiVO eesEqr1030MultiVO = new EesEqr1030MultiVO();		

		event.setEesEqr1030ConditionVO(eesEqr1030ConditionVO);
		
		if(command.isCommand(FormCommand.SEARCH01)) { // USER ID 입력값 검증 및 정보 조회
			String usr_id  = request.getParameter("usr_id");		
			event.setAttribute("usr_id", usr_id);
			
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr1030MultiVOs((EesEqr1030MultiVO[])eesEqr1030MultiVO.fromRequestGrid(request, ""));
			
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