/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_0999HTMLAction.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.event;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.aoc.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Min Jung Ho
 * @see CommonEvent 참조
 * @since J2EE 1.6
 */

public class ESD_AOC_0999HTMLAction extends HTMLActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_AOC_0999HTMLAction 객체를 생성
	 */
	public ESD_AOC_0999HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {		
		EsdAoc0999Event event = new EsdAoc0999Event();
		
		FormCommand   command = FormCommand.fromRequest(request);
        if( command.isCommand(FormCommand.SEARCH01) ){
        	event.setFChkPrd(JSPUtil.getParameter(request, "f_chkprd", ""));
        	event.setFYear(JSPUtil.getParameter(request, "f_year", ""));
        	event.setIFmWm(JSPUtil.getParameter(request, "i_fm_wm", ""));
        	event.setIToWm(JSPUtil.getParameter(request, "i_to_wm", ""));
        } else if( command.isCommand(FormCommand.SEARCH02) ){
        	String ctrl_so_office = request.getParameter("ctrl_so_office")!=null?request.getParameter("ctrl_so_office"):"";
        	event.setCtrl_so_office(ctrl_so_office);
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