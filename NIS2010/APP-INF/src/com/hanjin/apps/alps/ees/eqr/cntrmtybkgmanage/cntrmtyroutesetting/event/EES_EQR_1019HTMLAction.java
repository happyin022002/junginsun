/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1019HTMLAction.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.07.30 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_1019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_1019HTMLAction 객체를 생성
	 */
	public EES_EQR_1019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1019Event event = new EesEqr1019Event();

		EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO = new EesEqr1019RouteSettingVO();		
		event.setEesEqr1019RouteSettingVO((EesEqr1019RouteSettingVO)getVO(request, EesEqr1019RouteSettingVO .class));
		
		// Sheet1 update, insert, delete 정보를 받기
		if(command.isCommand(FormCommand.MULTI) 
			|| command.isCommand(FormCommand.MULTI01)
			|| command.isCommand(FormCommand.MULTI02)){		
			event.setEesEqr1019RouteSettingVOs((EesEqr1019RouteSettingVO[])eesEqr1019RouteSettingVO.fromRequestGrid(request, ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST)){ // VVD 존재 조회
			String rcccd = request.getParameter("p_rcc_cd");
			String loccd = request.getParameter("s_loc_cd");
			event.setAttribute("p_rcc_cd", rcccd);
			event.setAttribute("s_loc_cd", loccd);
		}else if(command.isCommand(FormCommand.SEARCH01)){ // VVD 존재 조회
			String flag = request.getParameter("plodg_dchg_div_cd");
			String loccd = request.getParameter("p_loc_cd");
			event.setAttribute("plodg_dchg_div_cd", flag);
			event.setAttribute("p_loc_cd", loccd);
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