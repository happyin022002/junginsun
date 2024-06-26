/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_MNR_0257HTMLAction.java
*@FileTitle : Hanger Rack/Bar Using Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.12.20 김상수
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.HangerRackReportVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyungSeok Ham
 * @see EesMnr0257Event 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0257HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0257HTMLAction 객체를 생성
	 */
	public EES_MNR_0257HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0257Event event = new EesMnr0257Event();

		//조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setHangerRackReportVO((HangerRackReportVO)getVO(request, HangerRackReportVO.class));
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