/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_5002HTMLAction.java
*@FileTitle : MTY Repo In/ Out Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.11 김종준
* 1.0 Creation
=========================================================*/ 
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.mtyequipmentforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MTYEquipmentForecastSC로 실행요청<br>
 * - MTYEquipmentForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see MTYEquipmentForecastEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_5009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_5002HTMLAction 객체를 생성
	 */
	public EES_EQR_5009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MTYEquipmentForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr5009Event event = new EesEqr5009Event();
		
		String fcast_yrwk 	= request.getParameter("fcast_yrwk");
		String loc_cd 		= request.getParameter("loc_cd");
		String loc_grp_cd 	= request.getParameter("loc_grp_cd");
		String repo_pln_yrwk= request.getParameter("repo_pln_yrwk");	
		String dp_seq 		= request.getParameter("dp_seq");
		String row    		= request.getParameter("row");
		String wk_st_dt    	= request.getParameter("wk_st_dt");
		String level_cd    	= request.getParameter("level_cd"); // 버튼 수정 가능여부 결정, 1 만 수정가능
		
		log.debug(">>>>>>>>>>>> row : " + row);
		
		event.setAttribute("fcast_yrwk", fcast_yrwk);
		event.setAttribute("loc_cd", loc_cd);
		event.setAttribute("loc_grp_cd", loc_grp_cd);
		event.setAttribute("repo_pln_yrwk", repo_pln_yrwk);
		event.setAttribute("dp_seq", dp_seq);
		event.setAttribute("row", row);
		event.setAttribute("wk_st_dt", wk_st_dt);		
		event.setAttribute("level_cd", level_cd);			
		
		event.setMtyBalanceOptionVO((MtyBalanceOptionVO)getVO(request, MtyBalanceOptionVO .class));
		event.setMtyBalanceRepoListVO((MtyBalanceRepoListVO)getVO(request, MtyBalanceRepoListVO .class));
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMtyBalanceRepoListVOS((MtyBalanceRepoListVO[])getVOs(request, MtyBalanceRepoListVO .class,""));
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