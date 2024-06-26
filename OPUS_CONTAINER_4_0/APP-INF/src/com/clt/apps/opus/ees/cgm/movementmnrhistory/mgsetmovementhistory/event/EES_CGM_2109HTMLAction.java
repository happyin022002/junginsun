/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_CGM_1109HTMLAction.java
*@FileTitle : Chassis Movement Update by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.11 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cgm.movementmnrhistory 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MovementMnrHistorySC로 실행요청<br>
 * - MovementMnrHistorySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI MIN HOI
 * @see MovementMnrHistoryEvent 참조
 * @since J2EE 1.6
 */

public class EES_CGM_2109HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1109HTMLAction 객체를 생성
	 */
	public EES_CGM_2109HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MovementMnrHistoryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCgm2109Event event = new EesCgm2109Event();
		

		if(command.isCommand(FormCommand.MULTI)) {
			event.setCtmMovementVOS((MVMTBookingInfoVO[])getVOs(request, MVMTBookingInfoVO .class,""));
			event.setCusCtmMovementVOS((CusCtmMovementVO[])getVOs(request, CusCtmMovementVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCtmMovementVO((MVMTBookingInfoVO)getVO(request, MVMTBookingInfoVO .class));
			event.setMVMTHistoryListVO((MVMTHistoryListVO)getVO(request, MVMTHistoryListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMGSmgstChkINVO((MGSmgstChkINVO)getVO(request, MGSmgstChkINVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setMGSmgstChkINVO((MGSmgstChkINVO)getVO(request, MGSmgstChkINVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setMGSmgstChkINVO((MGSmgstChkINVO)getVO(request, MGSmgstChkINVO .class));
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