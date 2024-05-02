/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_SAQ_0181HTMLAction.java
 *@FileTitle : Office Verify - popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.04
 *@LastModifier : Han-su Kim
 *@LastVersion : 1.0
 * 1.0 최초 생성 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataFromCoaListVO;
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
 * @author Han-su Kim
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0181HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_SAQ_0181HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0181HTMLAction() {
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
		EsmSaq0181Event event = new EsmSaq0181Event();

		if (command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setBaseDataInterfaceVO((BaseDataInterfaceVO) getVO(request, BaseDataInterfaceVO.class));
			
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setBaseDataInterfaceVOS((BaseDataInterfaceVO[]) getVOs(request, BaseDataInterfaceVO.class));
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