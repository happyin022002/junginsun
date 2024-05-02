/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0115HTMLAction.java
*@FileTitle : ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1		1.0		ShinYongChan		2006-09-06		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.10		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.06.30
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.EqrEccMstVO;
import com.clt.syscommon.common.table.EqrTsTmlVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event 로 변환, request 에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request 에 셋팅<br>
 * @author 
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0115HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_115HTMLAction 객체를 생성
	 */
	public EES_EQR_0115HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request 에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface 를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0115Event event = new EesEqr0115Event();
		String status	= JSPUtil.getParameter(request, "status", "");
		String location	= JSPUtil.getParameter(request, "location", "");
		String eccCd = JSPUtil.getParameter(request, "ecc_cd", "");
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setStatus(status);
			event.setLocation(location);
			
		// TS 컬럼 클릭시
		} else if (command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setEccCd(eccCd);
			
		// Save 버튼 클릭시, TS더블클릭시 SHEET2에 수정된 데이타 있는 경우
		} else if (command.isCommand(FormCommand.MODIFY)) {
			event.setEqrEccMstVOS(new EqrEccMstVO().fromRequestGrid(request, ""));
			event.setEqrTsTmlVOS(new EqrTsTmlVO().fromRequestGrid1(request, ""));
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute 에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request 에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface 를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute 에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request 에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface 를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}