/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_2014HTMLAction.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTExceptionMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SungHoon, Lee
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_2014HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ees_dmt_2014HTMLAction 객체를 생성
	 */
	public EES_DMT_2014HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTExceptionMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt2014Event event = new EesDmt2014Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}
		//선택한 Customer 가 S/C, Before 인지를 체크한다.
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}
		//입력한 Coverage 가 Dual 인지를 체크한다.
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		//Dual Type Exception 이 삭제가능한지를 체크한다.
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}
		//Expire Date 가 유효한지 체크한다.(S/C, Before Booking 의 Expire Date 보다 작다면 에러)
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}
		//입력한 Dual Type Exception 이 중복된 데이터인지 체크한다.
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setDualTypeCustomerVO((DualTypeCustomerVO)getVO(request, DualTypeCustomerVO .class));
		}		
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setDualTypeCustomerVOS((DualTypeCustomerVO[])getVOs(request, DualTypeCustomerVO .class,""));
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