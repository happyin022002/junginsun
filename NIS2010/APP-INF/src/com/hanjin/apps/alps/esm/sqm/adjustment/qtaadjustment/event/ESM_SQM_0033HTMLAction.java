/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0033HTMLAction.java
*@FileTitle      : Portion Adjustment by RHQ
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SqmCfmQtaPotnMgmtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sqm.planning 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanningSC로 실행요청<br>
 * - PlanningSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JEONGMIN CHO
 * @see EsmSqm0033Event 참조
 * @since J2EE 1.6
 */

public class ESM_SQM_0033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SQM_0033HTMLAction 객체를 생성
	 */
	public ESM_SQM_0033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSqm0033Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmSqm0033Event event = new EsmSqm0033Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			event.setSearchPotnAdjustmentListVOS((SearchPotnAdjustmentListVO[])getVOs(request, SearchPotnAdjustmentListVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			event.setSqmCfmQtaPotnMgmtVOS((SqmCfmQtaPotnMgmtVO[])getVOs(request, SqmCfmQtaPotnMgmtVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			event.setVvd (JSPUtil.getParameter(request, "vvd"));	
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