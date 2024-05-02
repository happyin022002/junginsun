/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0058HTMLAction.java
*@FileTitle : Space Utilization Inquiry VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.10.30 신자영 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spacecontrolinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpacecontrolinquirySC 실행요청<br>
 * - SpaceAllocationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see SpaceControlInquiryEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0058HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0045HTMLAction 객체를 생성
	 */
	public ESM_SPC_0058HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpaceAllocationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0058Event event = new EsmSpc0058Event();
		
		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		
//		if(command.isCommand(FormCommand.SEARCHLIST02)) {
//			//event.setSearchSpaceAllocationManage045QtyListVO((SearchSpaceAllocationManage045QtyListVO)getVO(request, SearchSpaceAllocationManage045QtyListVO .class));
//			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
//		}
//		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
//			//event.setSearchSpaceAllocationManage045VVDListVO((SearchSpaceAllocationManage045VVDListVO)getVO(request, SearchSpaceAllocationManage045VVDListVO .class));
//			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
//		}

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