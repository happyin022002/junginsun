/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_9999HTMLAction.java
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영
* 1.0 Creation
* 
* 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경) Ticket ID : ITM-201003077
*                  level 인자추가
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author OKYOUNG IM
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_AssignHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_AssignHTMLAction 객체를 생성
	 */
	public ESM_COA_AssignHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCoaAssignEvent event = new EsmCoaAssignEvent();
log.debug("\nooooooooooooooESM_COA_AssignHTMLAction perform");	
    	if(command.isCommand(FormCommand.SEARCHLIST)) {
log.debug("\nooooooooooooooESM_COA_AssignHTMLAction SEARCHLIST = " + FormCommand.SEARCHLIST);			
			event.setFCoaBatCd(JSPUtil.getNull(request.getParameter("f_coa_bat_cd")));
		} else if(command.isCommand(FormCommand.COMMAND21)) {//PRD (createCostAssignPrd) 수행시
			//이전 프로그램과 호환을 위해, 타 모듈에서 start_pctl_no, end_pctl_no로도 사용할 수 있으므로 아래와 같이 처리 
			if(request.getParameter("start_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("start_pctl_no")));
			else  if(request.getParameter("f_start_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("f_start_pctl_no")));			
			if(request.getParameter("end_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("end_pctl_no")));
			else  if(request.getParameter("f_end_pctl_no") != null) event.setFEndPctlNo(JSPUtil.getNull(request.getParameter("f_end_pctl_no")));
		} else if(command.isCommand(FormCommand.COMMAND22)) {//COP (createCostAssignCop) 
			//이전 프로그램과 호환을 위해, 타 모듈에서 bkg_no, del_para로도 사용할 수 있으므로 아래와 같이 처리 
			if(request.getParameter("bkg_no") != null) event.setFBkgNo(JSPUtil.getNull(request.getParameter("bkg_no")));
			else  if(request.getParameter("f_bkg_no") != null) event.setFBkgNo(JSPUtil.getNull(request.getParameter("f_bkg_no")));	
			if(request.getParameter("f_del_para") != null) event.setFDelPara(JSPUtil.getNull(request.getParameter("f_del_para")));
			else if(request.getParameter("del_para") != null) event.setFDelPara(JSPUtil.getNull(request.getParameter("del_para")));	
			event.setFLevel(JSPUtil.getNull(request.getParameter("f_level")));
		} else if(command.isCommand(FormCommand.COMMAND23)) {//COP (createCostAssignCop) 
			//이전 프로그램과 호환을 위해, 타 모듈에서start_pctl_no, end_pctl_no, bkg_no, del_para로도 사용할 수 있으므로 아래와 같이 처리 
			if(request.getParameter("start_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("start_pctl_no")));
			else  if(request.getParameter("f_start_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("f_start_pctl_no")));			
			if(request.getParameter("end_pctl_no") != null) event.setFStartPctlNo(JSPUtil.getNull(request.getParameter("end_pctl_no")));
			else  if(request.getParameter("f_end_pctl_no") != null) event.setFEndPctlNo(JSPUtil.getNull(request.getParameter("f_end_pctl_no")));
			if(request.getParameter("bkg_no") != null) event.setFBkgNo(JSPUtil.getNull(request.getParameter("bkg_no")));
			else  if(request.getParameter("f_bkg_no") != null) event.setFBkgNo(JSPUtil.getNull(request.getParameter("f_bkg_no")));	
			if(request.getParameter("f_del_para") != null) event.setFDelPara(JSPUtil.getNull(request.getParameter("f_del_para")));
			else if(request.getParameter("del_para") != null) event.setFDelPara(JSPUtil.getNull(request.getParameter("del_para")));	
		}
log.debug("\n\n bkg_no = "  + event.getFBkgNo());
log.debug("\n del_para = "  + event.getFDelPara());
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