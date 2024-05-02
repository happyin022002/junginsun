/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1174HTMLAction.java
*@FileTitle : NMC (Non-Manipulation Certificate)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2014.04.07 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TransshipmentMgtSC 실행요청<br>
 * - TransshipmentMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 조인영
 * @see EsmBkg1174Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1174HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1174HTMLAction 객체를 생성
	 */
	public ESM_BKG_1174HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmBkg1174Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1174Event event = new EsmBkg1174Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			String cntr_no = JSPUtil.getParameter(request, "cntr_no");
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			event.setCntr_no(cntr_no);
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