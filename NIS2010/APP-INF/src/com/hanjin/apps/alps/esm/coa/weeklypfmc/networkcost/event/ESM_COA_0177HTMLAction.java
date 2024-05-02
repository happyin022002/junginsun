/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0177HTMLAction.java
*@FileTitle : Lane Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.11 이행지
* 1.0 Creation
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.LaneTable1CycleVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0177HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0177HTMLAction 객체를 생성
	 */
	public ESM_COA_0177HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0177Event event = new EsmCoa0177Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setLaneTable1CycleVOs((LaneTable1CycleVO[])getVOs(request, LaneTable1CycleVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setLaneTable1CycleVO((LaneTable1CycleVO)getVO(request, LaneTable1CycleVO.class));
		} else{
			event.setLaneTable1CycleVO((LaneTable1CycleVO)getVO(request, LaneTable1CycleVO.class));
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