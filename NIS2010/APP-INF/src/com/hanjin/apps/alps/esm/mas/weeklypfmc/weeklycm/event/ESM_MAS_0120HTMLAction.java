/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0117HTMLAction.java
*@FileTitle : SMU Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.12.07 김종범 최초 생성
* 2009.09.11 0117 화면 New Framework 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MasSsnlSltMgmtUtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_MAS_0120HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0120HTMLAction 객체를 생성
	 */
	public ESM_MAS_0120HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmMas0120Event event = new EsmMas0120Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMasSsnlSltMgmtUtVOS((MasSsnlSltMgmtUtVO[])getVOs(request, MasSsnlSltMgmtUtVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchSeasonalSMUCostListVO((SearchSeasonalSMUCostListVO)getVO(request, SearchSeasonalSMUCostListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
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