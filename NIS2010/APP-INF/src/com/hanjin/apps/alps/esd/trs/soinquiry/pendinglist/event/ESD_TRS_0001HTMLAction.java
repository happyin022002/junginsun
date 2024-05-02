/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_001HTMLAction.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-18 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.soinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_0001SC로 실행요청<br>
 * - ESD_TRS_0001SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author juhyun
 * @see EsdTrs0001Event , ESD_TRS_001EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0001HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_001HTMLAction 객체를 생성
	 */
	public ESD_TRS_0001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0001Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		    
//		    FormCommand command = FormCommand.fromRequest(request);
		    
		    EsdTrs0001Event event = new EsdTrs0001Event();

		    String hid_from_date  = request.getParameter("hid_from_date");
		    String hid_to_date    = request.getParameter("hid_to_date");
		    String hid_cargo      = request.getParameter("hid_cargo");
		    String hid_bound      = request.getParameter("hid_bound");
		    String hid_cost       = request.getParameter("hid_cost");
		    String sel_transmode  = request.getParameter("sel_transmode");
		    String hid_rhq        = request.getParameter("hid_rhq");
		    
		    String ofc_cd         = request.getParameter("ofc_cd");
		    String trunk_vvd      = JSPUtil.getParameter(request,"trunk_vvd","");	
		    String trunk_vvd1     = "";
		    String trunk_vvd2     = "";
		    String trunk_vvd3     = "";
		    
            if( !(trunk_vvd == null || trunk_vvd.equals("")) ){
		           trunk_vvd1     = trunk_vvd.substring(0,4);
		           trunk_vvd2     = trunk_vvd.substring(4,8);
		           trunk_vvd3     = trunk_vvd.substring(8,9);
            }
		    
		    event.setHid_from_date(hid_from_date);
		    event.setHid_to_date(hid_to_date);
		    event.setHid_cargo(hid_cargo);
		    event.setHid_bound(hid_bound);
		    event.setHid_cost(hid_cost);
		    event.setSel_transmode(sel_transmode);
		    event.setHid_rhq(hid_rhq);
		    
		    event.setOfc_cd(ofc_cd);
		    event.setTrunk_vvd(trunk_vvd);
		    event.setTrunk_vvd1(trunk_vvd1);
		    event.setTrunk_vvd2(trunk_vvd2);
		    event.setTrunk_vvd3(trunk_vvd3);

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