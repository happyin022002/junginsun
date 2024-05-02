/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : ESM_BKG_N005HTMLAction.java
 *@FileTitle : ESM_BKG_N005HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing한 정보를 Event로 변환, request에 담아 CustomsDeclarationCanadaCesSC로 실행요청<br>
 * - CustomsDeclarationCanadaCesSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author
 * @see EsmBkg1530Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_N005HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_N005HTMLAction 객체를 생성
	 */
	public ESM_BKG_N005HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkgN005Event event = new EsmBkgN005Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// Receive Log 조회
			CndCstmsSndHisListCondVO condVO = (CndCstmsSndHisListCondVO) getVO(request, CndCstmsSndHisListCondVO.class);
			condVO.setSSndDt(condVO.getSSndDt().replaceAll("-", "") + condVO.getSSndTm().replaceAll(":", ""));
			condVO.setESndDt(condVO.getESndDt().replaceAll("-", "") + condVO.getESndTm().replaceAll(":", ""));
			event.setCndCstmsSndHisListCondVO(condVO);
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