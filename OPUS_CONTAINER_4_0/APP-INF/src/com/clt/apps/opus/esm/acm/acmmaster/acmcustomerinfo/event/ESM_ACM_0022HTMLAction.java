/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0022HTMLAction.java
*@FileTitle : Customer-Vendor Match for Special Compensation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.CustVendorMatchForSCompVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.acm.acmmaster 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ACMMasterSC로 실행요청<br>
 * - ACMMasterSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see EsmAcm0022Event 참조
 * @since J2EE 1.6
 */

public class ESM_ACM_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_ACM_0022HTMLAction 객체를 생성
	 */
	public ESM_ACM_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ACMMasterEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmAcm0022Event event = new EsmAcm0022Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setCustVendorMatchForSCompVO((CustVendorMatchForSCompVO)getVO(request, CustVendorMatchForSCompVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setCustVendorMatchForSCompVOs((CustVendorMatchForSCompVO[])getVOs(request, CustVendorMatchForSCompVO.class, ""));
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