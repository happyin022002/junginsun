/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0D1HTMLAction.java
*@FileTitle : Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-13 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.surcharge.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hyung Choon_Roh
 * @see ComEns0D1Event , COM_ENS_0D1EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_ENS_0D1HTMLAction extends HTMLActionSupport {

	/**
	 * COM_ENS_0D1HTMLAction 객체를 생성
	 */
	public COM_ENS_0D1HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 COM_ENS_0D1Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		// 메인화면에서 Country 팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우
    	String conti_cd = JSPUtil.getParameter(request, "conti_cd".trim(), "");
    	String sconti_cd = JSPUtil.getParameter(request, "sconti_cd".trim(), "");
    	String cnt_cd = JSPUtil.getParameter(request, "cnt_cd".trim(), "");
    	String cnt_nm = JSPUtil.getParameter(request, "cnt_nm".trim(), "");
    	
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	ComEns0D1Event event = new ComEns0D1Event(conti_cd, sconti_cd, cnt_cd, cnt_nm, iPage);
                 
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