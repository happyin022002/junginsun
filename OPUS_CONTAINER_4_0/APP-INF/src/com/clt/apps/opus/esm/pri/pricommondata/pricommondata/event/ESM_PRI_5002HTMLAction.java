/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_5002HTMLAction.java
*@FileTitle : Percent Base Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.04.23 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriScgPctBseChgVO;
import com.clt.syscommon.common.table.PriScgPctBseVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.pricommondata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - PRISC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SHKIM
 * @see PRI 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_5002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_5002HTMLAction 객체를 생성
	 */
	public ESM_PRI_5002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRIEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri5002Event event = new EsmPri5002Event();
		
		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriScgPctBseVO((PriScgPctBseVO)getVO(request, PriScgPctBseVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setPriScgPctBseVOs((PriScgPctBseVO[])getVOs(request, PriScgPctBseVO.class,"sheet1_"));
			event.setPriScgPctBseChgVOs((PriScgPctBseChgVO[])getVOs(request, PriScgPctBseChgVO.class,"sheet2_"));
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