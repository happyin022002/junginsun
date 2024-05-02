/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BSA_0045HTMLAction.java
*@FileTitle      : BSA Data I/F 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011.04.04
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2011.04.04
* 1.0 Creation
*=========================================================
* History :
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 
*=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
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
 * @author 최윤성
 * @see BSAYearlyPlanEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BSA_0045HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BSA_0045HTMLAction 객체를 생성
	 */
	public ESM_BSA_0045HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BSAManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBsa0045Event event = new EsmBsa0045Event();
		
		if(    command.isCommand(FormCommand.MULTI01)
			|| command.isCommand(FormCommand.MULTI02)
			|| command.isCommand(FormCommand.MULTI03)) {
			event.setBsaTableSaveVOs((BsaTableSaveVO[])getVOs(request, BsaTableSaveVO.class, ""));
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