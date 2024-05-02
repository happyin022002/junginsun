/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_COA_0022HTMLAction.java
*@FileTitle : MTY Reposition Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.07 송호진
* 1.0 Creation
=========================================================
* History
* 2012.12.13 송호진 [CHM-201221879] [COA] Manual Cost Set up 화면 로직 수정 ( 파일 신규 생성 )
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SongHoJin
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0022HTMLAction 객체를 생성
	 */
	public ESM_COA_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0022Event event = new EsmCoa0022Event();
		
		if(command.isCommand(FormCommand.MULTI01) ) {
			event.setMtyRepoTESTRSCostVOS((MtyRepoTESTRSCostVO[])getVOs(request, MtyRepoTESTRSCostVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI02)) { 
			event.setMtyRepoTESTRSCostVOS((MtyRepoTESTRSCostVO[])getVOs(request, MtyRepoTESTRSCostVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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