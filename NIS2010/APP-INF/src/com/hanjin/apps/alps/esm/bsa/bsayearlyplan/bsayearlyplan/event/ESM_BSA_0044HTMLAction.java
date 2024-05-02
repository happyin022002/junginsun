/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0044HTMLAction.java
*@FileTitle : ESM_BSA_0044HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.13 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.13 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bsa.bsayearlyplan 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BSAYearlyPlanSC로 실행요청<br>
 * - BSAYearlyPlanSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see BSAYearlyPlanEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BSA_0044HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BSA_0044HTMLAction 객체를 생성
	 */
	public ESM_BSA_0044HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BSAYearlyPlanEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBsa0044Event event = new EsmBsa0044Event();
    	
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setBsaYearlyPlanConditionVO((BsaYearlyPlanConditionVO)getVO(request, BsaYearlyPlanConditionVO.class));
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