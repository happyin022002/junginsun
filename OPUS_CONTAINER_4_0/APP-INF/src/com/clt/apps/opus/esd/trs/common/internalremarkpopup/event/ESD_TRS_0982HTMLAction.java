 /*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0982HTMLAction.java
*@FileTitle : Internal Remark 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-07
*@LastModifier : ChanWooPark
*@LastVersion : 1.0
* 2015-05-07 ChanWooPark
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.event;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_0982SC로 실행요청<br>
 * - ESD_TRS_0982SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author CHAN WOO PARK
 * @see EsdTrs0982Event참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0982HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0982Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0982Event event = new EsdTrs0982Event();
		
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setBkg_no(JSPUtil.getParameter(request, "bkg_no", ""));
			
			String eq_no = JSPUtil.getParameter(request, "eq_no", "");
			String[] eq_noArr = eq_no.split(Pattern.quote("|"));
			if (eq_noArr.length == 1)
				event.setEq_no(eq_no);
			
			event.setSo_no(JSPUtil.getParameter(request, "so_no", ""));
			event.setWo_no(JSPUtil.getParameter(request, "wo_no", ""));
			event.setInter_rmk_cd(JSPUtil.getParameter(request, "inter_rmk_cd", ""));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setInternalRemarkVOs((InternalRemarkVO[]) getVOs(request, InternalRemarkVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI01)) { // CY&Door S/O Delete
			event.setSo_no(JSPUtil.getParameter(request, "trsp_so_ofc_seq", ""));
		} else if (command.isCommand(FormCommand.MULTI02)) { // Supplement S/O Delete
			event.setSo_no(JSPUtil.getParameter(request, "so_number", ""));
		} else if (command.isCommand(FormCommand.MULTI03)) { // Other S/O Delete
			String so_no = JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", "") + JSPUtil.getParameter(request, "trsp_so_seq", "");
			event.setSo_no(so_no);
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
