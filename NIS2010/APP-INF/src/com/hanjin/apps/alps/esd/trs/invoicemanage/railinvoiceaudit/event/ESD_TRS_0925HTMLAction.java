/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0925HTMLAction.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_925SC로 실행요청<br>
 * - ESD_TRS_0925SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0925Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0925HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0925HTMLAction 객체를 생성
	 */
	public ESD_TRS_0925HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_925Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand   command = FormCommand.fromRequest(request);
		EsdTrs0925Event event = new EsdTrs0925Event();

		String sWblDt        = JSPUtil.getNull(request.getParameter("wbl_dt"));
		String sSelSheetIdx  = JSPUtil.getNull(request.getParameter("sel_sheet_idx"));
		String sEqNo         = JSPUtil.getNull(request.getParameter("eq_no"));
		String sFormCreUsrId = JSPUtil.getNull(request.getParameter("FORM_CRE_USR_ID"));
		String sRailRoadCode = JSPUtil.getNull(request.getParameter("rail_road_code"));
		String sMode         = JSPUtil.getNull(request.getParameter("mode"));
		String sFormUsrOfcCd = JSPUtil.getNull(request.getParameter("FORM_USR_OFC_CD"));		
		
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setWbl_dt(sWblDt);
			event.setSel_sheet_idx(sSelSheetIdx);
			event.setEq_no(sEqNo);
			event.setForm_cre_usr_id(sFormCreUsrId);
			event.setRail_road_code(sRailRoadCode);
			event.setMode(sMode);
			event.setForm_usr_ofc_cd(sFormUsrOfcCd);
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