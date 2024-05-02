/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0233HTMLAction.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-05-17
 *@LastModifier : pjy
 *@LastVersion : 1.0
 * 2010-05-17 pjy
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0233Event;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0223Event , ESD_TRS_0223EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0233HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0233HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTrs0233Event event = new EsdTrs0233Event();
		
		String comboSvcProvider = JSPUtil.getNull(request.getParameter("combo_svc_provider"));
		String agmtRefNo = JSPUtil.getNull(request.getParameter("agmt_ref_no"));
		String ctrtOfcCd = JSPUtil.getNull(request.getParameter("ctrt_ofc_cd"));
		String agmt_no    = JSPUtil.getNull(request.getParameter("agmt_no"));
		
		event.setComboSvcProvider(comboSvcProvider);
		event.setAgmtRefNo(agmtRefNo);
		event.setCtrtOfcCd(ctrtOfcCd);	
		event.setAgmtNo(agmt_no);	

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