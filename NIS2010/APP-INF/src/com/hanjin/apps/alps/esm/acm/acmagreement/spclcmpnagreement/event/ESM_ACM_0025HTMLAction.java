/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0025HTMLAction.java
*@FileTitle : Compensation Agreement Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0001Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.acm.acmagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ACMAgreementSC로 실행요청<br>
 * - ACMAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Young-Oh
 * @see EsmAcm0001Event 참조
 * @since J2EE 1.6
 */

public class ESM_ACM_0025HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_ACM_0025HTMLAction 객체를 생성
	 */
	public ESM_ACM_0025HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ACMMasterEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmAcm0025Event event = new EsmAcm0025Event();

		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH11)) {
			event.setScompAgreementVO((SCompAgreementVO)getVO(request, SCompAgreementVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setScompAgreementVOs((SCompAgreementVO[])getVOs(request, SCompAgreementVO.class, ""));
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