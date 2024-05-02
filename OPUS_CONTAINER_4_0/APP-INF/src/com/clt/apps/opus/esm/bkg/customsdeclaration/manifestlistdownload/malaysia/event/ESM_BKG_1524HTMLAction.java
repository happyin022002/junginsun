/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1524HTMLAction.java
*@FileTitle : ESM_BKG_1524HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.ImpStsSpclCgoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * ESM_BKG_1524 의 HTML Action Class
 *
 * @author
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
public class ESM_BKG_1524HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_1524HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsmBkg1524Event event = new EsmBkg1524Event();
		FormCommand command = FormCommand.fromRequest(request);

		if (command.isCommand(FormCommand.INIT) || command.isCommand(FormCommand.SEARCH)) {
			event.setImpStsSpclCgoVO((ImpStsSpclCgoVO)getVO(request, ImpStsSpclCgoVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setImpStsSpclCgoVO((ImpStsSpclCgoVO)getVO(request, ImpStsSpclCgoVO.class));
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
