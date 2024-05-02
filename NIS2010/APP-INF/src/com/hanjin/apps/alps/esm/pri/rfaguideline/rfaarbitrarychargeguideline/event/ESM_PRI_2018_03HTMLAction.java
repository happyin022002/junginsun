/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_PRI_2018_04HTMLAction.java
*@FileTitle : RFA Guideline Inquiry - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.12 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.PriRgArbVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfaguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAGuidelineSC로 실행요청<br>
 * - RFAGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JaeYeon Kim
 * @see RFAGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2018_03HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2018_03HTMLAction 객체를 생성
	 */
	public ESM_PRI_2018_03HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri201803Event event = new EsmPri201803Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPriRgArbVO((PriRgArbVO)getVO(request, PriRgArbVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRgArbVO((PriRgArbVO)getVO(request, PriRgArbVO .class));
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