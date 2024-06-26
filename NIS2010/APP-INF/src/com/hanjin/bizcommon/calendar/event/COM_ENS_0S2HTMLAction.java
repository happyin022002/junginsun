/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0S1HTMLAction.java
*@FileTitle : country
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-03
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-11-03 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.calendar.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon.calendar 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hyung Choon_Roh
 * @see ComEns0S1Event , COM_ENS_0S1EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_ENS_0S2HTMLAction extends HTMLActionSupport {

	/**
	 * COM_ENS_0S1HTMLAction 객체를 생성
	 */
	public COM_ENS_0S2HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 COM_ENS_0S1Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		String cnt_cd = JSPUtil.getParameter(request, "cnt_cd_ste".trim(), "");
		String ste_cd = JSPUtil.getParameter(request, "ste_cd_ste".trim(), "");
    	String frDate = JSPUtil.getParameter(request, "frDate_ste".trim(), "");
    	String toDate = JSPUtil.getParameter(request, "toDate_ste".trim(), "");
    	
    	frDate = frDate.replaceAll("-", "");
    	toDate = toDate.replaceAll("-", "");
    	
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	ComEns0S2Event event = new ComEns0S2Event();
    	
		if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
	        event = new ComEns0S2Event(cnt_cd, ste_cd, frDate, toDate, iPage);
		} 
		else if (f_cmd.isCommand(FormCommand.MULTI)) { // Save 버튼 클릭 시
			event.setSte_cd(ste_cd);
			
			event.putValue("ibflag", 		  	request.getParameterValues("ibflag"));
			event.putValue("hol_id",  			request.getParameterValues("hol_id"));
			event.putValue("hol_nm",       	  	request.getParameterValues("hol_nm"));
			event.putValue("cnt_cd", 		  	request.getParameterValues("cnt_cd"));
			event.putValue("ste_cd", 		  	request.getParameterValues("ste_cd"));
			event.putValue("frDate",    		request.getParameterValues("frDate"));
			event.putValue("toDate",    		request.getParameterValues("toDate"));
			event.putValue("hol_knd_cd",    		request.getParameterValues("hol_knd_cd"));
    	}
                 
        event.setCommandClassName("BizCommonSC");
        event.setFormCommand(f_cmd);
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