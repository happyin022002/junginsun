/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0022HTMLAction.java
*@FileTitle : Off-Hire Confirm from Lessor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.05 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Jun-Woo
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */
public class EES_LSE_0022HTMLAction extends HTMLActionSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_LSE_0022HTMLAction 객체를 생성
	 */
	public EES_LSE_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EesLse0022Event event = new EesLse0022Event();

		switch(command.getCommand()) {
			case FormCommand.SEARCH :	//조회
				event.setSearchParamVO((SearchParamVO)getVO(request, SearchParamVO .class));
				break;
			case FormCommand.COMMAND01 :	//BackEndJob - 작업요청
			case FormCommand.COMMAND02 :	//BackEndJob - 상태조회
			case FormCommand.COMMAND03 :	//BackEndJob - 결과로드
				event.setAttribute("KEY", request.getParameter("backendjob_key"));
				event.setSearchParamVO((SearchParamVO)getVO(request, SearchParamVO .class));
				break;
			case FormCommand.MULTI :	//멀티
				event.setAvailableOffHireConfirmVOs((AvailableOffHireConfirmVO[])getVOs(request, AvailableOffHireConfirmVO.class));
				break;
			default :	//do nothing
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
