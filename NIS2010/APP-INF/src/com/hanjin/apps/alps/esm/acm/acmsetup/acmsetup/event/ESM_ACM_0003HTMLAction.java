/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0003HTMLAction.java
*@FileTitle : Charge Deduction User Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.14 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.acm.acmsetup 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ACMSetupSC로 실행요청<br>
 * - ACMSetupSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see EsmAcm0003Event 참조
 * @since J2EE 1.6
 */

public class ESM_ACM_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_ACM_0003HTMLAction 객체를 생성
	 */
	public ESM_ACM_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ACMSetupEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmAcm0003Event event = new EsmAcm0003Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setChargeDdtSetVO((ChargeDdtSetVO)getVO(request, ChargeDdtSetVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setChargeDdtSetVOs((ChargeDdtSetVO[])getVOs(request, ChargeDdtSetVO.class, "UsrSet_"));
			event.setChargeDdtSetRepChgVOs((ChargeDdtSetVO[])getVOs(request, ChargeDdtSetVO.class, "RepChg_"));
			event.setChargeDdtSetChargeVOs((ChargeDdtSetVO[])getVOs(request, ChargeDdtSetVO.class, "Charge_"));
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