/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_OPF_0410HTMLAction.java
*@FileTitle : Port Time KPI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06
* 1.0 Creation
* 2012.02.06 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.opf.porttimeperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PortTimePerformanceMgtSC로 실행요청<br>
 * - PortTimePerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see PortTimePerformanceMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0410HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0410HTMLAction 객체를 생성
	 */
	public VOP_OPF_0410HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PortTimePerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0410Event event = new VopOpf0410Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPortTimePerformanceConditionVO((PortTimePerformanceConditionVO)getVO(request, PortTimePerformanceConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setPortTimeKPIDetailVOs((PortTimeKPIDetailVO[])getVOs(request, PortTimeKPIDetailVO .class, "sheet1_"));
		}else if(command.isCommand(FormCommand.REMOVE)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.MODIFY)) {
			event.setPortTimeKPIDetailVOs((PortTimeKPIDetailVO[])getVOs(request, PortTimeKPIDetailVO .class, "sheet1_"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
		}else if(command.isCommand(FormCommand.DEFAULT)) {
			event.setPortTimeKPIDetailVO((PortTimeKPIDetailVO)getVO(request, PortTimeKPIDetailVO .class));
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