/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0210HTMLAction.java
*@FileTitle : ID Link Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.20 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.portsomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PortSOMasterDataMgtSC로 실행요청<br>
 * - PortSOMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Myounghun
 * @see PortSOMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0210HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0210HTMLAction 객체를 생성
	 */
	public VOP_PSO_0210HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PortSOMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0210Event event = new VopPso0210Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO = (UseStatusConditonFormulaDtlVO)getVO(request, UseStatusConditonFormulaDtlVO .class);
			event.setUseStatusConditonFormulaDtlVO(useStatusConditonFormulaDtlVO);
		} else if(command.isCommand(FormCommand.DEFAULT)) { 
			
			event.setAttribute("id_tp", JSPUtil.getParameter(request, "id_tp", ""));	
			event.setAttribute("id_no", JSPUtil.getParameter(request, "id_no", ""));	
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