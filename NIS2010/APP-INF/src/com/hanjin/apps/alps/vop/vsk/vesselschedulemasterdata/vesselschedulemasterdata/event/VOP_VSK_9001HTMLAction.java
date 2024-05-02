/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_9001HTMLAction.java
**@FileTitle : Lane?port Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : Lee Hyemin
*@LastVersion : 1.0
* 2012.08.03 Lee Hyemin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.vskcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VSKCommonSC로 실행요청<br>
 * - VSKCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Hyemin
 * @see VopVsk9001Event 참조
 * @since J2EE 1.5
 */

public class VOP_VSK_9001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_9001HTMLAction 객체를 생성
	 */
	public VOP_VSK_9001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk9001Event event = new VopVsk9001Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setUserDefinedLanePortGroupVO((UserDefinedLanePortGroupVO)getVO(request, UserDefinedLanePortGroupVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setUserDefinedLanePortGroupVOs((UserDefinedLanePortGroupVO[])getVOs(request, UserDefinedLanePortGroupVO.class));
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