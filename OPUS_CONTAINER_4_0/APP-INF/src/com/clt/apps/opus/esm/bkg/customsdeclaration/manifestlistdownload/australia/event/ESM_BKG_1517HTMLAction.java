/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1517HTMLAction.java
*@FileTitle : ESM_BKG_1517HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - ESM_BKG_1517 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceCommand Layer로 실행요청<br>
 * - ServiceCommand Layer에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see EsmBkg1517Event 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1517HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_1517HTMLAction 객체를 생성
	 */
	public ESM_BKG_1517HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmBkg1517Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1517Event event = new EsmBkg1517Event();

		if (command.isCommand(FormCommand.SEARCH)) {    // RETRIEVE
			event.setAusSearchCuscarVO((AusSearchCuscarVO)getVO(request, AusSearchCuscarVO.class));
		} else  if (command.isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
			event.setAusSearchCuscarVO((AusSearchCuscarVO)getVO(request, AusSearchCuscarVO.class));
			event.setAusResultCuscarVOs((AusResultCuscarVO[])getVOs(request, AusResultCuscarVO.class, "sheet_"));
		} else if (command.isCommand(FormCommand.COMMAND02) ||     // Get status of Back End Job (TRANSMIT)
				   command.isCommand(FormCommand.COMMAND03)) {     // Result return (TRANSMIT)
			event.setAttribute("backEndJob_Key", request.getParameter("backEndJob_Key"));
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
