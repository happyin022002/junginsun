/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0112HTMLAction.java
*@FileTitle : VVD Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.10.23 박은주 최초 생성
* 2009.09.08 박수훈 0112 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaMonVvdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0112HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0112HTMLAction 객체를 생성
	 */
	public ESM_COA_0112HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0112Event event = new EsmCoa0112Event();
		
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCoaMonVvdVOS((CoaMonVvdVO[])getVOs(request, CoaMonVvdVO .class,""));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
			event.setSearchVVDChkWithARListVOS((SearchVVDChkWithARListVO[])getVOs(request, SearchVVDChkWithARListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchVVDChkWithARListVO((SearchVVDChkWithARListVO)getVO(request, SearchVVDChkWithARListVO .class));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setSearchVVDChkWithARListVO((SearchVVDChkWithARListVO)getVO(request, SearchVVDChkWithARListVO .class));
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