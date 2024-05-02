/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1118HTMLAction.java
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.01 박준용
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

public class ESM_BKG_1118HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1118HTMLAction 객체를 생성
	 */
	public ESM_BKG_1118HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1118Event event = new EsmBkg1118Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			String bl_tp_cd = JSPUtil.getParameter(request, "bl_tp_cd");
			String hiddenData = JSPUtil.getParameter(request, "hiddenData");
			String form_Cntr = JSPUtil.getParameter(request, "form_Cntr");
			String form_corr_no = JSPUtil.getParameter(request, "form_corr_no");
			String form_level = JSPUtil.getParameter(request, "form_level");
			
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			event.setBlTpCd(bl_tp_cd);
			event.setHiddenData(hiddenData);
			event.setForm_Cntr(form_Cntr);
			event.setForm_corr_no(form_corr_no);
			event.setFormLevel(form_level);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			// 저장 변수 
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String sr_sts_cd = JSPUtil.getParameter(request, "sr_sts_cd");
			String hiddenData = JSPUtil.getParameter(request, "hiddenData");
			String form_level = JSPUtil.getParameter(request, "form_level");
			
			event.setBkg_no(bkg_no);
			event.setSrStsCd(sr_sts_cd);
			event.setHiddenData(hiddenData);
			event.setFormLevel(form_level);
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			// 저장 변수 
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String sr_sts_cd = JSPUtil.getParameter(request, "sr_sts_cd");
			String hiddenData = JSPUtil.getParameter(request, "hiddenData");
			String form_level = JSPUtil.getParameter(request, "form_level");
			
			event.setBkg_no(bkg_no);
			event.setSrStsCd(sr_sts_cd);
			event.setHiddenData(hiddenData);
			event.setFormLevel(form_level);
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