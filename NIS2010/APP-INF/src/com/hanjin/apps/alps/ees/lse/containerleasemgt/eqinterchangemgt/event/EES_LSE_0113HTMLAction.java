/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0113HTMLAction.java
*@FileTitle : Oneway Loading PFMC 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.10
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.04.10 두기민
* 1.0 Creation
* 2016-04-10 [CHM-201640528] Oneway Loading PFMC 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Doo Ki Min
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0113HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0113HTMLAction 객체를 생성
	 */
	public EES_LSE_0113HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesLse0113Event event = new EesLse0113Event();
    	
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setOrgCntrTpszCd(request.getParameter("org_cntr_tpsz_cd"));
			event.setDpsl(request.getParameter("dpsl"));
			event.setTrd(request.getParameter("trd"));
			event.setLocTo(request.getParameter("loc_to"));
			event.setPeriod(request.getParameter("period"));
			event.setFroms(request.getParameter("froms"));
			event.setTos(request.getParameter("tos_h"));
			event.setDelDol(request.getParameter("del_dol"));
			event.setPorDol(request.getParameter("por_dol"));
			event.setIfFlg(request.getParameter("if_flg"));
			event.setMvmt(request.getParameter("mvmt"));
			event.setLocTp(request.getParameter("loc_tp"));
			event.setTabFlg(request.getParameter("tabFlg"));
		}
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setAvailableOnewayInventoryVOS((AvailableOnewayInventoryVO[])getVOs(request, AvailableOnewayInventoryVO .class,""));
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
	@Override
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