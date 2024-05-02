/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0119HTMLAction.java
*@FileTitle : Acct Code Setting to select UOM
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2007.02.14 임옥영  최초 생성
* 2009.10.09 박수훈  0119 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.CoaTmlTrfGrpVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0119HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0119HTMLAction 객체를 생성
	 */
	public ESM_COA_0119HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0119Event event = new EsmCoa0119Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCoaTmlTrfGrpVOS((CoaTmlTrfGrpVO[])getVOs(request, CoaTmlTrfGrpVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchUOM0119ListVO((SearchUOM0119ListVO)getVO(request, SearchUOM0119ListVO .class));
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