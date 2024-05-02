/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2046HTMLAction.java
*@FileTitle : Retroactive RFA monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.24 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfareport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAReportSC로 실행요청<br>
 * - RFAReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 최성환
 * @see RFAReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_2046HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2046HTMLAction 객체를 생성
	 */
	public ESM_PRI_2046HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAReportEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri2046Event event = new EsmPri2046Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltPriRpRetroInfoVO((RsltPriRpRetroInfoVO)getVO(request, RsltPriRpRetroInfoVO.class));
		}
//		request.setAttribute("Event", event);
		
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