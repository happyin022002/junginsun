/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0418HTMLAction.java
*@FileTitle : Cargo Manifest print by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.08 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Joon Yong Park
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0418HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0278HTMLAction 객체를 생성
	 */
	public ESM_BKG_0418HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0418Event event = new EsmBkg0418Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			// Email
			String mode = JSPUtil.getParameter(request, "mode");
			String vvd = JSPUtil.getParameter(request, "vvd_cd");
			String port = JSPUtil.getParameter(request, "port_cd");
			String vslCd = JSPUtil.getParameter(request, "form_vslCd");
			String voyNo = JSPUtil.getParameter(request, "form_voyNo");
			String dirCd = JSPUtil.getParameter(request, "form_dirCd");
			String clptIndSeq = JSPUtil.getParameter(request, "form_clptIndSeq");
			
			String ibPreFix = JSPUtil.getParameter(request, "IBPREFIX");
			
			String[] bkgBlNos = request.getParameterValues(ibPreFix+"bl_no");
			
			event.setMode(mode);
			event.setVvd(vvd);
			event.setPort(port);
			event.setVslCd(vslCd);
			event.setVoyNo(voyNo);
			event.setDirCd(dirCd);
			event.setClptIndSeq(clptIndSeq);
			
			event.setBkgBlNos(bkgBlNos);
			
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