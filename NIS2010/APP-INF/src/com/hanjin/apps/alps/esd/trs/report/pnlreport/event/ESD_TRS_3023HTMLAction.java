/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_3023HTMLAction.java
*@FileTitle : Profit & Loss Report for Europe Inland BIZ
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.pnlreport.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_080SC로 실행요청<br>
 * - ESD_TRS_3023SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EsdTrs3023Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_3023HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_3023HTMLAction 객체를 생성
	 */
	public ESD_TRS_3023HTMLAction(){}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_080Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdTrs3023Event event = new EsdTrs3023Event();
		
		if( command.isCommand(FormCommand.SEARCH) ){
			event.setPnLRptOptionVO((PnLRptOptionVO)getVO(request, PnLRptOptionVO .class));
		} else if( command.isCommand(FormCommand.SEARCH01) ){
			event.setPnLRptOptionVOs((PnLRptOptionVO[])getVOs(request, PnLRptOptionVO .class,""));
		} else if( command.isCommand(FormCommand.SEARCH02) ){
			event.setPnLRptOptionVO((PnLRptOptionVO)getVO(request, PnLRptOptionVO .class));
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