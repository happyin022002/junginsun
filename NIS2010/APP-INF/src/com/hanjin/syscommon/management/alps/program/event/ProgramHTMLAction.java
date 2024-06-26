/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProgramHTMLAction.java
*@FileTitle : Program Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.17 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.program.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.ComProgramVO;

/**
 * HTTP Parser<br>
 * - NIS2010.APP-INF.src.com.hanjin.syscommon.nis2010.management.programmanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProgramManagementSC로 실행요청<br>
 * - ProgramManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KyungBum Kim
 * @see ProgramManagementEvent 참조
 * @since J2EE 1.4
 */

public class ProgramHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4972226447003486113L;

	/**
	 * ProgramHTMLAction 객체를 생성
	 */
	public ProgramHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProgramManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */ 
    	FormCommand command = FormCommand.fromRequest(request);

		ComProgramVO[] multicomprogramvos = null;
		ComProgramVO comprogramvo = new ComProgramVO();
        
		String prefix = "";
		ProgramManagementEvent event = null;
		if(command.isCommand(FormCommand.MULTI)) {
			multicomprogramvos = comprogramvo .fromRequestGrid(request,prefix);
			event = new ProgramManagementEvent(null, multicomprogramvos);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			comprogramvo.setPgmNo(JSPUtil.getParameter(request, "s_pgm_no", ""));
			comprogramvo.setPgmNm(JSPUtil.getParameter(request, "s_pgm_nm", ""));
			comprogramvo.setPgmTpCd(JSPUtil.getParameter(request, "s_pgm_tp_cd", ""));
			comprogramvo.setPgmMnuDivCd(JSPUtil.getParameter(request, "s_pgm_mnu_div_cd", ""));
			comprogramvo.setPgmUseFlg(JSPUtil.getParameter(request, "s_pgm_use_flg", ""));
			
			
			event = new ProgramManagementEvent(comprogramvo);
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