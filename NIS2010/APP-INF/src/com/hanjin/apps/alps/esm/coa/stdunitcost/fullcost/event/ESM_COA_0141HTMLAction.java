/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0141HTMLAction.java
*@FileTitle : Link별 표준단가 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 장영석
*@LastVersion : 1.1
* 2009.09.01 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.hanjin.apps.alps.esm.coa.common.Utils;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Yeong-seok
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0141HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0141HTMLAction 객체를 생성
	 */
	public ESM_COA_0141HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0141Event event = new EsmCoa0141Event();	
		
		HashMap hash = new HashMap();
		hash = Utils.requestToHashMap(request);

		if(command.isCommand(FormCommand.SEARCH)) {

			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
			event.setSearchLinkCostListByPRDVO((SearchLinkCostListByPRDVO)getVO(request, SearchLinkCostListByPRDVO .class));			
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