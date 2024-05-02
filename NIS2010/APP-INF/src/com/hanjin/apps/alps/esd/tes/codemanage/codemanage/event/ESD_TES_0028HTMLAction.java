/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_028HTMLAction.java
*@FileTitle : Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-05
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-05 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TesLgsCostVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 costcodeinquirySC로 실행요청<br>
 * - costcodeinquirySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jongbaemoon
 * @see EsdTes0028Event , ESD_TES_028EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0028HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_028HTMLAction 객체를 생성
	 */
	public ESD_TES_0028HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_028Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		String param_name = null;
		java.util.Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
		}
		
		EsdTes0028Event event = new EsdTes0028Event(); 
		
		event.setTesLgsCostVO( (TesLgsCostVO)getVO( request, TesLgsCostVO.class ) );

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