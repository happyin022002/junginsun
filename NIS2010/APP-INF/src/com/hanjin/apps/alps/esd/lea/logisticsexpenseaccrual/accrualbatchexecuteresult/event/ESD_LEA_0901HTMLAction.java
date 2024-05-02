/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0901HTMLAction.java
*@FileTitle : Account Cost Inquiry (Pop-up)
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.30
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.30 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;

/** 
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LogisticsExpenseAccrualSC로 실행요청<br>
 * - LogisticsExpenseAccrualSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeon Jae Hong
 * @see LogisticsExpenseAccrualEvent 참조
 * @since J2EE 1.6
 */
 
public class ESD_LEA_0901HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_LEA_0901HTMLAction 객체를 생성
	 */
	public ESD_LEA_0901HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LogisticsExpenseAccrualEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdLea0901Event event = new EsdLea0901Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchAccrualAccountCodeVO((SearchAccrualAccountCodeVO)getVO(request, SearchAccrualAccountCodeVO .class));
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