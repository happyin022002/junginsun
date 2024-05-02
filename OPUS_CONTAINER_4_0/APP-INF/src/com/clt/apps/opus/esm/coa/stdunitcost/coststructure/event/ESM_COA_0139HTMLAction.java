/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_COA_139HTMLAction.java
*@FileTitle : Feeder Term
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-24
*@LastModifier : Lee Ho Ik
*@LastVersion : 1.3
* 2007-05-22 Lee Ho Ik
* 1.0 최초 생성
* Change history :
* 2009.07.24 장영석 New Framework 적용
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaTrnsFdrTermVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Yeong-seok
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0139HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0139HTMLAction 객체를 생성
	 */
	public ESM_COA_0139HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0139Event event = new EsmCoa0139Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCoaTrnsFdrTermVOS((CoaTrnsFdrTermVO[])getVOs(request, CoaTrnsFdrTermVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
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