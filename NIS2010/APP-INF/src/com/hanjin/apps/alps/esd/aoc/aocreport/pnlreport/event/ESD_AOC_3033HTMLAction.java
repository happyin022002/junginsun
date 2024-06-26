/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3033HTMLAction.java
*@FileTitle : Profit & Loss Report for Inland BIZ
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.20 변종건 [CHM-201217633] Profit & Loss Report for Inland BIZ 생성
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SC로 실행요청<br>
 * - SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EsdAoc3033Event 참조
 * @since J2EE 1.4
 */
public class ESD_AOC_3033HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_AOC_3033HTMLAction 객체를 생성
	 */
	public ESD_AOC_3033HTMLAction(){}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdAoc3033Event event = new EsdAoc3033Event();
		
		if( command.isCommand(FormCommand.SEARCH) ){
			event.setPnLBkgDtlListVO((PnLBkgDtlListVO)getVO(request, PnLBkgDtlListVO .class));
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