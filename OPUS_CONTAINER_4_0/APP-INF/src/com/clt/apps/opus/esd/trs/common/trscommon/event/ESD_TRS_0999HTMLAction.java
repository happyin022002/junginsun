/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_TRS_0999HTMLAction.java
 *@FileTitle : TrsCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.19
 *@LastModifier : 황효근
 *@LastVersion : 1.0
 * 2011.10.19 황효근
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsComboVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author HwangHyoKeun
 * @see CommonEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TRS_0999HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0999HTMLAction 객체를 생성
	 */
	public ESD_TRS_0999HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		String custCd = request.getParameter("input_cust_cd");
		EsdTrs0999Event event = new EsdTrs0999Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setTrsComboVO((TrsComboVO) getVO(request, TrsComboVO.class));
		} else if (command.isCommand(FormCommand.SEARCH04)) {
			event.setCmdtCd(JSPUtil.getParameter(request, "commodity_cd", ""));
		} else if (command.isCommand(FormCommand.SEARCH05)) {
			custCd = (custCd != null) ? custCd.toUpperCase() : custCd;
			event.setCustCd(custCd);
		} else if (command.isCommand(FormCommand.SEARCH06)) {
			event.setWgtMeasUtCd(JSPUtil.getParameter(request, "wgt_meas_ut_cd", ""));
			event.setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		} else {
			event.setTrsComboVO((TrsComboVO) getVO(request, TrsComboVO.class));
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