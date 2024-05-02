/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0102HTMLAction.java
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.27 최윤성
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.dailyforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DailyForecastSC로 실행요청<br>
 * - DailyForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI Yun Sung
 * @see DailyForecastEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0999HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0999HTMLAction 객체를 생성
	 */
	public ESM_SPC_0999HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DailyForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0999Event event = new EsmSpc0999Event();
		SpcDlyFcastCustVO spcDlyFcastCustVO = new SpcDlyFcastCustVO();
		
		// 현재 MULTI01, SEARCHLIST01 호출되지 않지만 ENIS 같이 구현해 놓음.
//		if(command.isCommand(FormCommand.MULTI01)) {
//			//event.setSpcDlyFcastCustVOS((SpcDlyFcastCustVO[])getVOs(request, SpcDlyFcastCustVO .class,""));
//		}
		if(command.isCommand(FormCommand.MULTI02)) {
			event.setSpcDlyFcastCustVOS(spcDlyFcastCustVO.fromRequestGridDate(request, ""));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
//		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
//			//event.setSearchDailyForecastManageListVO((SearchDailyForecastManageListVO)getVO(request, SearchDailyForecastManageListVO .class));
//		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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