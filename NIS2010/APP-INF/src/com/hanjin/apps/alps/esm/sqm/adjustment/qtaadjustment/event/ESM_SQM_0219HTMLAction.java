/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0219HTMLAction.java
*@FileTitle      : QTA Adjustment by VVD for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sqm.planning 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanningSC로 실행요청<br>
 * - PlanningSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SQM USER
 * @see EsmSqm0219Event 참조
 * @since J2EE 1.6
 */

public class ESM_SQM_0219HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SQM_0219HTMLAction 객체를 생성
	 */
	public ESM_SQM_0219HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSqm0219Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSqm0219Event event = new EsmSqm0219Event();

		if (command.isCommand(FormCommand.MULTI01)) {
			event.setManageQtaAdjustmentVOS((ManageQtaAdjustmentVO[])getVOs(request, ManageQtaAdjustmentVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setManageQtaAdjustmentVOS((ManageQtaAdjustmentVO[])getVOs(request, ManageQtaAdjustmentVO .class,""));
		}
		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));

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