/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DMT_6013HTMLAction.java
*@FileTitle : Unissued Invoice by Aging – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.11 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceByAgingParmVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTPerformanceAnalysisSC로 실행요청<br>
 * - DMTPerformanceAnalysisSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Hwang HyoKeun
 * @see DMTPerformanceAnalysisEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_6013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_6013HTMLAction 객체를 생성
	 */
	public EES_DMT_6013HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTPerformanceAnalysisEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesDmt6013Event event = new EesDmt6013Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setUnissuedInvoiceByAgingParmVO((UnissuedInvoiceByAgingParmVO)getVO(request, UnissuedInvoiceByAgingParmVO .class));
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