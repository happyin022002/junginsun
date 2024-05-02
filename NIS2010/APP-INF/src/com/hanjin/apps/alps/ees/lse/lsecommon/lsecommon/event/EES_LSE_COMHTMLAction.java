/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_LSE_0048HTMLAction.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LseCommonSC로 실행요청<br>
 * - LseCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @see EesLseComEvent 참조
 * @since J2EE 1.4
 */

public class EES_LSE_COMHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_LSE_0048HTMLAction 객체를 생성
	 */
	public EES_LSE_COMHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesLseComEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesLseComEvent event = new EesLseComEvent();

		if ( command.isCommand(FormCommand.SEARCH03)
		  || command.isCommand(FormCommand.SEARCH04)
		  || command.isCommand(FormCommand.SEARCH15) ) {
			event.setAgreementVO((AgreementVO)getVO(request, AgreementVO.class));
		} else if ( command.isCommand(FormCommand.SEARCH05) ) {
			event.setLocCd(request.getParameter("loc_cd"));
			event.setLocTp(request.getParameter("loc_tp"));
		} else if ( command.isCommand(FormCommand.SEARCH06) ) {
			event.setVndrSeq(request.getParameter("vndr_seq"));
		} else if ( command.isCommand(FormCommand.SEARCH07) ) {
			event.setCurrCd(request.getParameter("curr_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH10)
		         || command.isCommand(FormCommand.SEARCH13) ) {
			event.setLocCd(request.getParameter("loc_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH14) ) {
			event.setVvdCd(request.getParameter("vvd_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH16) ) {
			event.setOfcCd(request.getParameter("ofc_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH17) ) {
			event.setCntrNo(request.getParameter("cntr_no"));
		} else if ( command.isCommand(FormCommand.SEARCH18) ) {
			event.setYdCd(request.getParameter("yd_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH19) ) {
			event.setSLanCd(request.getParameter("slan_cd"));
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