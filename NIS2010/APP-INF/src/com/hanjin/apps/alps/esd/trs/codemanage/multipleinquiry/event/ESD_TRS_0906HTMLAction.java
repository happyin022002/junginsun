/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_TRS_0906HTMLAction.java
 *@FileTitle : TRS Invoice Authority
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.16
 *@LastModifier : 유선오
 *@LastVersion : 1.2
 * 2011.11.09 SunOh,You
 * 1.0 Creation
-------------------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.multipleinquiry.event;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 USADeliveryOrderManageSC로 실행요청<br>
 * - USADeliveryOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Yoo,SunOh
 * @see EsdTrs0976Event , ESD_TRS_0906EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0906HTMLAction extends HTMLActionSupport {

	/**
	 *serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0906HTMLAction 객체를 생성
	 */
	public ESD_TRS_0906HTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0976Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event Interface 를 구현한 객체
	 * @exception HTMLActionException
	 */	
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		return null;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 * @param eventResponse         
	 */

	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
