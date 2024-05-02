/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0150HTMLAction.java
*@FileTitle : Dwell/Delay Notification Sending Status
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.07.20 이수진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.copmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CopManageSC로 실행요청<br>
 * - CopManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sujin lee
 * @see EsdSce0150Event 참조
 * @since J2EE 1.6
 */
public class ESD_SCE_0150HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_SCE_0140HTMLAction 객체를 생성
	 */
	public ESD_SCE_0150HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VisibilityManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	EsdSce0150Event event = new EsdSce0150Event();
		
	//	event.setDwellNofifySendStsVOs((DwellNofifySendStsVOs)getVO(request, DwellNofifySendStsVOs.class, ""));
    	event.setStartDt(JSPUtil.getParameter(request, "start_dt", ""));
    	event.setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
    	event.setScNo(JSPUtil.getParameter(request, "sc_no", ""));
    	event.setScNo2(JSPUtil.getParameter(request, "sc_no2", ""));
    	event.setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
    	event.setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));

    	log.debug("LSJ========================\n" + event.getScNo());
    	log.debug(event.getStartDt());
    	
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
