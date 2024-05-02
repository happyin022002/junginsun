/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0420HTMLAction.java
*@FileTitle : ESM_BKG_0420HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * ESM_BKG_0420 의 HTML Action Class
 *
 * @author
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
public class ESM_BKG_0420HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0420HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsmBkg0420Event event = new EsmBkg0420Event();
		FormCommand command = FormCommand.fromRequest(request);

		if (command.isCommand(FormCommand.INIT) || command.isCommand(FormCommand.SEARCH)) {
			event.setPsaImpStsVO((PsaImpStsVO)getVO(request, PsaImpStsVO.class));

		} else if(command.isCommand(FormCommand.MULTI)) {    // Start Back End Job (SAVE)
			event.setPsaImpStsVOs((PsaImpStsVO[])getVOs(request, PsaImpStsVO.class, "sheet1_"));
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));

		} else if(command.isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
			event.setPsaImpStsVO((PsaImpStsVO)getVO(request, PsaImpStsVO.class));

		} else if (command.isCommand(FormCommand.SEARCH02)    // Get status of Back End Job (공통)
				|| command.isCommand(FormCommand.MULTI03)    // Result return (SAVE)
				|| command.isCommand(FormCommand.COMMAND03)) {    // Result return (TRANSMIT)
			event.setAttribute("backEndJob_Key", request.getParameter("backEndJob_Key"));
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

