/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0027HTMLAction.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.03 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ServiceLaneVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmLocationVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.vsk.actualschedulemanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ActualScheduleManagementSC로 실행요청<br>
 * - ActualScheduleManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Jinwoo
 * @see ActualScheduleManagementEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0027HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0027HTMLAction 객체를 생성
	 */
	public VOP_VSK_0027HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ActualScheduleManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0027Event event = new VopVsk0027Event();
//		if(command.isCommand(FormCommand.SEARCH01)) {
//			//parameter 없음.
//		}else 
		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setActSkdRtoVO((ActSkdRtoVO)getVO(request, ActSkdRtoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setMdmLocationVO((MdmLocationVO)getVO(request, MdmLocationVO .class));
		} 
//		else if(command.isCommand(FormCommand.SEARCH04)) {
//			event.setYardVO((YardVO)getVO(request, YardVO .class));
//		} 
		else if (command.isCommand(FormCommand.SEARCH10)){
			event.setVvdVO((VvdVO)getVO(request, VvdVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setActSkdRtoVO((ActSkdRtoVO)getVO(request, ActSkdRtoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setActSkdRtoVO((ActSkdRtoVO)getVO(request, ActSkdRtoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setActSkdRtoVO((ActSkdRtoVO)getVO(request, ActSkdRtoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setActSkdRtoVO((ActSkdRtoVO)getVO(request, ActSkdRtoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST05)) {
			event.setActSkdEdiMntrVO((ActSkdEdiMntrVO)getVO(request, ActSkdEdiMntrVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setActSkdEdiMntrVOs((ActSkdEdiMntrVO[])getVOs(request, ActSkdEdiMntrVO .class, "t5sheet1_"));
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