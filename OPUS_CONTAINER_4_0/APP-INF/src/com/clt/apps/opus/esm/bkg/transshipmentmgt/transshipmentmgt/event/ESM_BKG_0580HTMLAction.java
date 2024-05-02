/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0580HTMLAction.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgVslDchgYdVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TransshipmentMgtSC로 실행요청<br>
 * - TransshipmentMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0580HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0580HTMLAction 객체를 생성
	 */
	public ESM_BKG_0580HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TransshipmentMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0580Event event = new EsmBkg0580Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setbkgVslDchgYdVOS((BkgVslDchgYdVO[])getVOs(request, BkgVslDchgYdVO .class,"sheet1_"));
			event.setMdmYardVOS((MdmYardVO[])getVOs(request,MdmYardVO .class,"sheet2_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setbkgVslDchgYdInputVO((BkgVslDchgYdInputVO)getVO(request,BkgVslDchgYdInputVO .class));
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