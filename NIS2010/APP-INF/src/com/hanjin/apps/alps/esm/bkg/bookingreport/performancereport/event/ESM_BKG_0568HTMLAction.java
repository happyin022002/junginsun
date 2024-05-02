/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBM_BKG_0568HTMLAction.java
*@FileTitle : C/A Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BookingReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0568HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EBM_BKG_0568HTMLAction 객체를 생성
	 */
	public ESM_BKG_0568HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0568Event event = new EsmBkg0568Event();

		if(command.isCommand(FormCommand.MULTI)) {
			
			event.setCaIssueDateInVOS((CaIssueDateInVO[])getVOs(request, CaIssueDateInVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			
			event.setCaIssueDateInVO((CaIssueDateInVO)getVO(request, CaIssueDateInVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {

			event.setCaIssueDateInVO((CaIssueDateInVO)getVO(request, CaIssueDateInVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			log.debug("champ........................1");
			event.setCaIssueDateInVOS((CaIssueDateInVO[])getVOs(request, CaIssueDateInVO .class,""));
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