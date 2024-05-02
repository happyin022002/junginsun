/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1052HTMLAction.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_1052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_1052HTMLAction 객체를 생성
	 */
	public EES_EQR_1052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1052Event event = new EesEqr1052Event();
		
		EesEqr1052MultiVO eesEqr1052MultiVO = new EesEqr1052MultiVO();		
		event.setEesEqr1052ConditionVO((EesEqr1052ConditionVO)getVO(request, EesEqr1052ConditionVO .class)); 

		if(command.isCommand(FormCommand.SEARCH02) || 
		   command.isCommand(FormCommand.SEARCH04) || 
		   command.isCommand(FormCommand.SEARCH06)) { // POD, TO ETB조회 
			String vvd = request.getParameter("vvd");
			event.setAttribute("vvd", vvd);

		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr1052MultiVOs((EesEqr1052MultiVO[])eesEqr1052MultiVO.fromRequestGrid(request, ""));
			
		} else if(command.isCommand(FormCommand.SEARCH05)) {
			String vvd           = request.getParameter("vvd");
			String excel_cntr_no = request.getParameter("excel_cntr_no");
			String flag          = request.getParameter("flag");
			
			event.setAttribute("vvd", vvd);
			event.setAttribute("excel_cntr_no", excel_cntr_no);
			event.setAttribute("flag", flag);
			
		} else if(command.isCommand(FormCommand.SEARCH03)) {  // SPLIT POD 정보 조회
			String vvd     = request.getParameter("vvd");
			String vvd_rob = request.getParameter("vvd_rob");
			String open_flag_rob= request.getParameter("open_flag_rob"); // hidden 값을 대신 사용함() (1:checked, 0:unchecked)
			
			log.debug("\n------------------------- open_flag_rob : " + open_flag_rob);
			
			event.setAttribute("vvd", 			vvd);
			event.setAttribute("vvd_rob", 		vvd_rob);
			event.setAttribute("open_flag_rob", open_flag_rob);			
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