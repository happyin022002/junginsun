/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1519HTMLAction.java
*@FileTitle : ESM_BKG_1519HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2014. 12. 01.
*@LastModifier :
*@LastVersion : 1.0
* 2014. 12. 01.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;

import javax.servlet.http.HttpServletRequest;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaIbManifestVO;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * ESM_BKG_1519 의 HTML Action Class
 *
 * @author
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ESM_BKG_1519HTMLAction extends HTMLActionSupport {

	public ESM_BKG_1519HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsmBkg1519Event event = new EsmBkg1519Event();
		FormCommand command = FormCommand.fromRequest(request);

		switch (command.getCommand()) {
			case FormCommand.SEARCH:    // Search Sheet1 Header List (RETRIEVE)
				event.setVvd(request.getParameter("vvd"));
			break;

			case FormCommand.COMMAND01:    // Start Back End Job (TRANSMIT)
				event.setVvd(request.getParameter("vvd"));
				event.setPsaIbManifestVOs((PsaIbManifestVO[]) getVOs(request, PsaIbManifestVO.class, ""));
			break;

			case FormCommand.COMMAND02:    // Get status of Back End Job (TRANSMIT)
			case FormCommand.COMMAND03:    // Result return (TRANSMIT)
				event.setAttribute("backEndJob_Key", request.getParameter("backEndJob_Key"));
			break;
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
