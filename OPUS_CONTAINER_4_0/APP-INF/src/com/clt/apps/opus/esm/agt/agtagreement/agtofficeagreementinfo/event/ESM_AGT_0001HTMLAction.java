/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESMAGT0001HTMLAction.java
 *@FileTitle : Agent Vendor List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 이호진
 *@LastVersion : 1.0
 * 2009.08.19 이호진
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.agt.agtagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의
 * Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAgreementSC로 실행요청<br>
 * - AGTAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Lee Ho Jin
 * @see AGTAgreementEvent 참조
 * @since J2EE 1.6
 */

public class ESM_AGT_0001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_AGT_0001HTMLAction 객체를 생성
	 */
	public ESM_AGT_0001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAgreementEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0001Event event = new EsmAgt0001Event();

		switch (command.getCommand()) {
		case FormCommand.SEARCH:
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO) getVO(request,
					AgtAgnAgmtVO.class));
			break;
		case FormCommand.REMOVE:
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[]) getVOs(request,
					AgtAgnAgmtVO.class, ""));
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO) getVO(request,
					AgtAgnAgmtVO.class));
			break;
		case FormCommand.ADD:
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[]) getVOs(request,
					AgtAgnAgmtVO.class, ""));
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO) getVO(request,
					AgtAgnAgmtVO.class));
			break;
		case FormCommand.MULTI:
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[]) getVOs(request,
					AgtAgnAgmtVO.class, ""));
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO) getVO(request,
					AgtAgnAgmtVO.class));
			break;
		case FormCommand.COMMAND01:
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[]) getVOs(request,
					AgtAgnAgmtVO.class, ""));
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO) getVO(request,
					AgtAgnAgmtVO.class));
			break;
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