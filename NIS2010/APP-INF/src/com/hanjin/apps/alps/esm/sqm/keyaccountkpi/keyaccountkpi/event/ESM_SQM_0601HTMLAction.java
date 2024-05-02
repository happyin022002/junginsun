/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0601HTMLAction.java
*@FileTitle      : KPI Upload
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.30
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.03 이혜민
* 1.0 Creation
* 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SqmKeyAcctCfmQtaVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sqm.specialkpi 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialKpiSC 실행요청<br>
 * - SpecialKpiSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 이혜민
 * @see EsmSqm0601Event 참조
 * @since J2EE 1.6
 */

public class ESM_SQM_0601HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SQM_0601HTMLAction 객체를 생성
	 */
	public ESM_SQM_0601HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSqm0601Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmSqm0601Event event = new EsmSqm0601Event();
    	if(command.isCommand(FormCommand.SEARCH)) {
    		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
    		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
    		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			event.setSqmKeyAcctCfmQtaVO ((SqmKeyAcctCfmQtaVO) getVO(request, SqmKeyAcctCfmQtaVO .class , ""));
			event.setSqmKeyAcctCfmQtaVOS((SqmKeyAcctCfmQtaVO[])getVOs(request, SqmKeyAcctCfmQtaVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI01)) {
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