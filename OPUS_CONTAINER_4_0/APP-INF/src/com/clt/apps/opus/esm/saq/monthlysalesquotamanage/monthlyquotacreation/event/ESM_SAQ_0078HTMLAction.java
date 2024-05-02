/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SAQ_0077HTMLAction.java
 *@FileTitle : Model Result
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.04
 *@LastModifier : 김종호
 *@LastVersion : 1.1
 * 2006-12-21 byyoo
 * 1.0 최초 생성
 * 2009.08.31 김종호
 * 1.1 Creation (new F/W 전환작업)   
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaManageSC로 실행요청<br>
 * - MonthlySalesQuotaManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Jong-Ho Kim
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0078HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_SAQ_0077HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0078HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0078Event event = new EsmSaq0078Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setBaseDataInterfaceVO((BaseDataInterfaceVO) getVO(request, BaseDataInterfaceVO.class));
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setBaseDataInterfaceVO((BaseDataInterfaceVO) getVO(request, BaseDataInterfaceVO.class));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setBaseDataInterfaceVO((BaseDataInterfaceVO) getVO(request, BaseDataInterfaceVO.class));
		} else if (command.isCommand(FormCommand.MODIFY03)) {
			event.setBaseDataInterfaceVO((BaseDataInterfaceVO) getVO(request, BaseDataInterfaceVO.class));
		}

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}