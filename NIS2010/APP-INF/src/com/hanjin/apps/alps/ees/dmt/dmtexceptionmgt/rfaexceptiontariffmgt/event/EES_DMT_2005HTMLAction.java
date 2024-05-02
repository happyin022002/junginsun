/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2005HTMLAction.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.30 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTExceptionMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SungHoon, Lee
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_2005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_2005HTMLAction 객체를 생성
	 */
	public EES_DMT_2005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTExceptionMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt2005Event event = new EesDmt2005Event();
		
		//Request Detail 조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Ver No. 목록 조회(Dar No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Affiliate 목록 조회(Prop No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//DAR No. 나 APVL No. 로 Proposal No. 를 조회한다.
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Comment History 목록 조회
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Approval 처리
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Counter Offer 처리
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Reject 처리
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Approval NO. 조회
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}		
		//Proposal No. 로 해당 Customer 정보를 조회
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Proposal No. 로 해당 RFA No. 정보를 조회
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Approval No. 에 해당되는 RFA(Before Booking Request) 의 VER 를 조회한다.
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//DAR No. 에 해당되는 Approval Office Code 를 조회한다.
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 Request Detail. 에 대한 하위 항목들을 모두 조회한다.
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Proposal No.나 DAR No. 로 Approval No.를 조회 합니다. 
		else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
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
