/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0004HTMLAction.java
*@FileTitle : Node Cost (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.11.27 임옥영  최초 생성
* 2009.07.24 박수훈  0004 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.event;


import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0004HTMLAction 객체를 생성
	 */
	public ESM_COA_0004HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0004Event event = new EsmCoa0004Event();

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchMonthYardCodeListVO((SearchMonthYardCodeListVO)getVO(request, SearchMonthYardCodeListVO .class));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchMonthYardCodeListVO((SearchMonthYardCodeListVO)getVO(request, SearchMonthYardCodeListVO .class));
			event.setSearchMonthNodeCostListVO((SearchMonthNodeCostListVO)getVO(request, SearchMonthNodeCostListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
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