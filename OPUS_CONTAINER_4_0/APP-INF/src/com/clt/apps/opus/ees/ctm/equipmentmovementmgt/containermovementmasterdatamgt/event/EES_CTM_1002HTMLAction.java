/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_1001HTMLAction.java
*@FileTitle : CNTR MVMT Sequence
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.ctm.equipmentmovementmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청<br>
 * - EquipmentMovementMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EquipmentMovementMgtEvent 참조
 * @since J2EE 1.5
 * 2009.4.30
 */
public class EES_CTM_1002HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	
	public EES_CTM_1002HTMLAction() {}
	
	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest
	 * @return event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesCtm1002Event event = new EesCtm1002Event();
		
		if(command.isCommand(FormCommand.MULTI)){
			event.setCtmMvmtStsDcsnVOs((CtmMvmtStsDcsnVO[]) getVOs(request, CtmMvmtStsDcsnVO .class, ""));
		}
		else if(command.isCommand(FormCommand.SEARCH)){
			event.setCtmMvmtStsDcsnVO((CtmMvmtStsDcsnVO) getVOs(request, CtmMvmtStsDcsnVO .class));
		}
		request.setAttribute("Event", event);
		
		return event;
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
