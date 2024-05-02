/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0002HTMLAction.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.22 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;
		
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeVO;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PPSOAgentCanalTransitFeeSC로 실행요청<br>
 * - PPSOAgentCanalTransitFeeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Seong Kwang
 * @see PPSOAgentCanalTransitFeeEvent 참조
 * @since J2EE 1.6
 */

public class EXP_SPP_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EXP_SPP_0002HTMLAction 객체를 생성
	 */
	public EXP_SPP_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PPSOAgentCanalTransitFeeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	ExpSpp0002Event event = new ExpSpp0002Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {	//windowsopen	
			event.setCanalTzFeeEstDtlByVvdCondVO((CanalTzFeeEstDtlByVvdCondVO)getVO(request, CanalTzFeeEstDtlByVvdCondVO .class));		
		}
		else if(command.isCommand(FormCommand.MULTI)) {//save button click
			event.setPsoCnlTzFeeVO((PsoCnlTzFeeVO)getVO(request, PsoCnlTzFeeVO .class));	
			event.setPsoCnlTzFeeDtlVOS((PsoCnlTzFeeDtlVO[])getVOs(request, PsoCnlTzFeeDtlVO .class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {//request button click
			event.setPsoCnlTzFeeVO((PsoCnlTzFeeVO)getVO(request, PsoCnlTzFeeVO .class));			
		}		

		request.setAttribute("Event", event);

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